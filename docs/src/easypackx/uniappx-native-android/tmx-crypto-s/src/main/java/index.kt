@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.tmxCryptoS
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import uts.sdk.modules.utsXcryptoS.UniversalCryptoHelper
open class RSARANDOMKEY (
    @JsonNotNull
    open var publicKey: String,
    @JsonNotNull
    open var privateKey: String,
) : UTSObject()
fun md5(str: String): String {
    return UniversalCryptoHelper.md5(str)
}
fun base64Encode(str: String): String {
    return UniversalCryptoHelper.base64Encode(str)
}
fun base64Decode(str: String): String {
    return UniversalCryptoHelper.base64Decode(str)
}
fun sha256(str: String): String {
    return UniversalCryptoHelper.sha256(str)
}
fun hmacSha1(key: String, data: String): String {
    return UniversalCryptoHelper.hmacSha1(key, data)
}
fun hmacSha256(key: String, data: String): String {
    return UniversalCryptoHelper.hmacSha256(key, data)
}
fun sha512(str: String): String {
    return UniversalCryptoHelper.sha512(str)
}
fun hmacSha512(key: String, data: String): String {
    return UniversalCryptoHelper.hmacSha512(key, data)
}
fun sha1(str: String): String {
    return UniversalCryptoHelper.sha1(str)
}
fun aesEncrypt(key: String, data: String, mode: String = "ECB", iv: String? = null, keySize: Number? = null): String {
    console.log("长度:", (if (keySize == null) {
        16
    } else {
        keySize
    }
    ).toInt())
    return UniversalCryptoHelper.aesEncrypt(data, key, mode, iv, (if (keySize == null) {
        16
    } else {
        keySize
    }
    ).toInt())
}
fun aesEncrypt2(key: Uint8Array, data: Uint8Array, mode: String = "ECB", iv: Uint8Array? = null, keySize: Number? = null): Uint8Array {
    fun u8tbr(d: Uint8Array): ByteArray {
        var bar = ByteArray(d.length.toInt())
        run {
            var i: Number = 0
            while(i < d.length){
                bar[i.toInt()] = d[i.toInt()].toByte()
                i++
            }
        }
        return bar
    }
    fun brtu8(d: ByteArray): Uint8Array {
        var bar = Uint8Array(d.size)
        run {
            var i: Number = 0
            while(i < d.size){
                bar[i.toInt()] = d[i.toInt()] and 0xFF
                i++
            }
        }
        return bar
    }
    val result: ByteArray = UniversalCryptoHelper.aesEncrypt2(u8tbr(data), u8tbr(key), mode, if (iv == null) {
        null
    } else {
        u8tbr(iv)
    }
    , (if (keySize == null) {
        16
    } else {
        keySize
    }
    ).toInt())
    return brtu8(result)
}
fun aesDecrypt(key: String, data: String, mode: String = "ECB", iv: String? = null, keySize: Number? = null): String {
    return UniversalCryptoHelper.aesDecrypt(data, key, mode, iv, (if (keySize == null) {
        16
    } else {
        keySize
    }
    ).toInt())
}
fun aesDecrypt2(key: Uint8Array, data: Uint8Array, mode: String = "ECB", iv: Uint8Array? = null, keySize: Number? = null): Uint8Array {
    fun u8tbr(d: Uint8Array): ByteArray {
        var bar = ByteArray(d.length.toInt())
        run {
            var i: Number = 0
            while(i < d.length){
                bar[i.toInt()] = d[i.toInt()].toByte()
                i++
            }
        }
        return bar
    }
    fun brtu8(d: ByteArray): Uint8Array {
        var bar = Uint8Array(d.size)
        run {
            var i: Number = 0
            while(i < d.size){
                bar[i.toInt()] = d[i.toInt()] and 0xFF
                i++
            }
        }
        return bar
    }
    val result: ByteArray = UniversalCryptoHelper.aesDecrypt2(u8tbr(data), u8tbr(key), mode, if (iv == null) {
        null
    } else {
        u8tbr(iv)
    }
    , (if (keySize == null) {
        16
    } else {
        keySize
    }
    ).toInt())
    return brtu8(result)
}
fun desEncrypt(key: String, data: String, mode: String = "ECB", iv: String? = null): String {
    return UniversalCryptoHelper.desEncrypt(data, key, mode, iv)
}
fun desDecrypt(key: String, data: String, mode: String = "ECB", iv: String? = null): String {
    return UniversalCryptoHelper.desDecrypt(data, key, mode, iv)
}
fun generateRSAKeyPair(keySize: Number = 2048): RSARANDOMKEY {
    val crypt = UniversalCryptoHelper.generateRSAKeyPair(keySize.toInt())
    return RSARANDOMKEY(publicKey = crypt.publicKey, privateKey = crypt.privateKey)
}
fun rsaEncrypt(publicKey: String, data: String): String {
    return UniversalCryptoHelper.rsaEncrypt(data, publicKey)
}
fun rsaDecrypt(privateKey: String, data: String): String {
    return UniversalCryptoHelper.rsaDecrypt(data, privateKey)
}
fun rc4Encrypt(key: String, data: String): String {
    return UniversalCryptoHelper.rc4Encrypt(data, key)
}
fun rc4Decrypt(key: String, data: String): String {
    return UniversalCryptoHelper.rc4Decrypt(data, key)
}
