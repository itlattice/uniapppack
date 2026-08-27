package uts.sdk.modules.xMd5
// 包名字要和插件名字一样
import java.math.BigInteger
import java.security.MessageDigest
import io.dcloud.uts.console
object NativeCode {
	fun md5(input: String): String {
		val md = MessageDigest.getInstance("MD5")
		val digest = md.digest(input.toByteArray(Charsets.UTF_8))
		var str=BigInteger(1, digest).toString(16).padStart(32, '0')
		return  str;
	}
}