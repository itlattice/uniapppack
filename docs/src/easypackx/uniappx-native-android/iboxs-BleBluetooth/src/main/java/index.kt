@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsBleBluetooth
import android.bluetooth.*
import android.content.Context
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
open class blueDevice (
    open var name: String? = null,
    open var address: String? = null,
    open var type: Int? = null,
    open var uuids: Any? = null,
    open var rssi: Int? = null,
) : UTSObject()
val deviceList = _uA<BluetoothDevice>()
val initBleBluetooth = fun(): Boolean {
    return Bluetooth.init(UTSAndroid.getAppContext() as Context) as Boolean
}
val getBluetoothEnabledState = fun(): Boolean {
    return Bluetooth.getBluetoothEnabledState() as Boolean
}
val checkAndEnableBluetooth = fun(callback: (result: Boolean) -> Unit): Unit {
    Bluetooth.checkAndEnableBluetooth(callback)
}
val checkBluetoothPermissions = fun(callback: (result: Boolean) -> Unit): Unit {
    Bluetooth.checkBluetoothPermissions(UTSAndroid.getAppContext() as Context, fun(res: Boolean) {
        callback(res)
    }
    )
}
val isLocationServiceEnabled = fun(): Boolean {
    return Bluetooth.isLocationServiceEnabled()
}
val setBluetoothStateCallback = fun(callback: (result: Boolean) -> Unit): Unit {
    Bluetooth.setBluetoothStateCallback(fun(res: Boolean) {
        callback(res)
    }
    )
}
val startDiscovery = fun(callback: (device: blueDevice) -> Unit): Boolean {
    return Bluetooth.startDiscovery(fun(device: BluetoothDevice, rssi: Int) {
        var dev = blueDevice(name = device.name, address = device.address, type = device.type, uuids = device.uuids, rssi = rssi)
        deviceList.push(device)
        callback(dev)
    }
    ) as Boolean
}
val stopDiscovery = fun(): Boolean {
    return Bluetooth.stopDiscovery() as Boolean
}
val connectToDevice = fun(device: blueDevice, callback: (result: Boolean) -> Unit) {
    var dev = deviceList.first()
    for(item in resolveUTSKeyIterator(deviceList)){
        if (item.address == device.address) {
            dev = item
            break
        }
    }
    Bluetooth.connectToDevice(dev, callback)
}
val setServiceDiscoveryCallback = fun(callback: (result: Boolean) -> Unit) {
    Bluetooth.setServiceDiscoveryCallback(callback)
}
val writeDataToDevice = fun(data: ArrayBuffer, callback: (result: Boolean) -> Unit) {
    Bluetooth.writeDataToDevice(data.toByteBuffer(), true, callback)
}
