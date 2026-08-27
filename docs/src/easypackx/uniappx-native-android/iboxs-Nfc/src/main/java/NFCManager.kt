package uts.sdk.modules.iboxsNfc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.itgz8.scannfc.NFCScanningActivity
import com.itgz8.scannfc.ScanConfig
import android.content.Context
import io.dcloud.uts.console
import android.nfc.NfcAdapter

object NFCManager {
	
	private var nfcAdapter: NfcAdapter? = null
	
	fun startRead(context:Context,scanConfig:ScanConfig):Intent
	{
		var intent = Intent(context, NFCScanningActivity::class.java)
		// 通过Intent传递自定义密钥字符串
		intent.putExtra("CUSTOM_KEY", scanConfig.customKey)
		return intent as Intent
	}
	
	fun init(appContext: Context):Boolean {
	    nfcAdapter = NfcAdapter.getDefaultAdapter(appContext)
	    if (nfcAdapter == null) {
	        Log.e("NFC", "设备不支持NFC功能")
			return false
	    }
		return true
	}
	/**
	 * 检查设备NFC功能是否已启用
	 * @return 如果NFC适配器存在且已启用返回true，否则返回false
	 */
	fun isNFCEnabled(): Boolean {
	    return nfcAdapter?.isEnabled ?: false
	}
}