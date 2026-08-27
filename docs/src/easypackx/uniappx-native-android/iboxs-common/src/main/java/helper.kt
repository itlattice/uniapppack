package uts.sdk.modules.iboxsCommon
import java.math.BigInteger
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import android.view.WindowManager
import android.app.Activity

object Helper {
	fun binaryStringToDecimal(binaryStr: String): BigInteger {
	    // 校验输入：空字符串直接抛异常
	    require(binaryStr.isNotBlank()) { "二进制字符串不能为空" }
	    // 校验输入：仅包含0和1
	    require(binaryStr.all { it == '0' || it == '1' }) { "二进制字符串只能包含0和1，输入：$binaryStr" }
	    
	    // 核心逻辑：BigInteger(字符串, 进制) 直接转换
	    return BigInteger(binaryStr, 2)
	}
	
	fun evalFun(code:String):Any{
		val expr1 = ExpressionBuilder(code)
		        .build()
		val result1 = expr1.evaluate()
		return result1
	}
	
	fun keepScreenOn(activity: Activity){
		activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
	}
	
	fun clearKeepScreenOn(activity: Activity){
		activity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
	}
}