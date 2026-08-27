package uts.sdk.modules.iboxsTpop

import java.nio.ByteBuffer
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.math.pow

object TOTPGenerator {

    private const val TIME_STEP = 30L
    private const val CODE_DIGITS = 6
    private const val DEFAULT_ALGORITHM = "HmacSHA1"
    private const val MIN_CODE_DIGITS = 1
    private const val MAX_CODE_DIGITS = 10
    private val BASE32_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567"

    /**
     * 生成 TOTP 一次性验证码。
     *
     * 典型用法是：服务端下发 Base32 编码的共享密钥，客户端本地按时间窗生成验证码，
     * 最终由服务端使用相同参数进行校验。
     *
     * 默认参数兼容常见 authenticator 配置：30 秒时间步长、6 位验证码、HmacSHA1。
     * 若服务端协议不同，可显式传入自定义参数。
     *
     * @param secret 服务端下发的 Base32 编码共享密钥
     * @param timeStepSeconds 时间步长，单位秒，默认 30 秒
     * @param digits 验证码位数，默认 6 位
     * @param algorithm HMAC 算法，默认 HmacSHA1
     * @param timestampMillis 参与计算的时间戳，默认取当前系统时间；测试时可传固定值
     * @return 生成成功时返回验证码字符串；参数非法或密钥无法解码时返回 null
     */
    fun generateCode(
        secret: String,
        timeStepSeconds: Long = TIME_STEP,
        digits: Int = CODE_DIGITS,
        algorithm: String = DEFAULT_ALGORITHM,
        timestampMillis: Long = System.currentTimeMillis()
    ): String? {
        return try {
            require(secret.isNotBlank()) { "secret 不能为空" }
            require(timeStepSeconds > 0) { "timeStepSeconds 必须大于 0" }
            require(digits in MIN_CODE_DIGITS..MAX_CODE_DIGITS) { "digits 超出允许范围" }

            val key = base32Decode(secret)
            require(key.isNotEmpty()) { "secret 无法解码" }

            val counter = timestampMillis / 1000 / timeStepSeconds
            val counterBytes = ByteBuffer.allocate(8).putLong(counter).array()

            val mac = Mac.getInstance(algorithm)
            mac.init(SecretKeySpec(key, algorithm))
            val hash = mac.doFinal(counterBytes)

            val offset = hash[hash.size - 1].toInt() and 0x0F
            val binary =
                ((hash[offset].toInt() and 0x7F) shl 24) or
                        ((hash[offset + 1].toInt() and 0xFF) shl 16) or
                        ((hash[offset + 2].toInt() and 0xFF) shl 8) or
                        (hash[offset + 3].toInt() and 0xFF)

            val otp = binary % 10.0.pow(digits).toInt()
            otp.toString().padStart(digits, '0')
        } catch (e: Exception) {
            null
        }
    }

    /**
     * 获取当前时间窗剩余秒数。
     *
     * 可用于倒计时展示，帮助用户判断验证码何时刷新。
     *
     * @param timeStepSeconds 时间步长，单位秒，默认 30 秒
     * @param timestampMillis 参与计算的时间戳，默认取当前系统时间
     * @return 当前时间窗剩余秒数
     */
    fun getRemainingSeconds(
        timeStepSeconds: Long = TIME_STEP,
        timestampMillis: Long = System.currentTimeMillis()
    ): Int {
        require(timeStepSeconds > 0) { "timeStepSeconds 必须大于 0" }
        return (timeStepSeconds - (timestampMillis / 1000 % timeStepSeconds)).toInt()
    }

    /**
     * 将 Base32 编码的共享密钥解码为原始字节数组。
     *
     * 会自动忽略空白字符、连字符和尾部填充符 '='，
     * 但若包含其他非法字符，则直接抛出异常并由上层返回 null。
     */
    private fun base32Decode(encoded: String): ByteArray {
        val normalized = encoded
            .uppercase()
            .replace("=", "")
            .filterNot { it.isWhitespace() || it == '-' }

        require(normalized.isNotEmpty()) { "secret 不能为空" }

        var bits = 0
        var buffer = 0
        val result = mutableListOf<Byte>()

        for (char in normalized) {
            val value = BASE32_ALPHABET.indexOf(char)
            require(value >= 0) { "secret 包含非法 Base32 字符: $char" }

            buffer = (buffer shl 5) or value
            bits += 5

            if (bits >= 8) {
                result.add(((buffer shr (bits - 8)) and 0xFF).toByte())
                bits -= 8
            }
        }

        return result.toByteArray()
    }
}