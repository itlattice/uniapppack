package uts.sdk.modules.iboxsZimfacade

import android.content.Context
import com.alipay.face.api.ZIMCallback
import com.alipay.face.api.ZIMFacade
import com.alipay.face.api.ZIMFacadeBuilder
import com.alipay.face.api.ZIMResponse
import com.google.gson.Gson
import java.lang.reflect.Type
import com.google.gson.reflect.TypeToken

object Auth{
    fun install(context: Context):Int
    {
        return ZIMFacade.install(context);
    }

    fun getMetaInfos(context: Context):String
    {
        return ZIMFacade.getMetaInfos(context);
    }

    fun verify(context: Context,certifyId:String,params:String?,callback:(Boolean,Int?,String?)->Unit){
        val zimFacade = ZIMFacadeBuilder.create(context)
        var extParams:HashMap<String, String>?=null;
		if(params!=null){
			extParams=toMap(params)
		}
        zimFacade.verify(certifyId, false, extParams, object:ZIMCallback{
            override fun response(response: ZIMResponse?): Boolean {
                var code=response?.code;
                var reason=response?.reason;
                callback(code==1000,code,reason);
                return true
            }
        })
    }

    private fun toMap(json:String):HashMap<String,String>?
    {
        val gson = Gson ()
        val type: Type = object : TypeToken<HashMap<String, String>>() {}.type
        return gson.fromJson (json, type)
    }
	
	fun setUI(context: Context,jsonConfig:String):String
	{
        val zimFacade=ZIMFacade(context)
        val paramType = ZIMFacade.ZIM_EXT_PARAMS_VAL_ZIM_EXT_PARAMS_CONFIG_FILE_JSON;
        return zimFacade.setCustomUIConfig(paramType, jsonConfig);
	}
}