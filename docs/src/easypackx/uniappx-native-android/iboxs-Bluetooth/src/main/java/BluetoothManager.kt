package uts.sdk.modules.iboxsBluetooth

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
typealias ReceiveCallback=(connect:Boolean,msg:String)->Unit

object AppBluetoothManager {
    private var context: Context? = null
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private var bluetoothSocket: BluetoothSocket? = null
    private var dataReceiveListener: DataReceiveCallback? = null
	private var receiveCallback: ReceiveCallback? = null
    private var returnByteBuffer = false // 新增变量，用于标记是否返回ByteBuffer
    private var executor: ExecutorService = Executors.newSingleThreadExecutor()
    private var bondStateChangedReceiver: BroadcastReceiver? = null
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
    
    // 新增：记录广播接收器是否已注册
    private var isReceiverRegistered = false
    private var isStateReceiverRegistered = false
    private var isExecutorShutdown = false
	
	private const val MAX_PACKET_SIZE = 1024
    
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
                        closeConnection()
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
    
    // 取消蓝牙状态变化回调
    fun cancelBluetoothStateCallback() {
        bluetoothStateCallback = null
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
    // includePaired参数控制是否返回已配对的设备
    fun startDiscovery(includePaired: Boolean = false, callback: DeviceFoundCallback?): Boolean {
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

        console.log("尝试开始蓝牙扫描，includePaired: $includePaired")
        val isStarted = bluetoothAdapter?.startDiscovery() ?: false

        // 如果提供了回调函数，则设置广播接收器中的回调
        if (callback != null && isStarted) {
            setOnDeviceFoundListener(includePaired, callback)
            console.log("蓝牙扫描已启动")
        } else {
            console.log("蓝牙扫描启动失败")
        }

        return isStarted
    }

    // 停止扫描蓝牙设备
    fun stopDiscovery(): Boolean {
        val result = bluetoothAdapter?.cancelDiscovery() ?: false
        if (result) {
            console.log("蓝牙扫描已停止")
        } else {
            console.log("停止蓝牙扫描失败")
        }
        return result
    }

    // 获取已配对设备列表
    fun getPairedDevices(): List<BluetoothDevice> {
        val devices = mutableListOf<BluetoothDevice>()
        if (context == null || !getBluetoothEnabledState() || !hasRequiredPermissions()) {
            return devices
        }
        
        val pairedDevices = bluetoothAdapter?.bondedDevices ?: return devices
        return pairedDevices.toList()
    }

    // 创建连接
    fun connect(device: BluetoothDevice, onConnectionResult: ConnectionCallback, keepActive: Boolean) {
        if (context == null) {
            console.log("上下文为空，无法建立连接")
            onConnectionResult(false)
            return
        }
        
        // 检查蓝牙是否已启用
        if (!getBluetoothEnabledState()) {
            console.log("蓝牙未启用，无法建立连接")
            onConnectionResult(false)
            return
        }
        
        // 检查权限
        if (!hasRequiredPermissions()) {
            console.log("缺少蓝牙连接所需的权限")
            onConnectionResult(false)
            return
        }
        
        if (isConnecting) {
            console.log("正在尝试连接中，请勿重复请求")
            onConnectionResult(false)
            return
        }
        
        // 修复：添加UUID获取的空安全处理
        val uuid = device.uuids?.firstOrNull()?.uuid ?: UUID.fromString("00001101-0000-1000-8000-00805F9B34FB") // 默认SPP UUID
        console.log("尝试连接到设备: ${device.name}, UUID: $uuid")
        
        isConnecting = true
        connectionCallback = onConnectionResult
        connectionRetryCount = 0
        
        connectWithRetry(device, uuid, keepActive)
    }
    
    // 带重试机制的连接方法
    private fun connectWithRetry(device: BluetoothDevice, uuid: UUID, keepActive: Boolean) {
        // 检查执行器状态，如果已关闭则重新创建
        if (executor.isShutdown || executor.isTerminated) {
            synchronized(this) {
                if (executor.isShutdown || executor.isTerminated) {
                    executor = Executors.newSingleThreadExecutor()
                    isExecutorShutdown = false
                    console.log("重新创建线程池执行器")
                }
            }
        }
        
        try {
            executor.execute {
                try {
                    // 先检查设备是否已配对
                    if (!isDevicePaired(device.address)) {
                        console.log("设备未配对，尝试配对: ${device.name}")
                        pairDevice(device) { success ->
                            if (success) {
                                console.log("配对成功，继续连接: ${device.name}")
                                connectInternal(device, uuid, keepActive)
                            } else {
                                console.log("配对失败，无法连接: ${device.name}")
                                onConnectionFailed("配对失败")
                            }
                        }
                    } else {
                        // 设备已配对，尝试连接
                        connectInternal(device, uuid, keepActive)
                    }
                } catch (e: Exception) {
                    console.log("连接过程中发生错误: ${e.message}")
                    e.printStackTrace()
                    onConnectionFailed("连接异常: ${e.message}")
                } catch (e: RejectedExecutionException) {
                    console.log("线程池拒绝执行连接任务: ${e.message}")
                    // 标记执行器已关闭
                    isExecutorShutdown = true
                }
            }
        } catch (e: RejectedExecutionException) {
            console.log("提交任务到线程池失败: ${e.message}")
            // 标记执行器已关闭
            isExecutorShutdown = true
        }
    }
    
    // 内部连接方法
    private fun connectInternal(device: BluetoothDevice, uuid: UUID, keepActive: Boolean) {
        try {
            // 关闭之前的连接
            closeConnection()
            console.log("尝试创建蓝牙连接，设备: ${device.name}, UUID: $uuid")
            
            // 修复：添加空安全检查
            bluetoothSocket = createBluetoothSocket(device, uuid)
            bluetoothSocket?.connect()
            
            console.log("蓝牙连接已建立")
            isConnecting = false
            connectionCallback?.invoke(true)
            connectionCallback = null
            if (keepActive) {
                // 启动心跳检测
                startKeepAliveTimer()
            }
            // 开始监听数据
            startListeningForData()
			receiveCallback?.invoke(true,"蓝牙连接成功")
        } catch (e: IOException) {
            console.log("蓝牙连接失败: ${e.message}")
			receiveCallback?.invoke(false,"蓝牙连接失败")
            
            // 关闭当前连接
            closeConnection()
            
            // 检查是否是因为配对丢失导致的连接失败
            if (!isDevicePaired(device.address)) {
                console.log("检测到配对丢失，尝试重新配对: ${device.name}")
                pairDevice(device) { success ->
                    if (success) {
                        console.log("重新配对成功，再次尝试连接: ${device.name}")
                        try {
                            connectInternal(device, uuid, keepActive)
                        } catch (e: IOException) {
                            handleConnectionError(e, device, uuid, keepActive)
                        }
                    } else {
                        console.log("重新配对失败")
                        onConnectionFailed("重新配对失败")
                    }
                }
            } else {
                handleConnectionError(e, device, uuid, keepActive)
            }
        }
    }
    
    // 创建蓝牙socket（尝试多种方法以兼容不同设备）
    @Throws(IOException::class)
    private fun createBluetoothSocket(device: BluetoothDevice, uuid: UUID): BluetoothSocket {
        return try {
            // 尝试使用标准方法
            device.createRfcommSocketToServiceRecord(uuid)
        } catch (e: Exception) {
            console.log("标准socket创建失败，尝试反射方法: ${e.message}")
            // 尝试使用反射方法（某些设备需要）
            val method = device.javaClass.getMethod("createRfcommSocket", Int::class.javaPrimitiveType)
            method.invoke(device, 1) as BluetoothSocket
        }
    }
    
    // 处理连接错误并尝试重试
    private fun handleConnectionError(e: IOException, device: BluetoothDevice, uuid: UUID, keepActive: Boolean) {
        connectionRetryCount++
        
        if (connectionRetryCount <= maxConnectionRetries) {
            val delay = connectionRetryCount * 2000L // 指数退避策略
            console.log("连接失败，尝试第${connectionRetryCount}/${maxConnectionRetries}次重试，${delay/1000}秒后...")
            
            scheduledExecutor.schedule({
                connectInternal(device, uuid, keepActive)
            }, delay, TimeUnit.MILLISECONDS)
        } else {
            onConnectionFailed("连接失败，已达到最大重试次数: ${e.message}")
        }
    }
    
    // 连接失败回调
    private fun onConnectionFailed(message: String) {
        isConnecting = false
        console.log("连接失败: $message")
        connectionCallback?.invoke(false)
        connectionCallback = null
    }
    
    // 获取设备的服务UUID，如果为空则返回默认UUID
    private fun getDeviceServiceUUID(device: BluetoothDevice): UUID? {
        val uuids = device.uuids
        return if (uuids != null && uuids.isNotEmpty()) {
            uuids[0].uuid
        } else {
            null
        }
    }

    // 发送数据
    @Throws(IOException::class)
    fun sendData(data: String) {
        if (context == null) {
            console.log("上下文为空，无法发送数据")
            return
        }
        
        // 检查蓝牙是否已启用
        if (!getBluetoothEnabledState()) {
            console.log("蓝牙未启用，无法发送数据")
            return
        }
        
        // 检查权限
        if (!hasRequiredPermissions()) {
            console.log("缺少蓝牙通信所需的权限")
            return
        }
        
        // 检查连接状态
        if (bluetoothSocket == null || !bluetoothSocket!!.isConnected) {
            console.log("蓝牙连接未建立，无法发送数据")
            return
        }
        
        val byteArray = data.toByteArray()
        
        try {
            // 判断是否需要分包
            if (byteArray.size <= MAX_PACKET_SIZE) {
                // 数据量小，无需分包，直接发送
                bluetoothSocket?.outputStream?.write(byteArray)
                console.log("数据直接发送，大小: ${byteArray.size} 字节："+data)
            } else {
                // 数据量大，需要分包
                val packetCount = (byteArray.size + MAX_PACKET_SIZE - 1) / MAX_PACKET_SIZE
                for (i in 0 until packetCount) {
                    val start = i * MAX_PACKET_SIZE
                    val end = minOf(start + MAX_PACKET_SIZE, byteArray.size)
                    val packet = Arrays.copyOfRange(byteArray, start, end)
                    bluetoothSocket?.outputStream?.write(packet)
                    console.log("数据分包发送: 第 ${i + 1} 包，共 ${packetCount} 包，大小: ${packet.size} 字节")
                }
                console.log("数据分包发送完成，总大小: ${byteArray.size} 字节")
            }
        } catch (e: IOException) {
            console.log("发送数据失败: ${e.message}")
            e.printStackTrace()
            
            // 发生IO异常时，认为连接已断开
            onConnectionLost("发送数据失败: ${e.message}")
            
            throw e
        }
    }

    // 新增：发送ByteBuffer数据
    @Throws(IOException::class)
    fun sendData(data: ByteBuffer) {
        if (context == null) {
            console.log("上下文为空，无法发送数据")
            return
        }
        
        // 检查蓝牙是否已启用
        if (!getBluetoothEnabledState()) {
            console.log("蓝牙未启用，无法发送数据")
            return
        }
        
        // 检查权限
        if (!hasRequiredPermissions()) {
            console.log("缺少蓝牙通信所需的权限")
            return
        }
        
        // 检查连接状态
        if (bluetoothSocket == null || !bluetoothSocket!!.isConnected) {
            console.log("蓝牙连接未建立，无法发送数据")
            return
        }
        
        val byteArray = ByteArray(data.remaining())
        data.get(byteArray)
        
        try {
            // 判断是否需要分包
            if (byteArray.size <= MAX_PACKET_SIZE) {
                // 数据量小，无需分包，直接发送
                bluetoothSocket?.outputStream?.write(byteArray)
                console.log("ByteBuffer数据直接发送，大小: ${byteArray.size} 字节")
            } else {
                // 数据量大，需要分包
                val packetCount = (byteArray.size + MAX_PACKET_SIZE - 1) / MAX_PACKET_SIZE
                for (i in 0 until packetCount) {
                    val start = i * MAX_PACKET_SIZE
                    val end = minOf(start + MAX_PACKET_SIZE, byteArray.size)
                    val packet = Arrays.copyOfRange(byteArray, start, end)
                    bluetoothSocket?.outputStream?.write(packet)
                    console.log("ByteBuffer数据分包发送: 第 ${i + 1} 包，共 ${packetCount} 包，大小: ${packet.size} 字节")
                }
                console.log("ByteBuffer数据分包发送完成，总大小: ${byteArray.size} 字节")
            }
        } catch (e: IOException) {
            console.log("发送ByteBuffer数据失败: ${e.message}")
            e.printStackTrace()
            
            // 发生IO异常时，认为连接已断开
            onConnectionLost("发送ByteBuffer数据失败: ${e.message}")
            
            throw e
        }
    }
	
	// 设置链接状态监听器
	fun setReceiveListener(listener: ReceiveCallback) {
	    receiveCallback = listener
	}
	
	// 取消设置链接状态监听器
	fun cancelReceiveListener() {
	    receiveCallback = null
	}

    // 设置数据接收监听器
    fun setDataReceiveListener(listener: DataReceiveCallback, returnByteBuffer: Boolean = false) {
        dataReceiveListener = listener
        this.returnByteBuffer = returnByteBuffer
    }

    // 开始监听数据
    private fun startListeningForData() {
        if (context == null) {
            console.log("上下文为空，无法开始监听")
            return
        }
    
        // 检查蓝牙是否已启用
        if (!getBluetoothEnabledState()) {
            console.log("蓝牙未启用，无法开始监听")
            return
        }
    
        // 检查权限
        if (!hasRequiredPermissions()) {
            console.log("缺少蓝牙通信所需的权限")
            return
        }
    
        // 检查连接状态
        if (bluetoothSocket == null || !bluetoothSocket!!.isConnected) {
            console.log("蓝牙连接未建立，无法监听数据")
            return
        }
    
        console.log("开始监听蓝牙数据")
    
        // 检查执行器状态，如果已关闭则重新创建
        if (executor.isShutdown || executor.isTerminated) {
            synchronized(this) {
                if (executor.isShutdown || executor.isTerminated) {
                    executor = Executors.newSingleThreadExecutor()
                    isExecutorShutdown = false
                    console.log("重新创建线程池执行器")
                }
            }
        }
    
        try {
            executor.execute {
                try {
                    val inputStream = bluetoothSocket?.inputStream ?: return@execute
                    val buffer = ByteArray(1024)
    
                    while (true) {
                        // 检查连接状态
                        if (bluetoothSocket == null || !bluetoothSocket!!.isConnected) {
                            console.log("蓝牙连接已断开，停止监听")
                            break
                        }
    
                        try {
                            // 读取数据
                            val bytes = inputStream.read(buffer)
                            if (bytes > 0) {
                                if (returnByteBuffer) {
                                    // 创建一个新的ByteBuffer，长度为实际读取的字节数
                                    val byteBuffer = ByteBuffer.allocate(bytes)
                                    byteBuffer.put(buffer, 0, bytes)
                                    byteBuffer.flip() // 切换到读模式
									
                                    console.log("收到ByteBuffer数据，长度: ${byteBuffer.remaining()}")
                                    dataReceiveListener?.invoke(byteBuffer)
                                } else {
                                    val incomingMessage = String(buffer, 0, bytes)
                                    console.log("收到数据: $incomingMessage")
                                    dataReceiveListener?.invoke(incomingMessage)
                                }
                            } else if (bytes == -1) {
                                // 读取返回-1，表示连接已关闭
                                receiveCallback?.invoke(false,"read returned -1")
                                throw IOException("read returned -1")
                            }
                        } catch (e: IOException) {
                            // 发生读取错误，可能是连接断开
                            receiveCallback?.invoke(false,"读取数据失败: ${e.message}")
                            console.log("读取数据失败: ${e.message}")
                            throw e
                        }
                    }
                } catch (e: IOException) {
                    console.log("监听数据失败: ${e.message}")
                    e.printStackTrace()
    
                    // 发生IO异常时，认为连接已断开
                    onConnectionLost("监听数据失败: ${e.message}")
                } catch (e: RejectedExecutionException) {
                    console.log("线程池拒绝执行监听任务: ${e.message}")
                    // 标记执行器已关闭
                    isExecutorShutdown = true
                }
            }
        } catch (e: RejectedExecutionException) {
            console.log("提交任务到线程池失败: ${e.message}")
            // 标记执行器已关闭
            isExecutorShutdown = true
            receiveCallback?.invoke(false,"读取数据失败: ${e.message}")
        }
    }
    
    // 连接丢失处理
    private fun onConnectionLost(message: String) {
        console.log("蓝牙连接已丢失: $message")
        
        // 关闭当前连接
        closeConnection()
        
        // 通知连接丢失
        connectionCallback?.invoke(false)
        connectionCallback = null
    }

    // 停止监听数据
    fun stopListeningForData() {
        console.log("停止监听蓝牙数据")
        executor.shutdownNow()
        isExecutorShutdown = true
    }

    // 广播接收器用于发现蓝牙设备
    private var deviceFoundListener: DeviceFoundCallback? = null
    private var includePairedDevices = false

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                BluetoothDevice.ACTION_FOUND -> {
                    // Discovery has found a device. Get the BluetoothDevice object and its info from the Intent.
                    val device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    val rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE).toInt()
                    
                    device?.let {
                        console.log("发现蓝牙设备: ${it.name ?: "未知设备"}, 地址: ${it.address}, RSSI: $rssi")
                        
                        // 根据includePairedDevices参数决定是否回调已配对设备
                        if (includePairedDevices || !pairedDevices.contains(it.address)) {
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
    private fun setOnDeviceFoundListener(includePaired: Boolean, listener: DeviceFoundCallback) {
        includePairedDevices = includePaired
        deviceFoundListener = listener
    }

    // 检查设备是否已配对
    fun isDevicePaired(deviceAddress: String): Boolean {
        if (context == null) {
            console.log("上下文为空，无法检查配对状态")
            return false
        }
        
        // 检查蓝牙是否已启用
        if (!getBluetoothEnabledState()) {
            console.log("蓝牙未启用，无法检查配对状态")
            return false
        }
        
        // 检查权限
        if (!hasRequiredPermissions()) {
            console.log("缺少蓝牙访问所需的权限")
            return false
        }
        
        return pairedDevices.contains(deviceAddress)
    }

    // 启动配对流程
    fun pairDevice(device: BluetoothDevice, onBonded: (Boolean) -> Unit): Boolean {
        if (context == null) {
            console.log("上下文为空，无法启动配对")
            return false
        }
        
        // 检查蓝牙是否已启用
        if (!getBluetoothEnabledState()) {
            console.log("蓝牙未启用，无法启动配对")
            return false
        }
        
        // 检查权限
        if (!hasRequiredPermissions()) {
            console.log("缺少蓝牙配对所需的权限")
            return false
        }
        
        if (isDevicePaired(device.address)) {
            console.log("设备已配对: ${device.name ?: "未知设备"}, 地址: ${device.address}")
            onBonded(true)
            return true
        }
        
        // 注册广播接收器监听配对状态变化
        registerBondStateReceiver(device, onBonded)
        try {
            // 尝试通过反射调用createBond方法启动配对流程
            console.log("尝试配对设备: ${device.name ?: "未知设备"}, 地址: ${device.address}")
            val createBondMethod = BluetoothDevice::class.java.getMethod("createBond")
            createBondMethod.invoke(device)
            return true
        } catch (e: Exception) {
            console.log("配对设备失败: ${e.message}")
            e.printStackTrace()
            unregisterBondStateReceiver()
            onBonded(false)
            return false
        }
    }

    // 注册广播接收器监听配对状态变化
    private fun registerBondStateReceiver(device: BluetoothDevice, onBonded: (Boolean) -> Unit) {
        bondStateChangedReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (context == null || intent == null) return
                when (intent.action) {
                    BluetoothDevice.ACTION_BOND_STATE_CHANGED -> {
                        val bondedDevice: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                        val bondState = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, BluetoothDevice.ERROR)
                        val previousBondState = intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE, BluetoothDevice.ERROR)

                        bondedDevice?.let {
                            if (it.address == device.address) {
                                when (bondState) {
                                    BluetoothDevice.BOND_BONDED -> {
                                        console.log("设备配对成功: ${it.name ?: "未知设备"}")
                                        updatePairedDevicesSet() // 更新已配对设备集合
                                        unregisterBondStateReceiver()
                                        onBonded(true)
                                    }
                                    BluetoothDevice.BOND_NONE -> {
                                        if (previousBondState != BluetoothDevice.BOND_NONE) {
                                            console.log("设备配对失败: ${it.name ?: "未知设备"}")
                                            updatePairedDevicesSet() // 更新已配对设备集合
                                            unregisterBondStateReceiver()
                                            onBonded(false)
                                        }
                                    }
                                    BluetoothDevice.BOND_BONDING -> {
                                        console.log("正在配对设备: ${it.name ?: "未知设备"}")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        val filter = IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED)
        this.context?.registerReceiver(bondStateChangedReceiver, filter)
    }

    // 注销广播接收器
    private fun unregisterBondStateReceiver() {
        bondStateChangedReceiver?.let {
            this.context?.unregisterReceiver(it)
            bondStateChangedReceiver = null
        }
    }
    
    // 检查是否有所需的权限
    private fun hasRequiredPermissions(): Boolean {
        if (context == null) return false
        
        val context = this.context ?: return false
        
        // 根据Android版本检查所需的权限
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        } else {
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        }
    }
    
    // 关闭当前蓝牙连接
    fun closeConnection() {
        console.log("关闭蓝牙连接")
        
        // 停止心跳检测
        stopKeepAliveTimer()
        receiveCallback?.invoke(false,"关闭连接")
        try {
            bluetoothSocket?.close()
            bluetoothSocket = null
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    
    // 启动心跳检测
    private fun startKeepAliveTimer() {
        stopKeepAliveTimer()
        
        keepAliveTimer = Timer()
        keepAliveTimer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                try {
                    // 发送心跳包
                    sendData("KEEP_ALIVE")
                } catch (e: Exception) {
                    console.log("心跳检测失败: ${e.message}")
                    // 心跳失败，认为连接已断开
                    onConnectionLost("心跳检测失败: ${e.message}")
					receiveCallback?.invoke(false,"心跳检测失败: ${e.message}")
                }
            }
        }, 5000, 5000) // 5秒后开始，每5秒发送一次
    }
    
    // 停止心跳检测
    private fun stopKeepAliveTimer() {
        keepAliveTimer?.cancel()
        keepAliveTimer = null
    }
    
    // 清理资源
    fun cleanup(): Boolean {
        console.log("清理蓝牙管理器资源")
        
        // 停止任何正在进行的扫描
        stopDiscovery()
        
        // 停止数据监听
        stopListeningForData()
        
        // 关闭蓝牙连接
        closeConnection()
        
        // 注销广播接收器
        try {
            if (isReceiverRegistered) {
                context?.unregisterReceiver(receiver)
                isReceiverRegistered = false
            }
            if (isStateReceiverRegistered) {
                context?.unregisterReceiver(bluetoothStateReceiver)
                isStateReceiverRegistered = false
            }
            unregisterBondStateReceiver()
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        
        // 关闭执行器
        if (!executor.isShutdown) {
            executor.shutdown()
            isExecutorShutdown = true
        }
        
        if (!scheduledExecutor.isShutdown) {
            scheduledExecutor.shutdown()
        }
        
        return true
    }
    
    fun closeBluetoothConnection(): Boolean {
        return cleanup()
    }
    
    // 取消配对
    fun unpairDevice(device: BluetoothDevice): Boolean {
        if (!isDevicePaired(device.address)) {
            console.log("设备未配对")
            return true
        }
        try {
            // 通过反射调用removeBond方法取消配对
            val removeBondMethod = BluetoothDevice::class.java.getMethod("removeBond")
            val result = removeBondMethod.invoke(device) as Boolean
            return result
        } catch (e: Exception) {
            e.printStackTrace()
            unregisterBondStateReceiver()
            return false
        }
    }
}