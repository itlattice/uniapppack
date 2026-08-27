package uts.sdk.modules.iboxsBleBluetooth

import android.bluetooth.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.IOException
import java.nio.ByteBuffer
import java.util.*
import java.util.concurrent.*
import io.dcloud.uts.console

// 定义一个类型别名用于简化回调函数的定义
typealias DeviceFoundCallback = (device: BluetoothDevice, rssi: Int) -> Unit
typealias PermissionCallback = (allGranted: Boolean) -> Unit
typealias BluetoothStateCallback = (isEnabled: Boolean) -> Unit
typealias EnableBluetoothCallback = (success: Boolean) -> Unit
typealias ConnectionCallback = (success: Boolean) -> Unit
// 新增类型别名，支持回调字符串或ByteBuffer
typealias DataReceiveCallback = (data: Any) -> Unit
typealias ReceiveCallback = (connect: Boolean, msg: String) -> Unit
// 新增类型别名
typealias ServiceDiscoveryCallback = (success: Boolean) -> Unit
typealias WriteDataCallback = (success: Boolean) -> Unit

object Bluetooth {
	// 新增常量，定义每个包的最大字节数
	private const val MAX_PACKET_SIZE = 20 // 蓝牙BLE通常MTU为23字节，减去3字节的协议开销，有效负载通常为20字节

	// 新增变量，用于存储待发送的ByteBuffer
	private var bufferToSend: ByteBuffer? = null
	private var writeCallback: WriteDataCallback? = null
	private var packetCount = 0
	private var successCount = 0
	private var failedCount = 0
	
	
    private var context: Context? = null
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private var bluetoothGatt: BluetoothGatt? = null
    private var dataReceiveListener: DataReceiveCallback? = null
    private var receiveCallback: ReceiveCallback? = null
    private var returnByteBuffer = false // 新增变量，用于标记是否返回ByteBuffer
    private var executor: ExecutorService = Executors.newSingleThreadExecutor()
    private var permissionCallback: PermissionCallback? = null
    private var bluetoothStateCallback: BluetoothStateCallback? = null
    private var enableBluetoothCallback: EnableBluetoothCallback? = null
    private val pairedDevices = mutableSetOf<String>() // 存储已配对设备的地址
    private var connectionCallback: ConnectionCallback? = null
    private var connectionRetryCount = 0
    private val maxConnectionRetries = 3
    private val scheduledExecutor: ScheduledExecutorService = Executors.newScheduledThreadPool(1)
    private var isConnecting = false
    private var keepAliveTimer: Timer? = null
    private var bondStateChangedReceiver: BroadcastReceiver? = null

    // 新增：记录广播接收器是否已注册
    private var isReceiverRegistered = false
    private var isStateReceiverRegistered = false
    private var isExecutorShutdown = false
    // 新增：记录已发现的设备地址，避免重复回调
    private val discoveredDevices = mutableSetOf<String>()

    private var targetDevice: BluetoothDevice? = null
    private var targetService: BluetoothGattService? = null
    private var targetCharacteristic: BluetoothGattCharacteristic? = null
    private var serviceDiscoveryCallback: ServiceDiscoveryCallback? = null
    private var writeDataCallback: WriteDataCallback? = null

    // 初始化蓝牙适配器并注册广播接收器监听蓝牙状态变化
    fun init(context: Context): Boolean {
        this.context = context
        if (bluetoothAdapter == null) {
            // 设备不支持蓝牙
            return false
        }

        try {
            // 注册广播接收器
            val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
            filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
            context.registerReceiver(receiver, filter)
            isReceiverRegistered = true

            // 注册蓝牙状态变化的接收器
            val stateFilter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
            context.registerReceiver(bluetoothStateReceiver, stateFilter)
            isStateReceiverRegistered = true

            // 初始化已配对设备集合
            updatePairedDevicesSet()

            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    // 更新已配对设备集合
    private fun updatePairedDevicesSet() {
        pairedDevices.clear()
        val devices = bluetoothAdapter?.bondedDevices ?: return
        for (device in devices) {
            pairedDevices.add(device.address)
        }
    }

    // 检查蓝牙是否已启用（避免直接调用isBluetoothEnabled导致栈溢出）
    fun getBluetoothEnabledState(): Boolean {
        return bluetoothAdapter?.isEnabled ?: false
    }

    // 检查蓝牙是否已开启，未开启时请求开启，并将结果回调
    fun checkAndEnableBluetooth(callback: EnableBluetoothCallback) {
        if (bluetoothAdapter == null) {
            console.log("设备不支持蓝牙")
            callback(false)
            return
        }

        if (getBluetoothEnabledState()) {
            console.log("蓝牙已开启")
            callback(true)
            return
        }

        console.log("蓝牙未开启，请求开启")
        enableBluetoothCallback = callback
        enableBluetooth()
    }

    // 请求启用蓝牙，并增加立即回调蓝牙状态的功能
    fun enableBluetooth(callback: EnableBluetoothCallback? = null) {
        // 立即检查蓝牙状态并回调
        val isEnabled = getBluetoothEnabledState()
        callback?.invoke(isEnabled)

        if (isEnabled) {
            console.log("蓝牙已开启，无需请求")
            return
        }

        // 使用反射获取当前Activity
        val currentActivity = getCurrentActivity()
        currentActivity?.let { activity ->
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            activity.startActivityForResult(enableBtIntent, 1002)
        } ?: run {
            console.log("无法获取当前Activity，无法请求启用蓝牙")
            enableBluetoothCallback?.invoke(false)
            enableBluetoothCallback = null
        }
    }

    // 处理蓝牙启用请求的结果
    fun handleEnableBluetoothResult(requestCode: Int, resultCode: Int) {
        if (requestCode == 1002) {
            val success = resultCode == android.app.Activity.RESULT_OK
            console.log("蓝牙启用请求结果: ${if (success) "成功" else "失败"}")
            enableBluetoothCallback?.invoke(success)
            enableBluetoothCallback = null
        }
    }

    // 蓝牙状态变化的广播接收器
    private val bluetoothStateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action
            if (action == BluetoothAdapter.ACTION_STATE_CHANGED) {
                val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
                when (state) {
                    BluetoothAdapter.STATE_ON -> {
                        console.log("蓝牙已启用")
                        updatePairedDevicesSet() // 蓝牙启用后更新已配对设备集合
                        bluetoothStateCallback?.invoke(true)
                    }
                    BluetoothAdapter.STATE_OFF -> {
                        console.log("蓝牙已关闭")
                        bluetoothStateCallback?.invoke(false)
                    }
                }
            }
        }
    }

    // 设置蓝牙状态变化回调
    fun setBluetoothStateCallback(callback: BluetoothStateCallback) {
        bluetoothStateCallback = callback
    }

    // 使用反射获取当前Activity
    private fun getCurrentActivity(): android.app.Activity? {
        try {
            // 尝试获取当前Activity
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            val activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null)
            val activitiesField = activityThreadClass.getDeclaredField("mActivities")
            activitiesField.isAccessible = true

            val activities = activitiesField.get(activityThread) as? Map<*, *> ?: return null

            for (activityRecord in activities.values) {
                val activityRecordClass = activityRecord?.javaClass ?: continue
                val pausedField = activityRecordClass.getDeclaredField("paused")
                pausedField.isAccessible = true

                if (!pausedField.getBoolean(activityRecord)) {
                    val activityField = activityRecordClass.getDeclaredField("activity")
                    activityField.isAccessible = true
                    return activityField.get(activityRecord) as? android.app.Activity
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    // 检查蓝牙权限（修改为接受Context参数）
    fun checkBluetoothPermissions(context: Context, callback: PermissionCallback) {
        permissionCallback = callback

        val requiredPermissions = mutableListOf<String>()

        // 添加蓝牙基础权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            requiredPermissions.add(android.Manifest.permission.BLUETOOTH_CONNECT)
            requiredPermissions.add(android.Manifest.permission.BLUETOOTH_SCAN)
        } else {
            requiredPermissions.add(android.Manifest.permission.BLUETOOTH)
            requiredPermissions.add(android.Manifest.permission.BLUETOOTH_ADMIN)
        }

        // 添加位置权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            requiredPermissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            requiredPermissions.add(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        // 检查并请求缺失的权限
        val missingPermissions = requiredPermissions.filter {
            ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
        }

        if (missingPermissions.isEmpty()) {
            console.log("所有蓝牙和位置权限已授予")
            callback(true)
        } else {
            console.log("请求缺失的权限: ${missingPermissions.joinToString()}")

            // 使用反射获取当前Activity
            val currentActivity = getCurrentActivity()
            currentActivity?.let { activity ->
                ActivityCompat.requestPermissions(
                    activity,
                    missingPermissions.toTypedArray(),
                    1001
                )
            } ?: run {
                console.log("无法获取当前Activity，无法请求权限")
                callback(false)
            }
        }
    }

    // 检查位置服务是否已启用
    fun isLocationServiceEnabled(): Boolean {
        if (context == null) return false

        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as? android.location.LocationManager
        return locationManager?.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER) ?: false
    }

    // 处理权限请求结果
    fun handlePermissionResult(requestCode: Int, grantResults: IntArray) {
        if (requestCode == 1001) {
            var allGranted = true
            for (result in grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false
                    break
                }
            }

            if (allGranted) {
                console.log("用户授予了所有请求的权限")
            } else {
                console.log("用户拒绝了部分或全部请求的权限")
            }

            permissionCallback?.invoke(allGranted)
        }
    }

    // 扫描蓝牙设备，并传入一个回调函数处理每次发现的设备
    fun startDiscovery(callback: DeviceFoundCallback?): Boolean {
        if (context == null) {
            console.log("上下文为空，无法开始扫描")
            return false
        }

        // 检查蓝牙是否已启用
        if (!getBluetoothEnabledState()) {
            console.log("蓝牙未启用，无法开始扫描")
            return false
        }

        // 检查权限（包括位置权限）
        if (!hasRequiredPermissions()) {
            console.log("缺少蓝牙扫描所需的权限")
            return false
        }

        // 检查位置服务是否已启用（Android 6.0+ 需要）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !isLocationServiceEnabled()) {
            console.log("位置服务未启用，无法开始蓝牙扫描")
            return false
        }

        // 取消当前正在进行的发现（如果有）
        if (bluetoothAdapter?.isDiscovering == true) {
            console.log("取消当前正在进行的蓝牙扫描")
            bluetoothAdapter.cancelDiscovery()
        }

        // 清空已发现设备集合
        discoveredDevices.clear()
        val scanCallback = object : BluetoothAdapter.LeScanCallback {
            override fun onLeScan(device: BluetoothDevice?, rssi: Int, scanRecord: ByteArray?) {
                device?.let {
                    // 检查是否已经发现过该设备
                    if (!discoveredDevices.contains(it.address)) {
                        discoveredDevices.add(it.address)
                        console.log("发现新蓝牙设备: ${it.name ?: "未知设备"}, 地址: ${it.address}, RSSI: $rssi")
                        callback?.invoke(it, rssi)
                    }
                }
            }
        }
        val isStarted = bluetoothAdapter?.startLeScan(scanCallback) ?: false

        if (isStarted) {
            console.log("蓝牙扫描已启动")
        } else {
            console.log("蓝牙扫描启动失败")
        }

        return isStarted
    }

    // 停止扫描蓝牙设备
    fun stopDiscovery(): Boolean {
        val result = bluetoothAdapter?.stopLeScan { _, _, _ -> } ?: false
        if (result!=false) {
            console.log("蓝牙扫描已停止")
            return true
        } else {
            console.log("停止蓝牙扫描失败")
            return false
        }
    }

    // 广播接收器用于发现蓝牙设备
    private var deviceFoundListener: DeviceFoundCallback? = null

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                BluetoothDevice.ACTION_FOUND -> {
                    // Discovery has found a device. Get the BluetoothDevice object and its info from the Intent.
                    val device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    val rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE).toInt()

                    device?.let {
                        console.log("发现蓝牙设备: ${it.name ?: "未知设备"}, 地址: ${it.address}, RSSI: $rssi")
                        if (!pairedDevices.contains(it.address)) {
                            deviceFoundListener?.invoke(it, rssi)
                        }
                    }
                }
                BluetoothAdapter.ACTION_DISCOVERY_FINISHED -> {
                    console.log("蓝牙扫描完成")
                }
            }
        }
    }

    // 设置设备发现监听器
    private fun setOnDeviceFoundListener(listener: DeviceFoundCallback) {
        deviceFoundListener = listener
    }

    // 取消注册广播接收器
    private fun unregisterBondStateReceiver() {
        context?.unregisterReceiver(bondStateChangedReceiver)
    }

    // 检查是否有必要的权限
    private fun hasRequiredPermissions(): Boolean {
        val requiredPermissions = mutableListOf<String>()

        // 添加蓝牙基础权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            requiredPermissions.add(android.Manifest.permission.BLUETOOTH_CONNECT)
            requiredPermissions.add(android.Manifest.permission.BLUETOOTH_SCAN)
        } else {
            requiredPermissions.add(android.Manifest.permission.BLUETOOTH)
            requiredPermissions.add(android.Manifest.permission.BLUETOOTH_ADMIN)
        }

        // 添加位置权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            requiredPermissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            requiredPermissions.add(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        return requiredPermissions.all {
            ContextCompat.checkSelfPermission(context!!, it) == PackageManager.PERMISSION_GRANTED
        }
    }
	
    private var serviceUuidFilter: String? = null
    private var characteristicUuidFilter: String? = null

    // 连接低功耗蓝牙设备
    fun connectToDevice(device: BluetoothDevice, callback: ConnectionCallback) {
        if (isConnecting) {
            console.log("正在连接中，请勿重复连接")
            callback(false)
            return
        }

        isConnecting = true
        connectionCallback = callback
        targetDevice = device
        connectionRetryCount = 0

        executor.submit {
            bluetoothGatt = device.connectGatt(context, false, gattCallback)
        }
    }

    // 自动发现并选择服务和特征
	private fun discoverAndSelectServiceAndCharacteristic(gatt: BluetoothGatt) {
		val services = gatt.services
		console.log("发现${services.size}个服务")
		
		// 自动发现服务
		val targetService = if (serviceUuidFilter != null) {
			services.firstOrNull { it.uuid.toString().contains(serviceUuidFilter!!, ignoreCase = true) }
		} else {
			// 如果没有指定过滤器，尝试寻找具有WRITE权限的特征所在的服务
			services.firstOrNull { service ->
				service.characteristics.any { it.properties and BluetoothGattCharacteristic.PROPERTY_WRITE != 0 }
			}
		}
		
		if (targetService == null) {
			console.log("未找到匹配的服务")
			serviceDiscoveryCallback?.invoke(false)
			return
		}
		
		console.log("已选择服务: ${targetService.uuid}")
		this.targetService = targetService
		
		// 自动发现特征
		val characteristics = targetService.characteristics
		console.log("在服务中发现${characteristics.size}个特征")
		
		val targetCharacteristic = if (characteristicUuidFilter != null) {
			characteristics.firstOrNull { it.uuid.toString().contains(characteristicUuidFilter!!, ignoreCase = true) }
		} else {
			// 如果没有指定过滤器，选择第一个具有WRITE权限的特征
			characteristics.firstOrNull { it.properties and BluetoothGattCharacteristic.PROPERTY_WRITE != 0 }
		}
		
		if (targetCharacteristic == null) {
			console.log("未找到匹配的可写特征")
			serviceDiscoveryCallback?.invoke(false)
			return
		}
		
		console.log("已选择特征: ${targetCharacteristic.uuid}")
		this.targetCharacteristic = targetCharacteristic
		serviceDiscoveryCallback?.invoke(true)
	}
	
	// 设置服务和特征过滤条件
	fun setServiceAndCharacteristicFilters(serviceUuid: String? = null, characteristicUuid: String? = null) {
		this.serviceUuidFilter = serviceUuid
		this.characteristicUuidFilter = characteristicUuid
	}
	
	private val gattCallback = object : BluetoothGattCallback() {
	    override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
	        super.onConnectionStateChange(gatt, status, newState)
	        when (newState) {
	            BluetoothProfile.STATE_CONNECTED -> {
	                console.log("蓝牙设备已连接")
	                isConnecting = false
	                connectionCallback?.invoke(true)
	                // 连接成功后开始发现服务
	                gatt.discoverServices()
	            }
	            BluetoothProfile.STATE_DISCONNECTED -> {
	                console.log("蓝牙设备已断开连接")
	                isConnecting = false
	                connectionCallback?.invoke(false)
	                if (connectionRetryCount < maxConnectionRetries) {
	                    connectionRetryCount++
	                    targetDevice?.let { connectToDevice(it, connectionCallback!!) }
	                }
	            }
	        }
	    }
	
	    override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
	        super.onServicesDiscovered(gatt, status)
	        if (status == BluetoothGatt.GATT_SUCCESS) {
	            console.log("服务发现成功")
	            // 自动发现并选择服务和特征
	            discoverAndSelectServiceAndCharacteristic(gatt)
	        } else {
	            console.log("服务发现失败")
	            serviceDiscoveryCallback?.invoke(false)
	        }
	    }
	
	    override fun onCharacteristicWrite(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, status: Int) {
	        super.onCharacteristicWrite(gatt, characteristic, status)
	        if (status == BluetoothGatt.GATT_SUCCESS) {
	            console.log("第${packetCount}个包发送成功")
	            successCount++
	        } else {
	            console.log("第${packetCount}个包发送失败，状态码: $status")
	            failedCount++
	        }
	        // 继续发送下一个包
	        sendNextPacket()
	    }
	}
    // 设置服务发现回调
    fun setServiceDiscoveryCallback(callback: ServiceDiscoveryCallback) {
        serviceDiscoveryCallback = callback
    }
	
    // 向低功耗蓝牙设备发送数据
    fun writeDataToDevice(data: ByteBuffer, autoDisconnect: Boolean = false, callback: WriteDataCallback) {
        if (targetCharacteristic == null) {
            console.log("未找到目标特征，无法发送数据")
            callback(false)
            return
        }
    
        // 检查是否有正在进行的发送操作
        if (bufferToSend != null) {
            console.log("有正在进行的发送操作，请等待完成")
            callback(false)
            return
        }
    
        // 保存回调、数据和是否自动断开的标志
        writeCallback = callback
        bufferToSend = data
        packetCount = 0
        successCount = 0
        failedCount = 0
        this.autoDisconnectAfterSend = autoDisconnect
    
        // 开始发送第一个包
        sendNextPacket()
    }
    
    // 新增：是否在发送完成后自动断开连接的标志
    private var autoDisconnectAfterSend = false
    
    
    // 断开蓝牙连接
    fun disconnect() {
        executor.submit {
            bluetoothGatt?.disconnect()
            bluetoothGatt?.close()
            bluetoothGatt = null
            console.log("蓝牙连接已断开")
        }
    }

	// 发送下一个数据包
	private fun sendNextPacket() {
		val buffer = bufferToSend ?: return

		if (buffer.remaining() <= 0) {
			// 所有数据包已发送完毕，回调结果
			val success = failedCount == 0
			console.log("数据发送完成，共发送${packetCount}个包，成功${successCount}个，失败${failedCount}个")
			writeCallback?.invoke(success)
			// 如果启用了自动断开，则断开连接
			if (autoDisconnectAfterSend) {
				console.log("数据发送完成，正在断开连接...")
				disconnect()
			}
			// 重置状态
			bufferToSend = null
			writeCallback = null
			packetCount = 0
			successCount = 0
			failedCount = 0
			return
		}

		// 计算当前包的大小
		val size = minOf(buffer.remaining(), MAX_PACKET_SIZE)
		val packet = ByteArray(size)
		buffer.get(packet)
		packetCount++

		// 设置要发送的数据
		targetCharacteristic?.value = packet
		val success = bluetoothGatt?.writeCharacteristic(targetCharacteristic) ?: false
		
		if (!success) {
			console.log("发送第${packetCount}个包失败")
			failedCount++
			// 继续尝试发送下一个包
			sendNextPacket()
		} else {
			console.log("正在发送第${packetCount}个包，大小: ${size}字节")
		}
	}
}