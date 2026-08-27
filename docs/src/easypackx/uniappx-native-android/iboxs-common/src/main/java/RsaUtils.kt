package uts.sdk.modules.iboxsCommon


import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import java.util.Base64

/**
 * RSA 加密解密工具类
 * 算法：RSA/ECB/PKCS1Padding（最通用兼容模式）
 * 密钥长度：2048（安全推荐）
 */
object RsaUtils {
    // 加密算法
    private const val ALGORITHM = "RSA"
    // 加密填充模式
    private const val TRANSFORMATION = "RSA/ECB/PKCS1Padding"
    // 密钥长度 2048 位（安全）
    private const val KEY_SIZE = 2048

    /**
     * 公钥加密
     * @param data 原始数据
     * @param publicKeyBase64 Base64 格式公钥
     * @return Base64 加密结果
     */
    fun encryptByPublicKey(data: String, publicKeyInput: String): String {
        val keyBytes = normalizePublicKeyToDer(publicKeyInput)
        val keySpec = X509EncodedKeySpec(keyBytes)
        val keyFactory = KeyFactory.getInstance(ALGORITHM)
        val publicKey = keyFactory.generatePublic(keySpec)

        // 加密
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        val encrypted = cipher.doFinal(data.toByteArray())
        return Base64.getEncoder().encodeToString(encrypted)
    }

    /**
     * 公钥解密
     * @param encryptedData Base64 加密数据
     * @param publicKeyBase64 Base64 格式公钥
     * @return 原始字符串
     */
    fun decryptByPublicKey(encryptedData: String, publicKeyInput: String): String {
        val keyBytes = normalizePublicKeyToDer(publicKeyInput)
        val keySpec = X509EncodedKeySpec(keyBytes)
        val keyFactory = KeyFactory.getInstance(ALGORITHM)
        val publicKey = keyFactory.generatePublic(keySpec)

        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, publicKey)
        val decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData))
        return String(decrypted)
    }

    /**
     * 私钥加密
     * @param data 原始数据
     * @param privateKeyBase64 Base64 格式私钥
     * @return Base64 加密结果
     */
    fun encryptByPrivateKey(data: String, privateKeyBase64: String): String {
        val keyBytes = Base64.getDecoder().decode(privateKeyBase64)
        val keySpec = PKCS8EncodedKeySpec(keyBytes)
        val keyFactory = KeyFactory.getInstance(ALGORITHM)
        val privateKey = keyFactory.generatePrivate(keySpec)

        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, privateKey)
        val encrypted = cipher.doFinal(data.toByteArray())
        return Base64.getEncoder().encodeToString(encrypted)
    }

    /**
     * 私钥解密
     * @param encryptedData Base64 加密数据
     * @param privateKeyBase64 Base64 格式私钥
     * @return 原始字符串
     */
    fun decryptByPrivateKey(encryptedData: String, privateKeyBase64: String): String {
        val keyBytes = Base64.getDecoder().decode(privateKeyBase64)
        val keySpec = PKCS8EncodedKeySpec(keyBytes)
        val keyFactory = KeyFactory.getInstance(ALGORITHM)
        val privateKey = keyFactory.generatePrivate(keySpec)

        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, privateKey)
        val decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData))
        return String(decrypted)
    }

    private fun normalizePublicKeyToDer(publicKeyInput: String): ByteArray {
        val normalized = publicKeyInput.trim().replace("\\n", "\n")

        val pemBody = extractPemBody(normalized)
        if (pemBody != null) {
            return Base64.getMimeDecoder().decode(pemBody)
        }

        val firstDecode = decodeBase64Safe(normalized)
            ?: throw IllegalArgumentException("公钥格式无效：既不是 PEM，也不是可解码的 Base64")

        // 兼容调用方传入 base64Encode(PEM 文本) 的历史写法
        val decodedText = String(firstDecode, Charsets.UTF_8).trim().replace("\\n", "\n")
        val nestedPemBody = extractPemBody(decodedText)
        if (nestedPemBody != null) {
            return Base64.getMimeDecoder().decode(nestedPemBody)
        }

        return firstDecode
    }

    private fun extractPemBody(text: String): String? {
        val begin = "-----BEGIN PUBLIC KEY-----"
        val end = "-----END PUBLIC KEY-----"
        val start = text.indexOf(begin)
        val finish = text.indexOf(end)
        if (start < 0 || finish < 0 || finish <= start) {
            return null
        }

        val body = text.substring(start + begin.length, finish)
            .replace("\n", "")
            .replace("\r", "")
            .replace(" ", "")
        return if (body.isEmpty()) null else body
    }

    private fun decodeBase64Safe(value: String): ByteArray? {
        return try {
            Base64.getMimeDecoder().decode(value)
        } catch (_: IllegalArgumentException) {
            null
        }
    }
}