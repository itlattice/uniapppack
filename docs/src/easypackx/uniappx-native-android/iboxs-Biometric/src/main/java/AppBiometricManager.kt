package uts.sdk.modules.iboxsBiometric

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import android.app.Activity
import com.google.gson.Gson
import java.io.IOException
import java.security.*
import android.content.ActivityNotFoundException
import java.security.cert.CertificateException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.NoSuchPaddingException
import javax.crypto.SecretKey
import io.dcloud.uts.console

// 使用object关键字实现单例模式
object AppBiometricManager {
    private const val TAG = "AppBiometricManager"
    private const val KEY_NAME = "biometric_key"
    private var biometricPrompt: BiometricPrompt? = null
    private var cryptoObject: BiometricPrompt.CryptoObject? = null
    private lateinit var context: Context
    private val gson = Gson()

    // 初始化方法，必须在应用启动时调用
    fun init(context: Context): Boolean {
        this.context = context.applicationContext
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            generateKey()
        }
        return true
    }

    // 检查生物识别支持情况，返回JSON字符串，包含所有认证类型支持情况
    fun checkBiometricSupport(): String {
        val biometricManager = BiometricManager.from(context)
        val resultMap = mutableMapOf<String, Any>()

        // 检查BIOMETRIC_WEAK支持情况
        val weakResult = biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK)
        val isWeakSupported = weakResult == BiometricManager.BIOMETRIC_SUCCESS

        // 检查BIOMETRIC_STRONG支持情况
        val strongResult = biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)
        val isStrongSupported = strongResult == BiometricManager.BIOMETRIC_SUCCESS

        // 检查DEVICE_CREDENTIAL支持情况
        val credentialResult = biometricManager.canAuthenticate(BiometricManager.Authenticators.DEVICE_CREDENTIAL)
        val isCredentialSupported = credentialResult == BiometricManager.BIOMETRIC_SUCCESS

        // 构建结果JSON
        resultMap["isSupported"] = isWeakSupported || isStrongSupported || isCredentialSupported
        resultMap["supportedTypes"] = getEnabledBiometricTypes().map { it.name }
        
        // 新增三种认证类型支持情况
        resultMap["biometricWeak"] = mapOf(
            "supported" to isWeakSupported,
            "errorCode" to weakResult,
            "errorMessage" to getErrorMessage(weakResult)
        )
        
        resultMap["biometricStrong"] = mapOf(
            "supported" to isStrongSupported,
            "errorCode" to strongResult,
            "errorMessage" to getErrorMessage(strongResult)
        )
        
        resultMap["deviceCredential"] = mapOf(
            "supported" to isCredentialSupported,
            "errorCode" to credentialResult,
            "errorMessage" to getErrorMessage(credentialResult)
        )

        return gson.toJson(resultMap)
    }

    // 获取错误消息
    private fun getErrorMessage(resultCode: Int): String {
        return when (resultCode) {
            BiometricManager.BIOMETRIC_SUCCESS -> "支持此认证类型"
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> "生物识别硬件不可用"
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> "设备不支持生物识别"
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> "未注册生物识别信息"
            BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> "需要安全更新"
            BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> "认证类型不支持"
            BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> "认证状态未知"
            else -> "未知错误: $resultCode"
        }
    }

    // 获取已启用的生物识别类型
    private fun getEnabledBiometricTypes(): List<BiometricType> {
        val biometricManager = BiometricManager.from(context)
        val supportedTypes = mutableListOf<BiometricType>()

        // 检查指纹识别
        if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.BIOMETRIC_STRONG) == BiometricManager.BIOMETRIC_SUCCESS) {
            supportedTypes.add(BiometricType.FINGERPRINT)
        }

        // 检查人脸识别
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (biometricManager.canAuthenticate(BiometricManager.Authenticators.DEVICE_CREDENTIAL or BiometricManager.Authenticators.BIOMETRIC_WEAK) == BiometricManager.BIOMETRIC_SUCCESS) {
                supportedTypes.add(BiometricType.FACE)
            }
        }

        return supportedTypes
    }

    // 新增：检查生物识别数据是否已录入
    fun checkBiometricEnrolled(authType: String): Boolean {
        val biometricManager = BiometricManager.from(context)
        
        // 将字符串转换为对应的Authenticators常量
        val authenticator = when (authType.lowercase()) {
            "strong" -> BiometricManager.Authenticators.BIOMETRIC_STRONG
            "weak" -> BiometricManager.Authenticators.BIOMETRIC_WEAK
            "credential" -> BiometricManager.Authenticators.DEVICE_CREDENTIAL
            else -> {
                console.error("无效的认证类型参数: $authType")
                return false
            }
        }
        
        return biometricManager.canAuthenticate(authenticator) == BiometricManager.BIOMETRIC_SUCCESS
    }

    // 打开生物识别设置页面
    fun openBiometricSettings(context: Context, authType: String) {
        // 参数验证
        val normalizedAuthType = authType.lowercase()
        if (!listOf("strong", "weak", "credential").contains(normalizedAuthType)) {
            console.error( "无效的认证类型参数: $authType")
            return
        }
        
        try {
            // 针对小米手机的特殊处理
            if (isXiaomiDevice()) {
                openXiaomiBiometricSettings(context, normalizedAuthType)
                return
            }
            
            // 标准Android设备处理
            val authenticator = when (normalizedAuthType) {
                "strong", "weak" -> BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.BIOMETRIC_STRONG
                "credential" -> BiometricManager.Authenticators.DEVICE_CREDENTIAL
                else -> throw IllegalArgumentException("无效的认证类型") // 不会执行，已在前面验证
            }
            
            val intent = when {
                normalizedAuthType == "credential" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> {
                    Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                        putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED, authenticator)
                    }
                }
                normalizedAuthType != "credential" && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> {
                    Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                        putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED, authenticator)
                    }
                }
                else -> {
                    Intent(Settings.ACTION_SECURITY_SETTINGS)
                }
            }
            
            // 确保有Activity上下文才能启动Intent
            if (context !is Activity) {
                Log.w(TAG, "使用的是非Activity上下文，尝试使用startActivityIfNeeded")
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            
            // 检查是否有Activity可以处理该Intent
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                console.error( "没有Activity可以处理该Intent: $intent")
                openFallbackSettings(context)
            }
        } catch (e: Exception) {
            console.error( "打开设置页面失败: ${e.message}", e)
            openFallbackSettings(context)
        }
    }
    
    // 检查是否是小米设备
    private fun isXiaomiDevice(): Boolean {
        return Build.MANUFACTURER.equals("Xiaomi", ignoreCase = true)
    }
    
    // 针对小米设备的特殊处理
    private fun openXiaomiBiometricSettings(context: Context, authType: String) {
        try {
            val intent = when (authType) {
                "strong", "weak" -> {
                    // 小米指纹/人脸设置页面
                    Intent("miui.intent.action.SECURITY_CENTER").apply {
                        addCategory(Intent.CATEGORY_DEFAULT)
                        putExtra("page", "fingerprint") // 指纹设置
                    }
                }
                "credential" -> {
                    // 小米锁屏密码设置页面
                    Intent("miui.intent.action.LOCKSCREEN_PASSWORD_SETTINGS").apply {
                        addCategory(Intent.CATEGORY_DEFAULT)
                    }
                }
                else -> throw IllegalArgumentException("无效的认证类型")
            }
            
            // 检查是否有Activity可以处理该Intent
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                console.error( "小米设备: 没有Activity可以处理该Intent: $intent")
                openFallbackSettings(context)
            }
        } catch (e: Exception) {
            console.error( "小米设备: 打开设置页面失败: ${e.message}", e)
            openFallbackSettings(context)
        }
    }
    
    // 通用回退方法
    private fun openFallbackSettings(context: Context) {
        try {
            // 尝试打开主设置页面
            val mainSettingsIntent = Intent(Settings.ACTION_SETTINGS)
            mainSettingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            
            if (mainSettingsIntent.resolveActivity(context.packageManager) != null) {
                context.startActivity(mainSettingsIntent)
            } else {
                console.error( "无法打开任何设置页面")
                // 可以考虑显示一个Toast提示用户手动设置
            }
        } catch (e: Exception) {
            console.error( "打开主设置页面失败: ${e.message}", e)
        }
    }

    // 认证方法
    fun authenticate(
        activity: FragmentActivity,
        title: String,
        subtitle: String,
        description: String,
        allowedAuthType: String, // 接收认证类型：strong、weak、credential
        onSuccess: () -> Unit,
        onError: (errorCode: Int, errorMessage: String) -> Unit,
        onFailed: () -> Unit
    ) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onError(-1, "设备系统版本过低，不支持生物识别")
            return
        }
    
        // 将字符串转换为认证类型
        val authType = when (allowedAuthType.lowercase()) {
            "strong" -> AuthType.BIOMETRIC_STRONG
            "weak" -> AuthType.BIOMETRIC_WEAK
            "credential" -> AuthType.DEVICE_CREDENTIAL
            else -> {
                onError(-3, "无效的认证类型参数: $allowedAuthType")
                return
            }
        }
    
        createBiometricPrompt(activity, onSuccess, onError, onFailed)
        
        // 检查设备支持的认证类型
        val biometricManager = BiometricManager.from(context)
        val isStrongSupported = biometricManager.canAuthenticate(
            BiometricManager.Authenticators.BIOMETRIC_STRONG
        ) == BiometricManager.BIOMETRIC_SUCCESS
        
        val isWeakSupported = biometricManager.canAuthenticate(
            BiometricManager.Authenticators.BIOMETRIC_WEAK
        ) == BiometricManager.BIOMETRIC_SUCCESS
        
        val isCredentialSupported = biometricManager.canAuthenticate(
            BiometricManager.Authenticators.DEVICE_CREDENTIAL
        ) == BiometricManager.BIOMETRIC_SUCCESS
    
        // 根据用户选择和设备支持情况设置验证方式
        val authenticators = when (authType) {
            AuthType.BIOMETRIC_STRONG -> {
                if (!isStrongSupported) {
                    onError(-4, "设备不支持强生物识别")
                    return
                }
                BiometricManager.Authenticators.BIOMETRIC_STRONG
            }
            
            AuthType.BIOMETRIC_WEAK -> {
                if (!isWeakSupported) {
                    onError(-5, "设备不支持弱生物识别")
                    return
                }
                BiometricManager.Authenticators.BIOMETRIC_WEAK
            }
            
            AuthType.DEVICE_CREDENTIAL -> {
                if (!isCredentialSupported) {
                    onError(-6, "设备不支持设备凭证认证")
                    return
                }
                BiometricManager.Authenticators.DEVICE_CREDENTIAL
            }
        }
    
        // 修复：根据认证类型动态配置PromptInfo
        val promptBuilder = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setSubtitle(subtitle)
            .setDescription(description)
            .setAllowedAuthenticators(authenticators)
        
        // 设备凭证认证不能设置负按钮文本
        if (authType != AuthType.DEVICE_CREDENTIAL) {
            promptBuilder.setNegativeButtonText("取消")
        }
        
        val promptInfo = promptBuilder.build()
    
        // 根据认证类型决定是否使用加密
        val cryptoObject = if (authType == AuthType.BIOMETRIC_STRONG) {
            BiometricPrompt.CryptoObject(createCipher())
        } else {
            null
        }
    
        // 正确处理CryptoObject为null的情况
        if (cryptoObject != null) {
            biometricPrompt?.authenticate(promptInfo, cryptoObject)
        } else {
            biometricPrompt?.authenticate(promptInfo)
        }
    }

    // 认证类型枚举
    enum class AuthType {
        BIOMETRIC_STRONG,
        BIOMETRIC_WEAK,
        DEVICE_CREDENTIAL
    }

    // 创建一个用于设备凭证认证的虚拟Cipher（不实际使用加密）
    @RequiresApi(Build.VERSION_CODES.M)
    private fun createCipher(): Cipher {
        try {
            val cipher = Cipher.getInstance(
                "${KeyProperties.KEY_ALGORITHM_AES}/${KeyProperties.BLOCK_MODE_CBC}/${KeyProperties.ENCRYPTION_PADDING_PKCS7}"
            )

            val keyStore = KeyStore.getInstance("AndroidKeyStore")
            keyStore.load(null)

            // 检查密钥是否存在
            if (!keyStore.containsAlias(KEY_NAME)) {
                generateKey()
            }

            val key = keyStore.getKey(KEY_NAME, null) as SecretKey

            cipher.init(Cipher.ENCRYPT_MODE, key)
            return cipher
        } catch (e: NoSuchAlgorithmException) {
            console.error("NoSuchAlgorithmException: ${e.message}", e)
            throw RuntimeException("Failed to create cipher", e)
        } catch (e: NoSuchPaddingException) {
            console.error("NoSuchPaddingException: ${e.message}", e)
            throw RuntimeException("Failed to create cipher", e)
        } catch (e: KeyStoreException) {
            console.error("KeyStoreException: ${e.message}", e)
            throw RuntimeException("Failed to create cipher", e)
        } catch (e: CertificateException) {
            console.error("CertificateException: ${e.message}", e)
            throw RuntimeException("Failed to create cipher", e)
        } catch (e: IOException) {
            console.error("IOException: ${e.message}", e)
            throw RuntimeException("Failed to create cipher", e)
        } catch (e: UnrecoverableKeyException) {
            console.error("UnrecoverableKeyException: ${e.message}", e)
            throw RuntimeException("Failed to create cipher", e)
        } catch (e: InvalidKeyException) {
            console.error("InvalidKeyException: ${e.message}", e)
            throw RuntimeException("Failed to create cipher", e)
        }
    }

    // 生成加密密钥
    @RequiresApi(Build.VERSION_CODES.M)
    private fun generateKey() {
        try {
            val keyGenerator = KeyGenerator.getInstance(
                KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")

            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                KEY_NAME,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
               .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
               .setUserAuthenticationRequired(true)
               .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
               .build()

            keyGenerator.init(keyGenParameterSpec)
            keyGenerator.generateKey()
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Failed to generate key", e)
        } catch (e: NoSuchProviderException) {
            throw RuntimeException("Failed to generate key", e)
        } catch (e: InvalidAlgorithmParameterException) {
            throw RuntimeException("Failed to generate key", e)
        }
    }

    // 创建生物识别提示框，使用传入的回调函数
    private fun createBiometricPrompt(
        activity: FragmentActivity,
        onSuccess: () -> Unit,
        onError: (errorCode: Int, errorMessage: String) -> Unit,
        onFailed: () -> Unit
    ) {
        val executor = ContextCompat.getMainExecutor(context)

        biometricPrompt = BiometricPrompt(activity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    console.error("Authentication error: $errorCode, $errString")
                    onError(errorCode, errString.toString())
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Log.d(TAG, "Authentication succeeded")
                    onSuccess()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Log.w(TAG, "Authentication failed")
                    onFailed()
                }
            })
    }
}

// 生物识别类型枚举
enum class BiometricType {
    FINGERPRINT,
    FACE
}