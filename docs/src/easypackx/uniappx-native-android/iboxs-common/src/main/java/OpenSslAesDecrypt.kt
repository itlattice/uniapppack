package uts.sdk.modules.iboxsCommon


import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

/**
 * 专门解密：openssl enc -aes-256-cbc -salt -k 密码
 * 加密后的 RSA 公钥
 */
object OpenSslAesDecrypt {
    private const val OPENSSL_HEADER = "Salted__"
    private const val SALT_OFFSET = 8
    private const val SALT_LENGTH = 8
    private const val DATA_OFFSET = 16
    private const val AES_BLOCK_SIZE = 16

    /**
     * 解密 OpenSSL AES-256-CBC 加密的公钥。
     * 输入可为 Base64 文本或被当作字符串传入的原始密文内容。
     */
    fun decryptEncryptedPublicKey(encryptedPayload: String, password: String): String {
        require(password.isNotEmpty()) { "解密密码不能为空" }
        if (isPemPublicKey(encryptedPayload)) {
            return encryptedPayload.trim()
        }

        val payload = parseSaltedPayload(encryptedPayload)
        require(payload.size >= DATA_OFFSET + AES_BLOCK_SIZE) { "OpenSSL 密文长度异常" }

        val salt = payload.copyOfRange(SALT_OFFSET, SALT_OFFSET + SALT_LENGTH)
        val cipherData = payload.copyOfRange(DATA_OFFSET, payload.size)
        require(cipherData.isNotEmpty() && cipherData.size % AES_BLOCK_SIZE == 0) {
            "OpenSSL 密文块长度异常（必须是 16 的倍数）"
        }

        val passwordBytes = password.toByteArray(Charsets.UTF_8)
        var firstPlainText: String? = null
        var lastError: Exception? = null

        val evpDigests = arrayOf("MD5", "SHA-256")
        for (digest in evpDigests) {
            try {
                val (key, iv) = deriveEvpBytesToKey(passwordBytes, salt, digest)
                val plain = decryptAesCbc(cipherData, key, iv)
                val text = String(plain, Charsets.UTF_8).trim()
                if (firstPlainText == null) firstPlainText = text
                if (looksLikePublicKeyText(text)) {
                    return text
                }
            } catch (e: Exception) {
                lastError = e
            }
        }

        try {
            val (key, iv) = derivePbkdf2KeyAndIv(password, salt, 10000)
            val plain = decryptAesCbc(cipherData, key, iv)
            val text = String(plain, Charsets.UTF_8).trim()
            if (looksLikePublicKeyText(text)) {
                return text
            }
            if (firstPlainText == null) firstPlainText = text
        } catch (e: Exception) {
            lastError = e
        }

        if (firstPlainText != null) {
            return firstPlainText as String
        }

        throw IllegalArgumentException("OpenSSL 解密失败：密码错误或密文已损坏", lastError)
    }

    private fun parseSaltedPayload(input: String): ByteArray {
        val normalized = input.trim()
        require(normalized.isNotEmpty()) { "密文不能为空" }

        if (isPemPublicKey(normalized)) {
            throw IllegalArgumentException("输入是明文 PEM 公钥，不需要执行 OpenSSL AES 解密")
        }

        val candidates = ArrayList<ByteArray>()
        decodeBase64Safe(normalized)?.let { candidates.add(it) }
        decodeBase64Safe(normalized.replace('-', '+').replace('_', '/'))?.let { candidates.add(it) }
        candidates.add(normalized.toByteArray(Charsets.ISO_8859_1))
        candidates.add(normalized.toByteArray(Charsets.UTF_8))

        for (candidate in candidates) {
            locateSaltedPayload(candidate)?.let { return it }
            if (hasHeader(candidate)) {
                val repaired = String(candidate, Charsets.UTF_8).toByteArray(Charsets.ISO_8859_1)
                locateSaltedPayload(repaired)?.let { return it }
            }
        }

        throw IllegalArgumentException("密文格式无效：未找到 OpenSSL Salted__ 头")
    }

    private fun isPemPublicKey(value: String): Boolean {
        val text = value.trim()
        return text.contains("-----BEGIN PUBLIC KEY-----") && text.contains("-----END PUBLIC KEY-----")
    }

    private fun decodeBase64Safe(value: String): ByteArray? {
        return try {
            Base64.getMimeDecoder().decode(value)
        } catch (_: IllegalArgumentException) {
            null
        }
    }

    private fun locateSaltedPayload(data: ByteArray): ByteArray? {
        if (hasHeader(data) && hasValidBodyLength(data)) {
            return data
        }

        val start = findHeader(data)
        if (start >= 0) {
            val sliced = data.copyOfRange(start, data.size)
            if (hasHeader(sliced) && hasValidBodyLength(sliced)) {
                return sliced
            }
        }
        return null
    }

    private fun hasHeader(data: ByteArray): Boolean {
        if (data.size < DATA_OFFSET) return false
        val header = String(data.copyOfRange(0, OPENSSL_HEADER.length), Charsets.US_ASCII)
        return header == OPENSSL_HEADER
    }

    private fun hasValidBodyLength(data: ByteArray): Boolean {
        if (data.size <= DATA_OFFSET) return false
        return (data.size - DATA_OFFSET) % AES_BLOCK_SIZE == 0
    }

    private fun findHeader(data: ByteArray): Int {
        val headerBytes = OPENSSL_HEADER.toByteArray(Charsets.US_ASCII)
        if (data.size < headerBytes.size) return -1

        for (i in 0..(data.size - headerBytes.size)) {
            var matched = true
            for (j in headerBytes.indices) {
                if (data[i + j] != headerBytes[j]) {
                    matched = false
                    break
                }
            }
            if (matched) return i
        }
        return -1
    }

    private fun decryptAesCbc(cipherData: ByteArray, key: ByteArray, iv: ByteArray): ByteArray {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
        return cipher.doFinal(cipherData)
    }

    /**
     * OpenSSL enc 的旧 KDF：EVP_BytesToKey，count=1。
     * AES-256-CBC 需要 32 字节 key + 16 字节 iv。
     */
    private fun deriveEvpBytesToKey(passwordBytes: ByteArray, salt: ByteArray, digestName: String): Pair<ByteArray, ByteArray> {
        val digest = MessageDigest.getInstance(digestName)
        val keyIv = ByteArray(48)
        var generated = 0
        var previous = ByteArray(0)

        while (generated < keyIv.size) {
            digest.update(previous)
            digest.update(passwordBytes)
            digest.update(salt)
            previous = digest.digest()
            digest.reset()

            val copyLen = minOf(previous.size, keyIv.size - generated)
            System.arraycopy(previous, 0, keyIv, generated, copyLen)
            generated += copyLen
        }

        val key = keyIv.copyOfRange(0, 32)
        val iv = keyIv.copyOfRange(32, 48)
        return Pair(key, iv)
    }

    private fun derivePbkdf2KeyAndIv(password: String, salt: ByteArray, iterations: Int): Pair<ByteArray, ByteArray> {
        val spec = PBEKeySpec(password.toCharArray(), salt, iterations, 48 * 8)
        val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val keyIv = skf.generateSecret(spec).encoded
        val key = keyIv.copyOfRange(0, 32)
        val iv = keyIv.copyOfRange(32, 48)
        return Pair(key, iv)
    }

    private fun looksLikePublicKeyText(text: String): Boolean {
        if (text.isEmpty()) return false
        if (isPemPublicKey(text)) return true
        if (text.contains("-----BEGIN RSA PUBLIC KEY-----") && text.contains("-----END RSA PUBLIC KEY-----")) return true

        // 兼容可能只保存 Base64 Key Body 的情况。
        val compact = text.replace("\n", "").replace("\r", "").replace(" ", "")
        val base64Regex = Regex("^[A-Za-z0-9+/=]+$")
        return compact.length > 100 && compact.length % 4 == 0 && base64Regex.matches(compact)
    }
}