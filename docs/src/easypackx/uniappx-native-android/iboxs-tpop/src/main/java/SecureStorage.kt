package uts.sdk.modules.iboxsTpop

import android.content.Context
import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

/**
 * 通用安全存储（Android Keystore）
 *
 * 适合保存服务端下发的密钥、令牌等敏感字符串。
 * 明文不会直接写入 SharedPreferences，而是先使用 Android Keystore 中的 AES 密钥加密，
 * 再将密文持久化到本地。
 *
 * 使用前必须先调用 [init] 完成初始化。
 */
object SecureStorage {

    private const val ANDROID_KEYSTORE = "AndroidKeyStore"
    private const val PREF_NAME = "secure_storage"
    
    private const val GCM_IV_LENGTH = 12
    private const val GCM_TAG_LENGTH = 128

    private lateinit var prefs: SharedPreferences

    private fun isInitialized(): Boolean {
        return ::prefs.isInitialized
    }

    private fun requirePrefs(): SharedPreferences {
        check(isInitialized()) { "SecureStorage 未初始化，请先调用 init(context)" }
        return prefs
    }

    /**
     * 初始化存储组件。
     *
     * 建议在 Application 或模块首次启用时调用一次，后续公开方法都会依赖该初始化结果。
     */
    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    /**
     * 加密保存数据
     *
     * 同一个 alias 下可保存多组不同 key 的字符串数据；
     * alias 用于区分不同用途的本地加密主密钥。
     *
     * @param key 存储键名
     * @param value 要存储的字符串
     * @param alias Keystore 别名（不同数据用不同别名，可选）
     * @return 是否成功写入本地持久化存储
     */
    fun save(key: String, value: String, alias: String = "default_key"): Boolean {
        return try {
            val sharedPreferences = requirePrefs()
            val secretKey = getOrCreateKey(alias)
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)

            val iv = cipher.iv
            val encryptedBytes = cipher.doFinal(value.toByteArray(Charsets.UTF_8))

            val combined = ByteArray(iv.size + encryptedBytes.size)
            System.arraycopy(iv, 0, combined, 0, iv.size)
            System.arraycopy(encryptedBytes, 0, combined, iv.size, encryptedBytes.size)

            val encryptedString = Base64.encodeToString(combined, Base64.NO_WRAP)

            sharedPreferences.edit()
                .putString("${alias}_$key", encryptedString)
                .commit()
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    /**
     * 解密读取数据
        *
        * 仅当本地密文与对应 alias 的 Keystore 密钥同时存在时才能成功解密。
        * 如果密文损坏、alias 被删除，或尚未初始化，则返回 null。
        *
     * @param key 存储键名
     * @param alias Keystore 别名
        * @return 解密后的字符串；不存在或解密失败时返回 null
     */
    fun get(key: String, alias: String = "default_key"): String? {
        return try {
            val sharedPreferences = requirePrefs()
            val encryptedString = sharedPreferences.getString("${alias}_$key", null) ?: return null

            val combined = Base64.decode(encryptedString, Base64.NO_WRAP)
            if (combined.size <= GCM_IV_LENGTH) {
                return null
            }
            val iv = combined.copyOfRange(0, GCM_IV_LENGTH)
            val encryptedBytes = combined.copyOfRange(GCM_IV_LENGTH, combined.size)

            val secretKey = getOrCreateKey(alias)
            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            cipher.init(Cipher.DECRYPT_MODE, secretKey, GCMParameterSpec(GCM_TAG_LENGTH, iv))

            val decryptedBytes = cipher.doFinal(encryptedBytes)
            String(decryptedBytes, Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
        * 删除指定数据。
        *
        * 仅删除 SharedPreferences 中对应的密文，不会删除该 alias 关联的 Keystore 密钥。
     */
    fun delete(key: String, alias: String = "default_key"): Boolean {
        return try {
            val sharedPreferences = requirePrefs()
            sharedPreferences.edit()
                .remove("${alias}_$key")
                .commit()
        } catch (e: Exception) {
            false
        }
    }

    /**
     * 删除整个别名下的所有数据（包括 Keystore 密钥）
        *
        * 该操作会使该 alias 下历史保存的所有数据永久不可解密，适合在用户退出登录、重置绑定等场景调用。
     */
    fun deleteAll(alias: String = "default_key"): Boolean {
        return try {
            val sharedPreferences = requirePrefs()
            // 删除所有该别名下的 SharedPreferences 数据
            val allKeys = sharedPreferences.all.keys
            val editor = sharedPreferences.edit()
            allKeys.filter { it.startsWith("${alias}_") }
                .forEach { editor.remove(it) }
            val prefsCleared = editor.commit()

            // 删除 Keystore 密钥
            val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE)
            keyStore.load(null)
            if (keyStore.containsAlias(alias)) {
                keyStore.deleteEntry(alias)
            }

            prefsCleared
        } catch (e: Exception) {
            false
        }
    }

    /**
        * 检查指定数据是否存在。
        *
        * 这里只判断本地是否存在对应密文记录，不代表数据一定可以成功解密。
     */
    fun contains(key: String, alias: String = "default_key"): Boolean {
        return try {
            requirePrefs().contains("${alias}_$key")
        } catch (e: Exception) {
            false
        }
    }

    /**
     * 获取或创建 Keystore 密钥
        *
        * 每个 alias 对应一把独立的 AES 对称密钥，用于加解密该 alias 下的数据。
     */
    private fun getOrCreateKey(alias: String): SecretKey {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE)
        keyStore.load(null)

        if (keyStore.containsAlias(alias)) {
            return keyStore.getKey(alias, null) as SecretKey
        }

        val keyGenerator = KeyGenerator.getInstance(
            KeyProperties.KEY_ALGORITHM_AES,
            ANDROID_KEYSTORE
        )

        val spec = KeyGenParameterSpec.Builder(
            alias,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setKeySize(256)
            .setUserAuthenticationRequired(false)
            .build()

        keyGenerator.init(spec)
        return keyGenerator.generateKey()
    }
}