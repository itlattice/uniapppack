@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.tmxNetworkChange
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.net.NetworkRequest
import android.os.Build
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
typealias xNetworkType = String?
var netmarnger: ConnectivityManager? = null
var networkCallback: ConnectivityManager.NetworkCallback? = null
val context = UTSAndroid.getAppContext()!!
fun isNetworkAvailable(): UTSPromise<Boolean> {
    var connectivityManager: ConnectivityManager? = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (connectivityManager == null) {
        return UTSPromise.resolve(false)
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        var network: Network? = connectivityManager!!.getActiveNetwork()
        if (network == null) {
            return UTSPromise.resolve(false)
        }
        var capabilities: NetworkCapabilities? = connectivityManager.getNetworkCapabilities(network!!)
        return UTSPromise.resolve(capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED))
    } else {
        var networkInfo: NetworkInfo? = connectivityManager.getActiveNetworkInfo()
        return UTSPromise.resolve(networkInfo != null && networkInfo.isConnected())
    }
}
fun getNetworkType(): UTSPromise<xNetworkType?> {
    var connectivityManager: ConnectivityManager? = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (connectivityManager == null) {
        return UTSPromise.resolve(null)
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        var network: Network? = connectivityManager!!.getActiveNetwork()
        if (network == null) {
            return UTSPromise.resolve(null)
        }
        var capabilities: NetworkCapabilities? = connectivityManager.getNetworkCapabilities(network!!)
        if (capabilities == null) {
            return UTSPromise.resolve(null)
        }
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            return UTSPromise.resolve("WiFi")
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            return UTSPromise.resolve("Mobile")
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
            return UTSPromise.resolve("WiredNetwork")
        }
    } else {
        var networkInfo: NetworkInfo? = connectivityManager.getActiveNetworkInfo()
        if (networkInfo != null && networkInfo.isConnected()) {
            var type = networkInfo.getType()
            if (type == ConnectivityManager.TYPE_WIFI) {
                return UTSPromise.resolve("WiFi")
            } else if (type == ConnectivityManager.TYPE_MOBILE) {
                return UTSPromise.resolve("Mobile")
            } else {
                return UTSPromise.resolve("WiredNetwork")
            }
        }
    }
    return UTSPromise.resolve(null)
}
fun changeByBig(call: (conecting: Boolean) -> Unit) {
    netmarnger = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    open class xnetworkCallback : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            console.log("网络可用")
            call(true)
        }
        override fun onLost(network: Network) {
            super.onLost(network)
            console.log("网络断开")
            call(false)
        }
        override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities)
        }
    }
    networkCallback = xnetworkCallback() as NetworkCallback
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        netmarnger!!.registerDefaultNetworkCallback(networkCallback!!)
    } else {
        var builder = NetworkRequest.Builder()
        var networkRequest = builder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build()
        netmarnger!!.registerNetworkCallback(networkRequest, networkCallback!!)
    }
}
fun xNetChange(call: (conecting: Boolean) -> Unit) {
    changeByBig(call)
}
fun xUnNetChange() {
    if (networkCallback != null && netmarnger != null) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            netmarnger!!.unregisterNetworkCallback(networkCallback!!)
        } else {
            var builder = NetworkRequest.Builder()
            var networkRequest = builder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build()
            netmarnger!!.unregisterNetworkCallback(networkCallback!!)
        }
    }
}
