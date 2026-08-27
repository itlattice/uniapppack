package uts.sdk.modules.iboxsTts

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import android.util.Log
import com.k2fsa.sherpa.onnx.GeneratedAudio
import com.k2fsa.sherpa.onnx.FeatureConfig
import com.k2fsa.sherpa.onnx.HomophoneReplacerConfig
import com.k2fsa.sherpa.onnx.OfflineCanaryModelConfig
import com.k2fsa.sherpa.onnx.OfflineCohereTranscribeModelConfig
import com.k2fsa.sherpa.onnx.OfflineDolphinModelConfig
import com.k2fsa.sherpa.onnx.OfflineFireRedAsrCtcModelConfig
import com.k2fsa.sherpa.onnx.OfflineFireRedAsrModelConfig
import com.k2fsa.sherpa.onnx.OfflineFunAsrNanoModelConfig
import com.k2fsa.sherpa.onnx.OfflineMedAsrCtcModelConfig
import com.k2fsa.sherpa.onnx.OfflineModelConfig
import com.k2fsa.sherpa.onnx.OfflineMoonshineModelConfig
import com.k2fsa.sherpa.onnx.OfflineNemoEncDecCtcModelConfig
import com.k2fsa.sherpa.onnx.OfflineOmnilingualAsrCtcModelConfig
import com.k2fsa.sherpa.onnx.OfflineParaformerModelConfig
import com.k2fsa.sherpa.onnx.OfflineQwen3AsrModelConfig
import com.k2fsa.sherpa.onnx.OfflineRecognizer
import com.k2fsa.sherpa.onnx.OfflineRecognizerConfig
import com.k2fsa.sherpa.onnx.OfflineRecognizerResult
import com.k2fsa.sherpa.onnx.OfflineSenseVoiceModelConfig
import com.k2fsa.sherpa.onnx.OfflineTransducerModelConfig
import com.k2fsa.sherpa.onnx.OfflineWenetCtcModelConfig
import com.k2fsa.sherpa.onnx.OfflineWhisperModelConfig
import com.k2fsa.sherpa.onnx.OfflineZipformerCtcModelConfig
import com.k2fsa.sherpa.onnx.OfflineTts
import com.k2fsa.sherpa.onnx.OfflineTtsConfig
import com.k2fsa.sherpa.onnx.OfflineTtsKittenModelConfig
import com.k2fsa.sherpa.onnx.OfflineTtsKokoroModelConfig
import com.k2fsa.sherpa.onnx.OfflineTtsMatchaModelConfig
import com.k2fsa.sherpa.onnx.OfflineTtsModelConfig
import com.k2fsa.sherpa.onnx.OfflineTtsPocketModelConfig
import com.k2fsa.sherpa.onnx.OfflineTtsSupertonicModelConfig
import com.k2fsa.sherpa.onnx.OfflineTtsVitsModelConfig
import com.k2fsa.sherpa.onnx.OfflineTtsZipVoiceModelConfig
import java.io.File
import java.util.concurrent.atomic.AtomicBoolean
import io.dcloud.uts.console

object TTSManager {

    /**
     * 初始化回调。
     */
    interface InitCallback {
        /**
         * 初始化成功时回调。
         */
        fun onSuccess()

        /**
         * 初始化失败时回调。
         * @param error 失败原因。
         */
        fun onError(error: Throwable)
    }

    /**
     * 语音播放回调。
     */
    interface SpeakCallback {
        /**
         * 开始播放时回调。
         */
        fun onStart()

        /**
         * 播放完成时回调。
         */
        fun onComplete()

        /**
         * 播放失败时回调。
         * @param error 失败原因。
         */
        fun onError(error: Throwable)
    }

    /**
     * 语音识别回调。
     */
    interface RecognizeCallback {
        /**
         * 识别成功时回调。
         * @param result 识别结果。
         */
        fun onSuccess(result: OfflineRecognizerResult)

        /**
         * 识别失败时回调。
         * @param error 失败原因。
         */
        fun onError(error: Throwable)
    }

    private const val PLAYBACK_DRAIN_TIMEOUT_MS = 15000L
    private const val DEFAULT_SAMPLE_RATE = 22050
    private const val TAG = "SherpaTTS"
    private const val DEFAULT_ASR_SAMPLE_RATE = 16000
    private const val DEFAULT_ASR_FEATURE_DIM = 80

    private var tts: OfflineTts? = null
    private var recognizer: OfflineRecognizer? = null
    private var audioTrack: AudioTrack? = null
    private var sampleRate: Int = DEFAULT_SAMPLE_RATE
    private val isSpeaking = AtomicBoolean(false)
    private val isInitializingTts = AtomicBoolean(false)
    private val isInitializingRecognizer = AtomicBoolean(false)
    @Volatile
    private var stopRequested = false

    /**
     * 初始化离线语音合成引擎。
      * @param context Android 上下文，用于读取 assets 中的模型文件。
      * @param modelDirName assets 中的 TTS 模型目录名，默认是 tts_model。
      * @param numThreads 推理线程数，影响速度和 CPU 占用。
      * @param provider 推理后端名称，通常使用 cpu。
      * @param callback 初始化结果回调，可为空。
     */
    fun init(
        context: Context,
        modelDirName: String = "tts_model",
        numThreads: Int = 2,
        provider: String = "cpu",
        callback: InitCallback? = null
    ) {
        if (tts != null) {
            callback?.onSuccess()
            return
        }
        if (!isInitializingTts.compareAndSet(false, true)) {
            callback?.onError(IllegalStateException("TTS engine is initializing"))
            return
        }

        Thread {
            if (tts != null) {
                isInitializingTts.set(false)
                callback?.onSuccess()
                return@Thread
            }

            try {
                require(assetPathExists(context, modelDirName)) {
                    "TTS model directory not found in assets: $modelDirName"
                }

                val config = buildOfflineTtsConfig(context, modelDirName, numThreads, provider)

                tts = OfflineTts(
                    context.assets,
                    config
                )

                sampleRate = tts?.sampleRate() ?: DEFAULT_SAMPLE_RATE
                initAudioTrack()
                callback?.onSuccess()
            } catch (error: Throwable) {
                callback?.onError(error)
            } finally {
                isInitializingTts.set(false)
            }
        }.start()
    }

    /**
     * 初始化离线语音识别引擎。
     * @param context Android 上下文，用于读取 assets 中的识别模型。
     * @param modelDirName assets 中的 ASR 模型目录名，默认是 asr_model。
     * @param numThreads 推理线程数，影响速度和 CPU 占用。
     * @param provider 推理后端名称，通常使用 cpu。
     * @param callback 初始化结果回调，可为空。
     */
    fun initRecognizer(
        context: Context,
        modelDirName: String = "asr_model",
        numThreads: Int = 2,
        provider: String = "cpu",
        callback: InitCallback? = null
    ) {
        if (recognizer != null) {
            callback?.onSuccess()
            return
        }
        if (!isInitializingRecognizer.compareAndSet(false, true)) {
            callback?.onError(IllegalStateException("ASR recognizer is initializing"))
            return
        }

        Thread {
            if (recognizer != null) {
                isInitializingRecognizer.set(false)
                callback?.onSuccess()
                return@Thread
            }

            try {
                require(assetPathExists(context, modelDirName)) {
                    "ASR model directory not found in assets: $modelDirName"
                }

                val config = buildOfflineRecognizerConfig(context, modelDirName, numThreads, provider)
                recognizer = OfflineRecognizer(context.assets, config)
                callback?.onSuccess()
            } catch (error: Throwable) {
                callback?.onError(error)
            } finally {
                isInitializingRecognizer.set(false)
            }
        }.start()
    }

    fun isInitialized(): Boolean = tts != null

    fun isRecognizerInitialized(): Boolean = recognizer != null

    fun isSpeaking(): Boolean = isSpeaking.get()

    fun numSpeakers(): Int = tts?.numSpeakers() ?: 0

    private fun initAudioTrack() {
        val minBufferSize = AudioTrack.getMinBufferSize(
            sampleRate,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_FLOAT
        ).coerceAtLeast(sampleRate * 4)

        audioTrack?.release()

        audioTrack = AudioTrack.Builder()
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build()
            )
            .setAudioFormat(
                AudioFormat.Builder()
                    .setSampleRate(sampleRate)
                    .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                    .setEncoding(AudioFormat.ENCODING_PCM_FLOAT)
                    .build()
            )
            .setBufferSizeInBytes(minBufferSize)
            .build()
    }

    /**
     * 播放语音。
     * @param text 要合成的文本内容。
     * @param speakerId 说话人编号，多说话人模型时生效。
     * @param speed 语速倍率，1.0f 表示默认语速。
     * @param callback 播放过程回调，可为空。
     */
    fun speak(text: String, speakerId: Int = 0, speed: Float = 1.0f, callback: SpeakCallback? = null) {
        val engine = tts ?: run {
            callback?.onError(IllegalStateException("TTS engine is not initialized"))
            return
        }
        val normalizedText = text.trim()
        if (normalizedText.isEmpty()) {
            callback?.onError(IllegalArgumentException("Text must not be empty"))
            return
        }
        if (isSpeaking.getAndSet(true)) {
            callback?.onError(IllegalStateException("TTS is already speaking"))
            return
        }

        stopRequested = false

        Thread {
            try {
                callback?.onStart()
                val audio = engine.generate(normalizedText, speakerId, speed)
                if (!stopRequested) {
                    playAudio(audio)
                }
                Log.d(TAG, "generate text=$normalizedText samples=${audio.samples.size} sampleRate=${audio.sampleRate}")
                callback?.onComplete()
            } catch (e: Exception) {
                e.printStackTrace()
                callback?.onError(e)
            } finally {
                isSpeaking.set(false)
                stopRequested = false
            }
        }.start()
    }

    /**
     * 执行一次离线语音识别。
     * @param samples PCM 浮点音频数据。
     * @param sampleRate 音频采样率，默认 16000。
     * @param callback 识别结果回调。
     */
    fun recognize(samples: FloatArray, sampleRate: Int = DEFAULT_ASR_SAMPLE_RATE, callback: RecognizeCallback) {
        val engine = recognizer ?: run {
            callback.onError(IllegalStateException("ASR recognizer is not initialized"))
            return
        }

        if (samples.isEmpty()) {
            callback.onError(IllegalArgumentException("Audio samples must not be empty"))
            return
        }

        Thread {
            try {
                val stream = engine.createStream()
                try {
                    stream.acceptWaveform(samples, sampleRate)
                    engine.decode(stream)
                    callback.onSuccess(engine.getResult(stream))
                } finally {
                    stream.release()
                }
            } catch (error: Throwable) {
                callback.onError(error)
            }
        }.start()
    }

    fun stop() {
        stopRequested = true
        runCatching {
            audioTrack?.pause()
            audioTrack?.flush()
            audioTrack?.stop()
        }
        isSpeaking.set(false)
    }

    @Synchronized
    fun release() {
        stop()
        audioTrack?.release()
        audioTrack = null
        tts?.release()
        tts = null
        recognizer?.release()
        recognizer = null
        sampleRate = DEFAULT_SAMPLE_RATE
    }

    private fun playAudio(audio: GeneratedAudio) {
        val samples = audio.samples
        if (samples.isEmpty()) return

        if (audio.sampleRate != sampleRate || audioTrack == null) {
            sampleRate = audio.sampleRate
            initAudioTrack()
        }

        val track = audioTrack ?: return
        track.pause()
        track.flush()
        track.play()

        var offset = 0
        while (offset < samples.size && !stopRequested) {
            val written = track.write(samples, offset, samples.size - offset, AudioTrack.WRITE_BLOCKING)
            if (written <= 0) break
            offset += written
        }

        waitForPlaybackToDrain(track, samples.size)

        runCatching {
            if (track.playState == AudioTrack.PLAYSTATE_PLAYING) {
                track.stop()
            }
            track.flush()
        }
    }

    private fun waitForPlaybackToDrain(track: AudioTrack, totalFrames: Int) {
        val startedAt = System.currentTimeMillis()
        while (!stopRequested && track.playState == AudioTrack.PLAYSTATE_PLAYING) {
            val playedFrames = track.playbackHeadPosition
            if (playedFrames >= totalFrames) {
                return
            }

            if (System.currentTimeMillis() - startedAt > PLAYBACK_DRAIN_TIMEOUT_MS) {
                Log.w(TAG, "Timed out waiting for playback drain: played=$playedFrames total=$totalFrames")
                return
            }

            Thread.sleep(20)
        }
    }

    private fun buildOfflineTtsConfig(context: Context, modelDirName: String, numThreads: Int, provider: String): OfflineTtsConfig {
        val modelConfig = OfflineTtsModelConfig(
            detectVitsConfig(context, modelDirName),
            detectMatchaConfig(context, modelDirName),
            detectKokoroConfig(context, modelDirName),
            detectZipVoiceConfig(context, modelDirName),
            detectKittenConfig(context, modelDirName),
            detectPocketConfig(context, modelDirName),
            detectSupertonicConfig(context, modelDirName),
            numThreads,
            false,
            provider
        )

        require(hasAtLeastOneModel(modelConfig)) {
            "Unsupported TTS model layout in assets/$modelDirName"
        }

        return OfflineTtsConfig(
            modelConfig,
            buildRuleFsts(context, modelDirName),
            "",
            1,
            1.0f
        )
    }

    private fun buildOfflineRecognizerConfig(
        context: Context,
        modelDirName: String,
        numThreads: Int,
        provider: String
    ): OfflineRecognizerConfig {
        val tokens = findFirstExistingAsset(context, modelDirName, "tokens.txt")
            ?: throw IllegalArgumentException("ASR tokens.txt not found in assets/$modelDirName")

        val transducerEncoder = findFirstExistingAsset(context, modelDirName, "encoder.onnx")
        val transducerDecoder = findFirstExistingAsset(context, modelDirName, "decoder.onnx")
        val transducerJoiner = findFirstExistingAsset(context, modelDirName, "joiner.onnx")
        val paraformerModel = findFirstExistingAsset(context, modelDirName, "model.onnx", "paraformer.onnx")
        val senseVoiceModel = findFirstExistingAsset(context, modelDirName, "sense-voice.onnx", "model.onnx")

        val transducerConfig = OfflineTransducerModelConfig().apply {
            encoder = transducerEncoder.orEmpty()
            decoder = transducerDecoder.orEmpty()
            joiner = transducerJoiner.orEmpty()
        }

        val paraformerConfig = OfflineParaformerModelConfig().apply {
            model = if (transducerEncoder == null) paraformerModel.orEmpty() else ""
        }

        val senseVoiceConfig = OfflineSenseVoiceModelConfig().apply {
            model = if (transducerEncoder == null) senseVoiceModel.orEmpty() else ""
        }

        require(
            transducerConfig.encoder.isNotBlank() ||
                paraformerConfig.model.isNotBlank() ||
                senseVoiceConfig.model.isNotBlank()
        ) {
            "ASR model file not found or unsupported layout in assets/$modelDirName"
        }

        val modelConfig = OfflineModelConfig(
            transducerConfig,
            paraformerConfig,
            OfflineWhisperModelConfig(),
            OfflineFireRedAsrModelConfig(),
            OfflineMoonshineModelConfig(),
            OfflineNemoEncDecCtcModelConfig(),
            senseVoiceConfig,
            OfflineDolphinModelConfig(),
            OfflineZipformerCtcModelConfig(),
            OfflineWenetCtcModelConfig(),
            OfflineOmnilingualAsrCtcModelConfig(),
            OfflineMedAsrCtcModelConfig(),
            OfflineFunAsrNanoModelConfig(),
            OfflineQwen3AsrModelConfig(),
            OfflineFireRedAsrCtcModelConfig(),
            OfflineCanaryModelConfig(),
            OfflineCohereTranscribeModelConfig(),
            "",
            numThreads,
            false,
            provider,
            "",
            tokens,
            "",
            ""
        )

        return OfflineRecognizerConfig(
            FeatureConfig(DEFAULT_ASR_SAMPLE_RATE, DEFAULT_ASR_FEATURE_DIM, 0.0f),
            modelConfig,
            HomophoneReplacerConfig(),
            "greedy_search",
            4,
            "",
            1.5f,
            buildRuleFsts(context, modelDirName),
            "",
            0.0f
        )
    }

    private fun buildRuleFsts(context: Context, root: String): String {
        val ruleFiles = listOf("date.fst", "number.fst", "phone.fst")
            .map { joinAssetPath(root, it) }
            .filter { assetPathExists(context, it) }

        return ruleFiles.joinToString(",")
    }

    private fun hasAtLeastOneModel(modelConfig: OfflineTtsModelConfig): Boolean {
        return modelConfig.vits.model.isNotBlank() ||
            modelConfig.matcha.acousticModel.isNotBlank() ||
            modelConfig.kokoro.model.isNotBlank() ||
            modelConfig.zipvoice.encoder.isNotBlank() ||
            modelConfig.kitten.model.isNotBlank() ||
            modelConfig.pocket.encoder.isNotBlank() ||
            modelConfig.supertonic.textEncoder.isNotBlank()
    }

    private fun detectVitsConfig(context: Context, modelDirName: String): OfflineTtsVitsModelConfig {
        return OfflineTtsVitsModelConfig(
            findFirstExistingAsset(context, modelDirName, "model.onnx", "vits.onnx").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "lexicon.txt", "lexicon.txt.old").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "tokens.txt").orEmpty(),
            findExistingAssetDir(context, modelDirName, "espeak-ng-data", "data", "dict").orEmpty(),
            findExistingAssetDir(context, modelDirName, "dict", "dicts").orEmpty(),
            0.667f,
            0.8f,
            1.0f
        )
    }

    private fun detectMatchaConfig(context: Context, modelDirName: String): OfflineTtsMatchaModelConfig {
        return OfflineTtsMatchaModelConfig(
            findFirstExistingAsset(context, modelDirName, "acoustic-model.onnx", "model.onnx").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "vocoder.onnx").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "lexicon.txt").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "tokens.txt").orEmpty(),
            findExistingAssetDir(context, modelDirName, "espeak-ng-data", "data", "dict").orEmpty(),
            findExistingAssetDir(context, modelDirName, "dict", "dicts").orEmpty(),
            1.0f,
            1.0f
        )
    }

    private fun detectKokoroConfig(context: Context, modelDirName: String): OfflineTtsKokoroModelConfig {
        return OfflineTtsKokoroModelConfig(
            findFirstExistingAsset(context, modelDirName, "model.onnx", "kokoro.onnx").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "voices.bin", "voices.dat").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "tokens.txt").orEmpty(),
            findExistingAssetDir(context, modelDirName, "espeak-ng-data", "data").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "lexicon.txt").orEmpty(),
            findFirstExistingAsset(context, modelDirName, "lang.txt").orEmpty(),
            findExistingAssetDir(context, modelDirName, "dict", "dicts").orEmpty(),
            1.0f
        )
    }

    private fun detectZipVoiceConfig(@Suppress("UNUSED_PARAMETER") context: Context, @Suppress("UNUSED_PARAMETER") modelDirName: String): OfflineTtsZipVoiceModelConfig {
        return OfflineTtsZipVoiceModelConfig()
    }

    private fun detectKittenConfig(@Suppress("UNUSED_PARAMETER") context: Context, @Suppress("UNUSED_PARAMETER") modelDirName: String): OfflineTtsKittenModelConfig {
        return OfflineTtsKittenModelConfig()
    }

    private fun detectPocketConfig(@Suppress("UNUSED_PARAMETER") context: Context, @Suppress("UNUSED_PARAMETER") modelDirName: String): OfflineTtsPocketModelConfig {
        return OfflineTtsPocketModelConfig()
    }

    private fun detectSupertonicConfig(@Suppress("UNUSED_PARAMETER") context: Context, @Suppress("UNUSED_PARAMETER") modelDirName: String): OfflineTtsSupertonicModelConfig {
        return OfflineTtsSupertonicModelConfig()
    }

    private fun findFirstExistingAsset(context: Context, root: String, vararg names: String): String? {
        return names
            .asSequence()
            .map { joinAssetPath(root, it) }
            .firstOrNull { assetPathExists(context, it) }
    }

    private fun findExistingAssetDir(context: Context, root: String, vararg names: String): String? {
        return names
            .asSequence()
            .map { joinAssetPath(root, it) }
            .firstOrNull { assetPathExists(context, it) }
    }

    private fun assetPathExists(context: Context, path: String): Boolean {
        return runCatching {
            context.assets.list(path) != null
        }.getOrDefault(false)
    }

    private fun joinAssetPath(root: String, child: String): String {
        return if (root.isBlank()) child else "$root/$child"
    }
}