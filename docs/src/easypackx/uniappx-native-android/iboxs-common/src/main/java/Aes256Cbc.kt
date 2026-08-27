package uts.sdk.modules.iboxsCommon

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

/**
 * AES-256-CBC 加密解密工具
 * 密钥 和 IV 直接以字符串传入
 */
object Aes256CbcUtil {

    private const val TRANSFORMATION = "AES/CBC/PKCS5Padding" // 必须开启填充！
    
	/**
	 * AES-256-CBC 加密（密钥、IV 都是字符串）
	 */
	fun encrypt(data: String, keyStr: String, ivStr: String): String {
		val key = adjustTo32Bytes(keyStr)
		val iv = adjustTo16Bytes(ivStr)
		
		val cipher = Cipher.getInstance(TRANSFORMATION)
		cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
		val encrypted = cipher.doFinal(data.toByteArray())
		return Base64.getEncoder().encodeToString(encrypted)
	}

	/**
	 * AES-256-CBC 解密
	 */
	fun decrypt(encryptedBase64: String, keyStr: String, ivStr: String): String {
		val key = adjustTo32Bytes(keyStr)
		val iv = adjustTo16Bytes(ivStr)
		
		val cipher = Cipher.getInstance(TRANSFORMATION)
		cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))
		val decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedBase64))
		return String(decrypted)
	}

	// 密钥强制 32 字节（AES-256 必须）
	private fun adjustTo32Bytes(key: String): ByteArray {
		val bytes = key.toByteArray()
		val result = ByteArray(32)
		System.arraycopy(bytes, 0, result, 0, minOf(bytes.size, 32))
		return result
	}

	// IV 强制 16 字节（CBC 必须）
	private fun adjustTo16Bytes(iv: String): ByteArray {
		val bytes = iv.toByteArray()
		val result = ByteArray(16)
		System.arraycopy(bytes, 0, result, 0, minOf(bytes.size, 16))
		return result
	}
}