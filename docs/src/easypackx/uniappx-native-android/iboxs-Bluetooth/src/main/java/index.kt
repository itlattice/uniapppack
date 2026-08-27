@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsBluetooth
import android.app.Activity
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
import java.nio.ByteBuffer
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
typealias Init = () -> Boolean
typealias CheckBluetoothPermissions = (callback: (res: Boolean) -> Unit) -> Unit
typealias CheckAndEnableBluetooth = (callback: (res: Boolean) -> Unit) -> Unit
typealias IsLocationServiceEnabled = () -> Boolean
typealias CancelBluetoothStateCallback = () -> Unit
typealias CancelReceiveListener = () -> Unit
typealias IsDevicePaired = (address: String) -> Boolean
typealias GetPairedDevices = () -> UTSArray<blueDevice>
typealias StopDiscovery = () -> Boolean
typealias PairDevice = (device: blueDevice, callback: (res: Boolean) -> Unit) -> Boolean
typealias ConnectDevice = (device: blueDevice, callback: (result: Boolean) -> Unit, keepActive: Boolean) -> Unit
typealias SendData = (str: String) -> Unit
typealias SendBufferData = (data: ArrayBuffer) -> Unit
typealias StopListeningForData = () -> Unit
typealias CloseConnection = () -> Boolean
typealias UnpairDevice = (device: blueDevice) -> Boolean
val deviceList = _uA<BluetoothDevice>()
val init: Init = fun(): Boolean {
    deviceList.splice(0, deviceList.length)
    return AppBluetoothManager.init(UTSAndroid.getAppContext() as Context) as Boolean
}
val checkBluetoothPermissions: CheckBluetoothPermissions = fun(callback: (result: Boolean) -> Unit): Unit {
    AppBluetoothManager.checkBluetoothPermissions(UTSAndroid.getAppContext() as Context, fun(res: Boolean) {
        callback(res)
    }
    )
}
val checkAndEnableBluetooth: CheckAndEnableBluetooth = fun(callback: (result: Boolean) -> Unit): Unit {
    AppBluetoothManager.checkAndEnableBluetooth(callback)
}
val isLocationServiceEnabled: IsLocationServiceEnabled = fun(): Boolean {
    return AppBluetoothManager.isLocationServiceEnabled()
}
fun startDiscovery(includePaired: Boolean, callback: (device: blueDevice) -> Unit): Boolean {
    return AppBluetoothManager.startDiscovery(includePaired, fun(device: BluetoothDevice, rssi: Int) {
        var dev = blueDevice(name = device.name, address = device.address, type = device.type, uuids = device.uuids, rssi = rssi)
        deviceList.push(device)
        callback(dev)
    }
    ) as Boolean
}
val stopDiscovery: StopDiscovery = fun(): Boolean {
    return AppBluetoothManager.stopDiscovery() as Boolean
}
fun setBluetoothStateCallback(callback: (result: Boolean) -> Unit): Unit {
    return AppBluetoothManager.setBluetoothStateCallback(callback)
}
val cancelBluetoothStateCallback: CancelBluetoothStateCallback = fun(): Unit {
    return AppBluetoothManager.cancelBluetoothStateCallback()
}
val isDevicePaired: IsDevicePaired = fun(address: String): Boolean {
    return AppBluetoothManager.isDevicePaired(address)
}
val pairDevice: PairDevice = fun(device: blueDevice, callback: (result: Boolean) -> Unit): Boolean {
    var dev = deviceList.first()
    for(item in resolveUTSKeyIterator(deviceList)){
        if (item.address == device.address) {
            dev = item
            break
        }
    }
    console.log(dev.address)
    return AppBluetoothManager.pairDevice(dev, fun(res: Boolean) {
        callback(res)
    }
    ) as Boolean
}
val connectDevice: ConnectDevice = fun(device: blueDevice, callback: (result: Boolean) -> Unit, keepActive: Boolean): Unit {
    var dev = deviceList.first()
    for(item in resolveUTSKeyIterator(deviceList)){
        if (item.address == device.address) {
            dev = item
            break
        }
    }
    console.log(dev.address)
    AppBluetoothManager.connect(dev, callback, keepActive)
}
val sendData: SendData = fun(str: String) {
    return AppBluetoothManager.sendData(str)
}
val sendBufferData: SendBufferData = fun(data: ArrayBuffer) {
    var dataBuffer: ByteBuffer = data.toByteBuffer()
    return AppBluetoothManager.sendData(dataBuffer)
}
fun setDataReceiveListener(listener: (data: Any) -> Unit, returnArrayBuffer: Boolean): Unit {
    return AppBluetoothManager.setDataReceiveListener(fun(data: Any) {
        if (returnArrayBuffer == true) {
            var dataByte = data as ByteBuffer
            var dataArray = ArrayBuffer.fromByteBuffer(dataByte)
            listener(dataArray)
        } else {
            listener(data)
        }
    }
    , returnArrayBuffer)
}
val stopListeningForData: StopListeningForData = fun(): Unit {
    AppBluetoothManager.stopListeningForData()
}
fun setReceiveListener(listener: (connected: Boolean, msg: String) -> Unit) {
    return AppBluetoothManager.setReceiveListener(fun(connected: Boolean, msg: String) {
        listener(connected, msg)
    }
    )
}
val cancelReceiveListener: CancelReceiveListener = fun(): Unit {
    return AppBluetoothManager.cancelReceiveListener()
}
val getPairedDevices: GetPairedDevices = fun(): UTSArray<blueDevice> {
    var list = AppBluetoothManager.getPairedDevices()
    var result = _uA<blueDevice>()
    for(item in resolveUTSValueIterator(list)){
        deviceList.push(item)
        var dev = blueDevice(name = item.name, address = item.address, type = item.type, uuids = item.uuids)
        result.push(dev)
    }
    return result
}
val closeConnection: CloseConnection = fun(): Boolean {
    return AppBluetoothManager.closeBluetoothConnection()
}
val unpairDevice: UnpairDevice = fun(device: blueDevice): Boolean {
    var dev = deviceList.first()
    for(item in resolveUTSKeyIterator(deviceList)){
        if (item.address == device.address) {
            dev = item
            break
        }
    }
    console.log(dev.address)
    return AppBluetoothManager.unpairDevice(dev)
}
