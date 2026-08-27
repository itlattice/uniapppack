package uts.sdk.modules.iboxsDocscan

import android.content.Context
import org.opencv.core.*
import org.opencv.imgproc.Imgproc
import java.nio.ByteBuffer
import kotlin.math.*

object OpenCV {

    private const val OPEN_CV_LOADER_CLASS = "org.opencv.android.OpenCVLoader"
    private const val OPEN_CV_IMGPROC_CLASS = "org.opencv.imgproc.Imgproc"
    private val OPEN_CV_NATIVE_LIBRARIES = arrayOf(
        "opencv_java5",
        "opencv_java4",
        "opencv_java",
        "opencv_world"
    )
    
    // ==================== 配置常量 ====================
    private const val MIN_CANDIDATE_SCORE = 0.35          // 提高最低分数要求
    private const val ROTATION_SWITCH_MARGIN = 0.12
    private const val ROTATION_SWITCH_CONFIRM_FRAMES = 3
    private const val CORNER_SMOOTH_ALPHA = 0.35
    private const val MAX_DETECT_SIDE = 720.0
    
    // 优化：扩大白色检测范围（支持偏蓝/偏黄的白色）
    private val WHITE_HSV_LOWER = Scalar(0.0, 0.0, 160.0)    // 降低饱和度下限，提高明度下限
    private val WHITE_HSV_UPPER = Scalar(180.0, 50.0, 255.0) // 降低饱和度上限，包含偏色白
    
    // 多组Canny阈值适配不同光照
    private val CANNY_CONFIGS = listOf(
        35.0 to 110.0,  // 标准
        50.0 to 150.0,  // 高对比度
        25.0 to 80.0    // 低对比度（暗光）
    )
    
    // ==================== 状态变量 ====================
    private var openCvReady = false
    private var lockedMappingKey: String? = null
    private var pendingMappingKey: String? = null
    private var pendingMappingCount = 0
    private var lastSmoothedCorners: Array<Point>? = null
    
    // ==================== 数据类 ====================
    private data class FrameGeometry(
        val p1: Point, val p2: Point, val p3: Point, val p4: Point,
        val width: Double, val height: Double
    )
    
    private data class OrientationCandidate(
        val rotation: Int,
        val useCover: Boolean,
        val points: Array<Point>,
        val score: Double
    ) {
        fun key(): String = "${rotation}_${if (useCover) "cover" else "contain"}"
    }
    
    // ==================== 公开接口 ====================
    
    fun getDocCorner(
        context: Context,
        byteBuffer: ByteBuffer,
        height: Number,
        width: Number,
        byteLength: Number
    ): Array<Number> {
        return try {
            ensureOpenCvInitialized()
            
            val frameWidth = width.toInt()
            val frameHeight = height.toInt()
            val (screenWidth, screenHeight) = getScreenSize(context)
            
            if (frameWidth <= 0 || frameHeight <= 0) {
                return emptyResult()
            }
            
            val rgba = buildMatFromBuffer(byteBuffer, frameHeight, frameWidth, byteLength.toInt())
            val (detectRgba, scale) = resizeIfNeeded(rgba)
            
            val result = detectDocumentCorners(detectRgba, screenWidth, screenHeight)
            
            if (detectRgba !== rgba) detectRgba.release()
            rgba.release()
            
            result
        } catch (e: Exception) {
            e.printStackTrace()
            emptyResult()
        }
    }
    
    // ==================== 初始化 ====================
    
    private fun ensureOpenCvInitialized() {
        if (openCvReady) {
            return
        }

        if (probeOpenCv() || tryInitWithLoader() || tryLoadNativeLibrary()) {
            openCvReady = true
            return
        }

        throw IllegalStateException("OpenCV initialization failed for org.opencv:opencv:5.0.0")
    }

    private fun tryInitWithLoader(): Boolean {
        return try {
            val loaderClass = Class.forName(OPEN_CV_LOADER_CLASS)
            for (methodName in arrayOf("initLocal", "initDebug")) {
                val method = runCatching { loaderClass.getMethod(methodName) }.getOrNull() ?: continue
                val result = method.invoke(null)
                if (result is Boolean && result && probeOpenCv()) {
                    return true
                }
            }
            false
        } catch (_: Throwable) {
            false
        }
    }

    private fun tryLoadNativeLibrary(): Boolean {
        for (libraryName in OPEN_CV_NATIVE_LIBRARIES) {
            try {
                System.loadLibrary(libraryName)
                if (probeOpenCv()) {
                    return true
                }
            } catch (_: Throwable) {
            }
        }
        return false
    }

    private fun probeOpenCv(): Boolean {
        return try {
            Core.getVersionString().isNotBlank()
        } catch (_: Throwable) {
            false
        }
    }

    private fun invokeImgprocMethod(methodName: String, vararg args: Any): Any? {
        return try {
            val imgprocClass = Class.forName(OPEN_CV_IMGPROC_CLASS)
            val method = imgprocClass.methods.firstOrNull {
                it.name == methodName &&
                it.parameterTypes.size == args.size &&
                areMethodArgumentsCompatible(it.parameterTypes, args)
            } ?: return null
            method.invoke(null, *args)
        } catch (_: Throwable) {
            null
        }
    }

    private fun areMethodArgumentsCompatible(parameterTypes: Array<Class<*>>, args: Array<out Any>): Boolean {
        for (i in parameterTypes.indices) {
            if (!isArgumentCompatible(parameterTypes[i], args[i])) {
                return false
            }
        }
        return true
    }

    private fun isArgumentCompatible(parameterType: Class<*>, arg: Any): Boolean {
        if (parameterType.isInstance(arg)) {
            return true
        }

        return when (parameterType) {
            java.lang.Boolean.TYPE -> arg is Boolean
            java.lang.Integer.TYPE -> arg is Int
            java.lang.Long.TYPE -> arg is Long
            java.lang.Float.TYPE -> arg is Float
            java.lang.Double.TYPE -> arg is Double || arg is Float || arg is Int || arg is Long
            java.lang.Short.TYPE -> arg is Short || arg is Byte
            java.lang.Byte.TYPE -> arg is Byte
            java.lang.Character.TYPE -> arg is Char
            else -> false
        }
    }

    private fun contourAreaCompat(contour: MatOfPoint): Double {
        val result = invokeImgprocMethod("contourArea", contour)
        return (result as? Number)?.toDouble() ?: 0.0
    }

    private fun arcLengthCompat(contour: MatOfPoint2f, closed: Boolean): Double {
        val result = invokeImgprocMethod("arcLength", contour, closed)
        return (result as? Number)?.toDouble() ?: 0.0
    }

    private fun approxPolyDPCompat(
        contour: MatOfPoint2f,
        approx: MatOfPoint2f,
        epsilon: Double,
        closed: Boolean
    ) {
        invokeImgprocMethod("approxPolyDP", contour, approx, epsilon, closed)
    }

    private fun isContourConvexCompat(contour: MatOfPoint): Boolean {
        return invokeImgprocMethod("isContourConvex", contour) as? Boolean ?: false
    }

    private fun minAreaRectCompat(contour: MatOfPoint2f): RotatedRect? {
        return invokeImgprocMethod("minAreaRect", contour) as? RotatedRect
    }

    private fun convexHullCompat(contour: MatOfPoint, hull: MatOfInt) {
        invokeImgprocMethod("convexHull", contour, hull)
    }
    
    private fun getScreenSize(context: Context): Pair<Int, Int> {
        val metrics = context.resources.displayMetrics
        val density = metrics.density.toDouble().coerceAtLeast(1.0)
        return (metrics.widthPixels / density).toInt() to 
               (metrics.heightPixels / density).toInt()
    }
    
    // ==================== 图像预处理 ====================
    
    private fun buildMatFromBuffer(
        buffer: ByteBuffer,
        height: Int,
        width: Int,
        length: Int
    ): Mat {
        val rgba = Mat(height, width, CvType.CV_8UC4)
        val dataSize = min(length, width * height * 4)
        val bytes = ByteArray(dataSize)
        buffer.rewind()
        buffer.get(bytes, 0, dataSize)
        rgba.put(0, 0, bytes)
        return rgba
    }
    
    private fun resizeIfNeeded(rgba: Mat): Pair<Mat, Double> {
        val maxSide = max(rgba.cols(), rgba.rows()).toDouble()
        val scale = if (maxSide > MAX_DETECT_SIDE) MAX_DETECT_SIDE / maxSide else 1.0
        
        return if (scale < 0.999) {
            val resized = Mat()
            Imgproc.resize(rgba, resized, 
                Size(rgba.cols() * scale, rgba.rows() * scale),
                0.0, 0.0, Imgproc.INTER_AREA)
            resized to scale
        } else {
            rgba to scale
        }
    }
    
    // ==================== 核心检测逻辑（重构） ====================
    
    private fun detectDocumentCorners(
        rgba: Mat,
        screenWidth: Int,
        screenHeight: Int
    ): Array<Number> {
        val frameWidth = rgba.cols()
        val frameHeight = rgba.rows()
        
        // ---- Step 1: 灰度图预处理 ----
        val gray = Mat()
        Imgproc.cvtColor(rgba, gray, Imgproc.COLOR_RGBA2GRAY)
        Imgproc.GaussianBlur(gray, gray, Size(5.0, 5.0), 0.0)
        
        // ---- Step 2: 多策略检测，取最优结果 ----
        val results = mutableListOf<DetectionResult>()
        
        // 策略1: HSV白色检测（针对白色文件）
        detectWhiteDocument(rgba, frameWidth, frameHeight, screenWidth, screenHeight)
            ?.let { results.add(it) }
        
        // 策略2: 多阈值Canny边缘检测
        for ((low, high) in CANNY_CONFIGS) {
            detectByCanny(gray, low, high, frameWidth, frameHeight, screenWidth, screenHeight)
                ?.let { results.add(it) }
        }
        
        // 策略3: 自适应阈值（处理光照不均）
        detectByAdaptiveThreshold(gray, frameWidth, frameHeight, screenWidth, screenHeight)
            ?.let { results.add(it) }
        
        // 策略4: OTSU二值化
        detectByOTSU(gray, frameWidth, frameHeight, screenWidth, screenHeight)
            ?.let { results.add(it) }
        
        gray.release()
        
        // ---- Step 3: 选取得分最高的结果 ----
        val best = results.maxByOrNull { it.score }
        
        if (best != null && best.score >= MIN_CANDIDATE_SCORE) {
            // 如果找到多个结果且分数接近，选择面积适中的（更可能是文档）
            val final = if (results.size > 1) {
                selectBestAmongSimilar(results, best)
            } else {
                best
            }
            return toNumberResult(final.corners)
        }
        
        // ---- Step 4: 保底策略 - 最大外轮廓 ----
        return detectLargestContour(rgba, frameWidth, frameHeight, screenWidth, screenHeight)
            ?: emptyResult()
    }
    
    // ==================== 策略1: HSV白色检测（优化版） ====================
    
    private fun detectWhiteDocument(
        rgba: Mat,
        frameWidth: Int,
        frameHeight: Int,
        screenWidth: Int,
        screenHeight: Int
    ): DetectionResult? {
        val rgb = Mat()
        val hsv = Mat()
        val mask = Mat()
        
        try {
            // UTS/OpenCV 绑定里没有 COLOR_RGBA2HSV，分两步转换以兼容编译。
            Imgproc.cvtColor(rgba, rgb, Imgproc.COLOR_RGBA2RGB)
            Imgproc.cvtColor(rgb, hsv, Imgproc.COLOR_RGB2HSV)
            Core.inRange(hsv, WHITE_HSV_LOWER, WHITE_HSV_UPPER, mask)
            
            // 增强：形态学闭运算连接断裂区域
            val kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, Size(9.0, 9.0))
            Imgproc.morphologyEx(mask, mask, Imgproc.MORPH_CLOSE, kernel)
            
            // 再次膨胀确保边缘完整
            Imgproc.dilate(mask, mask, kernel, Point(-1.0, -1.0), 2)
            
            // 从掩码提取四边形
            return extractQuadFromMask(mask, frameWidth, frameHeight, screenWidth, screenHeight, "white")
            
        } finally {
            rgb.release()
            hsv.release()
            mask.release()
        }
    }
    
    // ==================== 策略2: Canny边缘检测 ====================
    
    private fun detectByCanny(
        gray: Mat,
        low: Double,
        high: Double,
        frameWidth: Int,
        frameHeight: Int,
        screenWidth: Int,
        screenHeight: Int
    ): DetectionResult? {
        val edges = Mat()
        
        try {
            Imgproc.Canny(gray, edges, low, high)
            
            // 形态学闭合连接边缘
            val kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, Size(5.0, 5.0))
            Imgproc.morphologyEx(edges, edges, Imgproc.MORPH_CLOSE, kernel)
            
            return extractQuadFromMask(edges, frameWidth, frameHeight, screenWidth, screenHeight, "canny_${low}_${high}")
            
        } finally {
            edges.release()
        }
    }
    
    // ==================== 策略3: 自适应阈值 ====================
    
    private fun detectByAdaptiveThreshold(
        gray: Mat,
        frameWidth: Int,
        frameHeight: Int,
        screenWidth: Int,
        screenHeight: Int
    ): DetectionResult? {
        val adaptive = Mat()
        
        try {
            Imgproc.adaptiveThreshold(
                gray, adaptive,
                255.0,
                Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C,
                Imgproc.THRESH_BINARY,
                31, 7.0
            )
            
            val kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, Size(5.0, 5.0))
            Imgproc.morphologyEx(adaptive, adaptive, Imgproc.MORPH_CLOSE, kernel)
            
            return extractQuadFromMask(adaptive, frameWidth, frameHeight, screenWidth, screenHeight, "adaptive")
            
        } finally {
            adaptive.release()
        }
    }
    
    // ==================== 策略4: OTSU ====================
    
    private fun detectByOTSU(
        gray: Mat,
        frameWidth: Int,
        frameHeight: Int,
        screenWidth: Int,
        screenHeight: Int
    ): DetectionResult? {
        val binary = Mat()
        
        try {
            Imgproc.threshold(gray, binary, 0.0, 255.0, Imgproc.THRESH_BINARY + Imgproc.THRESH_OTSU)
            
            val kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, Size(7.0, 7.0))
            Imgproc.morphologyEx(binary, binary, Imgproc.MORPH_CLOSE, kernel)
            
            return extractQuadFromMask(binary, frameWidth, frameHeight, screenWidth, screenHeight, "otsu")
            
        } finally {
            binary.release()
        }
    }
    
    // ==================== 核心：从掩码提取四边形（重构版） ====================
    
    private fun extractQuadFromMask(
        mask: Mat,
        frameWidth: Int,
        frameHeight: Int,
        screenWidth: Int,
        screenHeight: Int,
        method: String
    ): DetectionResult? {
        val contours = ArrayList<MatOfPoint>()
        val hierarchy = Mat()
        
        try {
            Imgproc.findContours(mask, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE)
            
            if (contours.isEmpty()) return null
            
            val frameArea = frameWidth.toDouble() * frameHeight.toDouble()
            var bestQuad: Array<Point>? = null
            var bestScore = 0.0
            var bestArea = 0.0
            
            for (contour in contours) {
                val area = contourAreaCompat(contour)
                
                // 过滤：面积太小或太大
                if (area < frameArea * 0.03 || area > frameArea * 0.92) continue
                
                val contour2f = MatOfPoint2f(*contour.toArray())
                val perimeter = arcLengthCompat(contour2f, true)
                val approx = MatOfPoint2f()
                
                // 多边形逼近（动态精度）
                val epsilon = 0.015 * perimeter
                approxPolyDPCompat(contour2f, approx, epsilon, true)
                
                var points: Array<Point>? = null
                
                // 情况1: 正好4个顶点
                if (approx.total() == 4L) {
                    val poly = MatOfPoint(*approx.toArray())
                    if (isContourConvexCompat(poly)) {
                        points = approx.toArray()
                    }
                    poly.release()
                }
                
                // 情况2: 多于4个顶点，取最小外接矩形
                if (points == null && approx.total() >= 4L) {
                    val rect = minAreaRectCompat(contour2f)
                    if (rect != null) {
                    val rectPoints = arrayOf(Point(), Point(), Point(), Point())
                    rect.points(rectPoints)
                    points = rectPoints
                    }
                }
                
                // 情况3: 直接取凸包（兜底）
                if (points == null) {
                    val hullIndices = MatOfInt()
                    convexHullCompat(contour, hullIndices)
                    if (hullIndices.total() >= 4L) {
                        val contourArray = contour.toArray()
                        val hullPoints = mutableListOf<Point>()
                        for (i in 0 until hullIndices.rows()) {
                            val index = hullIndices.get(i, 0)[0].toInt()
                            if (index in contourArray.indices) {
                                hullPoints.add(contourArray[index])
                            }
                        }
                        if (hullPoints.size >= 4) {
                            points = hullPoints.take(4).toTypedArray()
                        }
                    }
                    hullIndices.release()
                }
                
                contour2f.release()
                approx.release()
                
                if (points != null && points.size == 4) {
                    // 质量评估（优化版）
                    val score = evaluateQuadQuality(points, area, frameWidth, frameHeight)
                    
                    if (score > bestScore) {
                        bestScore = score
                        bestArea = area
                        bestQuad = points
                    }
                }
            }
            
            // 筛选条件：分数达标且面积适中
            if (bestQuad != null && bestScore >= MIN_CANDIDATE_SCORE) {
                // 额外过滤：检查四边形是否过于畸形
                if (!isValidQuadrilateral(bestQuad!!)) {
                    return null
                }
                
                val sorted = sortCorners(bestQuad!!, frameWidth, frameHeight, screenWidth, screenHeight)
                return DetectionResult(sorted, bestScore, method)
            }
            
            return null
            
        } finally {
            hierarchy.release()
            for (c in contours) {
                c.release()
            }
        }
    }
    
    // ==================== 四边形质量评估（核心优化） ====================
    
    private fun evaluateQuadQuality(
        points: Array<Point>,
        area: Double,
        frameWidth: Int,
        frameHeight: Int
    ): Double {
        if (points.size != 4) return 0.0
        
        val ordered = orderPoints(points)
        val (tl, tr, br, bl) = ordered
        
        // 1. 边长计算
        val widthTop = distance(tl, tr)
        val widthBottom = distance(bl, br)
        val heightLeft = distance(tl, bl)
        val heightRight = distance(tr, br)
        val avgWidth = (widthTop + widthBottom) * 0.5
        val avgHeight = (heightLeft + heightRight) * 0.5
        
        // 2. 最小尺寸过滤（防止误检小物体）
        val minSide = min(frameWidth, frameHeight).toDouble()
        val minEdge = max(32.0, minSide * 0.08)
        if (avgWidth < minEdge || avgHeight < minEdge) {
            return 0.0
        }
        
        // 3. 面积占比评分（适中最好，太大或太小都不好）
        val frameArea = frameWidth.toDouble() * frameHeight.toDouble()
        val areaRatio = area / frameArea
        val areaScore = when {
            areaRatio in 0.12..0.75 -> 1.0      // 理想范围
            areaRatio in 0.08..0.85 -> 0.7
            areaRatio in 0.05..0.92 -> 0.4
            else -> 0.1
        }
        
        // 4. 长宽比评分（文档通常在1:1到1:2之间）
        val aspect = max(avgWidth, avgHeight) / min(avgWidth, avgHeight)
        val aspectScore = when {
            aspect in 0.7..1.6 -> 1.0           // 接近正方形或A4
            aspect in 0.5..2.2 -> 0.7
            aspect in 0.4..2.8 -> 0.4
            else -> 0.1
        }
        
        // 5. 直角评分（文档应该是矩形）
        val angleScore = calculateRightAngleScore(ordered)
        
        // 6. 对边平行度评分（矩形对边应平行）
        val parallelScore = calculateParallelScore(ordered)
        
        // 7. 对称性评分（上下、左右宽度应接近）
        val widthRatio = min(widthTop, widthBottom) / max(widthTop, widthBottom)
        val heightRatio = min(heightLeft, heightRight) / max(heightLeft, heightRight)
        val symmetryScore = (widthRatio + heightRatio) * 0.5
        
        // 8. 中心偏移评分（文档应在画面中央附近）
        val cx = (tl.x + tr.x + br.x + bl.x) * 0.25
        val cy = (tl.y + tr.y + br.y + bl.y) * 0.25
        val normDx = abs(cx - frameWidth * 0.5) / frameWidth
        val normDy = abs(cy - frameHeight * 0.5) / frameHeight
        val centerScore = (1.0 - (normDx * 0.6 + normDy * 0.4)).coerceIn(0.0, 1.0)
        
        // 权重分配（优化：降低面积权重，提升形状权重）
        return areaScore * 0.20 +
               aspectScore * 0.15 +
               angleScore * 0.30 +
               parallelScore * 0.15 +
               symmetryScore * 0.10 +
               centerScore * 0.10
    }
    
    // ==================== 四边形质量检查 ====================
    
    private fun isValidQuadrilateral(points: Array<Point>): Boolean {
        if (points.size != 4) return false
        
        val ordered = orderPoints(points)
        
        // 检查是否有顶点重叠或过于接近
        for (i in 0..3) {
            for (j in i + 1..3) {
                if (distance(ordered[i], ordered[j]) < 5.0) {
                    return false
                }
            }
        }
        
        // 检查边长比例是否极端（防止畸形）
        val edges = listOf(
            distance(ordered[0], ordered[1]),
            distance(ordered[1], ordered[2]),
            distance(ordered[2], ordered[3]),
            distance(ordered[3], ordered[0])
        )
        val maxEdge = edges.maxOrNull() ?: return false
        val minEdge = edges.minOrNull() ?: return false
        
        // 最长边不能超过最短边的8倍
        if (maxEdge > minEdge * 8) return false
        
        // 检查角度是否都在合理范围（30° - 150°）
        for (i in 0..3) {
            val angle = calculateAngle(
                ordered[i],
                ordered[(i + 1) % 4],
                ordered[(i + 2) % 4]
            )
            if (angle < 25.0 || angle > 155.0) {
                return false
            }
        }
        
        return true
    }
    
    // ==================== 辅助计算函数 ====================
    
    private fun orderPoints(points: Array<Point>): Array<Point> {
        if (points.size != 4) return copyPoints(points)

        val cx = points.sumOf { it.x } / 4.0
        val cy = points.sumOf { it.y } / 4.0

        // 按相对质心的极角排序，得到稳定的环形顺序（仅依赖图像几何，不依赖设备方向）。
        val ring = points
            .map { Point(it.x, it.y) }
            .sortedBy { atan2(it.y - cy, it.x - cx) }
            .toMutableList()

        // 以最靠近图像左上的角点作为起点。
        var tlIndex = 0
        var minSum = Double.MAX_VALUE
        for (i in ring.indices) {
            val s = ring[i].x + ring[i].y
            if (s < minSum) {
                minSum = s
                tlIndex = i
            }
        }

        fun at(offset: Int): Point = ring[(tlIndex + offset) % 4]
        val p0 = at(0) // TL
        val p1 = at(1)
        val p2 = at(2)
        val p3 = at(3)

        // 邻接点中 x 更大的视为 TR，另一侧为 BL，防止左右翻转。
        return if (p1.x >= p3.x) {
            arrayOf(p0, p1, p2, p3)
        } else {
            arrayOf(p0, p3, p2, p1)
        }
    }
    
    private fun distance(a: Point, b: Point): Double {
        return sqrt((a.x - b.x).pow(2) + (a.y - b.y).pow(2))
    }
    
    private fun calculateRightAngleScore(points: Array<Point>): Double {
        var totalScore = 0.0
        for (i in 0..3) {
            val a = points[i]
            val b = points[(i + 1) % 4]
            val c = points[(i + 2) % 4]
            totalScore += angleScore(a, b, c)
        }
        return (totalScore / 4.0).coerceIn(0.0, 1.0)
    }
    
    private fun angleScore(a: Point, b: Point, c: Point): Double {
        val abx = a.x - b.x; val aby = a.y - b.y
        val cbx = c.x - b.x; val cby = c.y - b.y
        val dot = abx * cbx + aby * cby
        val mag1 = sqrt(abx * abx + aby * aby)
        val mag2 = sqrt(cbx * cbx + cby * cby)
        if (mag1 < 1e-6 || mag2 < 1e-6) return 0.0
        val cosValue = (dot / (mag1 * mag2)).coerceIn(-1.0, 1.0)
        return (1.0 - abs(cosValue)).coerceIn(0.0, 1.0)
    }
    
    private fun calculateParallelScore(points: Array<Point>): Double {
        // 检测对边是否平行
        val p1 = points[0]; val p2 = points[1]
        val p3 = points[2]; val p4 = points[3]
        
        // 上边向量 (p1->p2) 和 下边向量 (p4->p3)
        val v1 = Point(p2.x - p1.x, p2.y - p1.y)
        val v2 = Point(p3.x - p4.x, p3.y - p4.y)
        
        // 左边向量 (p1->p4) 和 右边向量 (p2->p3)
        val v3 = Point(p4.x - p1.x, p4.y - p1.y)
        val v4 = Point(p3.x - p2.x, p3.y - p2.y)
        
        val score1 = vectorParallelScore(v1, v2)
        val score2 = vectorParallelScore(v3, v4)
        
        return (score1 + score2) * 0.5
    }
    
    private fun vectorParallelScore(v1: Point, v2: Point): Double {
        val mag1 = sqrt(v1.x * v1.x + v1.y * v1.y)
        val mag2 = sqrt(v2.x * v2.x + v2.y * v2.y)
        if (mag1 < 1e-6 || mag2 < 1e-6) return 0.0
        
        val dot = v1.x * v2.x + v1.y * v2.y
        val cosAngle = (dot / (mag1 * mag2)).coerceIn(-1.0, 1.0)
        // 平行时 cosAngle 接近 ±1
        return abs(cosAngle).coerceIn(0.0, 1.0)
    }
    
    private fun calculateAngle(a: Point, b: Point, c: Point): Double {
        val abx = a.x - b.x; val aby = a.y - b.y
        val cbx = c.x - b.x; val cby = c.y - b.y
        val dot = abx * cbx + aby * cby
        val mag1 = sqrt(abx * abx + aby * aby)
        val mag2 = sqrt(cbx * cbx + cby * cby)
        if (mag1 < 1e-6 || mag2 < 1e-6) return 0.0
        val cosAngle = (dot / (mag1 * mag2)).coerceIn(-1.0, 1.0)
        return acos(cosAngle) * 180.0 / PI
    }
    
    // ==================== 保底策略：最大轮廓 ====================
    
    private fun detectLargestContour(
        rgba: Mat,
        frameWidth: Int,
        frameHeight: Int,
        screenWidth: Int,
        screenHeight: Int
    ): Array<Number>? {
        val gray = Mat()
        val edges = Mat()
        
        try {
            Imgproc.cvtColor(rgba, gray, Imgproc.COLOR_RGBA2GRAY)
            Imgproc.Canny(gray, edges, 30.0, 120.0)
            
            val contours = ArrayList<MatOfPoint>()
            val hierarchy = Mat()
            Imgproc.findContours(edges, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE)
            
            var largest: MatOfPoint? = null
            var maxArea = 0.0
            val frameArea = frameWidth.toDouble() * frameHeight.toDouble()
            
            for (c in contours) {
                val area = contourAreaCompat(c)
                if (area > maxArea && area > frameArea * 0.05) {
                    maxArea = area
                    largest = c
                }
            }
            
            if (largest == null) return null
            
            val contour2f = MatOfPoint2f(*largest.toArray())
            val rect = minAreaRectCompat(contour2f) ?: return null
            val points = arrayOf(Point(), Point(), Point(), Point())
            rect.points(points)
            
            contour2f.release()
            hierarchy.release()
            for (c in contours) c.release()
            
            return toNumberResult(sortCorners(points, frameWidth, frameHeight, screenWidth, screenHeight))
            
        } finally {
            gray.release()
            edges.release()
        }
    }
    
    // ==================== 坐标映射与平滑 ====================
    
    private fun sortCorners(
        points: Array<Point>,
        frameWidth: Int,
        frameHeight: Int,
        screenWidth: Int,
        screenHeight: Int
    ): Array<Point> {
        if (points.size != 4) return emptyPointResult()
        
        val ordered = orderPoints(points)
        return mapCornersWithBestOrientation(ordered, frameWidth, frameHeight, screenWidth, screenHeight)
    }
    
    private fun mapCornersWithBestOrientation(
        ordered: Array<Point>,
        frameWidth: Int,
        frameHeight: Int,
        screenWidth: Int,
        screenHeight: Int
    ): Array<Point> {
        // 仅基于图像本身输出角点，不再依赖设备方向或帧/屏宽高比选择旋转。
        val rotations = arrayOf(0)
        val fitModes = arrayOf(true, false)
        val candidates = mutableListOf<OrientationCandidate>()
        val sourceAspectRatio = getQuadAspectRatio(ordered)
        
        for (rotation in rotations) {
            val geometry = rotateFrameGeometry(ordered, frameWidth.toDouble(), frameHeight.toDouble(), rotation)
            for (useCover in fitModes) {
                val mapped = arrayOf(
                    mapPointToScreen(geometry.p1, geometry.width, geometry.height, screenWidth, screenHeight, useCover),
                    mapPointToScreen(geometry.p2, geometry.width, geometry.height, screenWidth, screenHeight, useCover),
                    mapPointToScreen(geometry.p3, geometry.width, geometry.height, screenWidth, screenHeight, useCover),
                    mapPointToScreen(geometry.p4, geometry.width, geometry.height, screenWidth, screenHeight, useCover)
                )
                val score = evaluateMappingScore(
                    mapped,
                    screenWidth.toDouble(),
                    screenHeight.toDouble(),
                    rotation,
                    useCover,
                    sourceAspectRatio
                )
                candidates.add(OrientationCandidate(rotation, useCover, mapped, score))
            }
        }
        
        val best = candidates.maxByOrNull { it.score } ?: return emptyPointResult()
        val selected = selectOrientationWithLocking(best, candidates)
        
        // 平滑处理
        return smoothCorners(selected.points)
    }
    
    private fun selectOrientationWithLocking(
        best: OrientationCandidate,
        candidates: List<OrientationCandidate>
    ): OrientationCandidate {
        val locked = lockedMappingKey
        if (locked == null) {
            lockedMappingKey = best.key()
            pendingMappingKey = null
            pendingMappingCount = 0
            return best
        }
        
        val lockedCandidate = candidates.find { it.key() == locked }
        if (lockedCandidate == null) {
            lockedMappingKey = best.key()
            return best
        }
        
        // 如果最佳候选与锁定的差异超过阈值，启动切换确认
        if (best.key() != locked && best.score > lockedCandidate.score + ROTATION_SWITCH_MARGIN) {
            if (pendingMappingKey == best.key()) {
                pendingMappingCount++
            } else {
                pendingMappingKey = best.key()
                pendingMappingCount = 1
            }
            
            if (pendingMappingCount >= ROTATION_SWITCH_CONFIRM_FRAMES) {
                lockedMappingKey = best.key()
                pendingMappingKey = null
                pendingMappingCount = 0
                return best
            }
        } else {
            pendingMappingKey = null
            pendingMappingCount = 0
        }
        
        return lockedCandidate
    }
    
    private fun rotateFrameGeometry(
        points: Array<Point>,
        frameWidth: Double,
        frameHeight: Double,
        rotation: Int
    ): FrameGeometry {
        val (rotatedPoints, rotatedWidth, rotatedHeight) = when (rotation) {
            90 -> Triple(
                arrayOf(
                    Point(frameHeight - 1 - points[0].y, points[0].x),
                    Point(frameHeight - 1 - points[1].y, points[1].x),
                    Point(frameHeight - 1 - points[2].y, points[2].x),
                    Point(frameHeight - 1 - points[3].y, points[3].x)
                ),
                frameHeight,
                frameWidth
            )
            180 -> Triple(
                arrayOf(
                    Point(frameWidth - 1 - points[0].x, frameHeight - 1 - points[0].y),
                    Point(frameWidth - 1 - points[1].x, frameHeight - 1 - points[1].y),
                    Point(frameWidth - 1 - points[2].x, frameHeight - 1 - points[2].y),
                    Point(frameWidth - 1 - points[3].x, frameHeight - 1 - points[3].y)
                ),
                frameWidth,
                frameHeight
            )
            270 -> Triple(
                arrayOf(
                    Point(points[0].y, frameWidth - 1 - points[0].x),
                    Point(points[1].y, frameWidth - 1 - points[1].x),
                    Point(points[2].y, frameWidth - 1 - points[2].x),
                    Point(points[3].y, frameWidth - 1 - points[3].x)
                ),
                frameHeight,
                frameWidth
            )
            else -> Triple(copyPoints(points), frameWidth, frameHeight)
        }

        // 旋转后重新排序，确保输出角点始终保持 TL-TR-BR-BL，避免左右翻转。
        val normalized = orderPoints(rotatedPoints)
        return FrameGeometry(
            normalized[0], normalized[1], normalized[2], normalized[3],
            rotatedWidth, rotatedHeight
        )
    }
    
    private fun mapPointToScreen(
        point: Point,
        frameWidth: Double,
        frameHeight: Double,
        screenWidth: Int,
        screenHeight: Int,
        useCover: Boolean
    ): Point {
        val safeFW = max(frameWidth, 1.0)
        val safeFH = max(frameHeight, 1.0)
        val safeSW = max(screenWidth.toDouble(), 1.0)
        val safeSH = max(screenHeight.toDouble(), 1.0)
        
        val scale = if (useCover) {
            max(safeSW / safeFW, safeSH / safeFH)
        } else {
            min(safeSW / safeFW, safeSH / safeFH)
        }
        
        val renderedWidth = safeFW * scale
        val renderedHeight = safeFH * scale
        val offsetX = (safeSW - renderedWidth) * 0.5
        val offsetY = (safeSH - renderedHeight) * 0.5
        
        return Point(point.x * scale + offsetX, point.y * scale + offsetY)
    }
    
    private fun evaluateMappingScore(
        points: Array<Point>,
        screenWidth: Double,
        screenHeight: Double,
        rotation: Int,
        useCover: Boolean,
        sourceAspectRatio: Double
    ): Double {
        val cx = points.sumOf { it.x } / 4.0
        val cy = points.sumOf { it.y } / 4.0
        
        // 中心偏移
        val centerDist = abs(cx - screenWidth * 0.5) / screenWidth +
                        abs(cy - screenHeight * 0.5) / screenHeight
        val centerScore = (1.0 - centerDist.coerceIn(0.0, 1.0))
        
        // 边界命中率
        var inBounds = 0
        for (p in points) {
            if (p.x in 0.0..screenWidth && p.y in 0.0..screenHeight) {
                inBounds++
            }
        }
        val boundsScore = inBounds / 4.0
        
        // 面积占比
        val area = abs(
            points[0].x * points[1].y + points[1].x * points[2].y +
            points[2].x * points[3].y + points[3].x * points[0].y -
            points[1].x * points[0].y - points[2].x * points[1].y -
            points[3].x * points[2].y - points[0].x * points[3].y
        ) * 0.5
        val areaRatio = area / (screenWidth * screenHeight)
        val areaScore = when {
            areaRatio in 0.10..0.80 -> 1.0
            areaRatio in 0.06..0.90 -> 0.6
            else -> 0.2
        }

        // 朝向一致性：尽量保持与原始文档宽高比方向一致，避免横向文档被映射为竖向框。
        val mappedAspectRatio = getQuadAspectRatio(points)
        val sourceSafe = sourceAspectRatio.coerceAtLeast(1e-6)
        val mappedSafe = mappedAspectRatio.coerceAtLeast(1e-6)
        val aspectDelta = abs(ln(mappedSafe / sourceSafe))
        val aspectConsistencyScore = (1.0 - (aspectDelta / ln(2.0))).coerceIn(0.0, 1.0)
        
        return boundsScore * 0.35 +
               centerScore * 0.20 +
               areaScore * 0.20 +
               aspectConsistencyScore * 0.25
    }

    private fun getQuadAspectRatio(points: Array<Point>): Double {
        if (points.size != 4) return 1.0
        val ordered = orderPoints(points)
        val widthTop = distance(ordered[0], ordered[1])
        val widthBottom = distance(ordered[3], ordered[2])
        val heightLeft = distance(ordered[0], ordered[3])
        val heightRight = distance(ordered[1], ordered[2])
        val avgWidth = (widthTop + widthBottom) * 0.5
        val avgHeight = (heightLeft + heightRight) * 0.5
        return avgWidth / avgHeight.coerceAtLeast(1e-6)
    }
    
    // ==================== 平滑处理 ====================
    
    private fun smoothCorners(current: Array<Point>): Array<Point> {
        val prev = lastSmoothedCorners
        if (prev == null || prev.size != 4) {
            lastSmoothedCorners = copyPoints(current)
            return current
        }

        val alignedCurrent = alignCornersToPrevious(current, prev)
        
        val alpha = CORNER_SMOOTH_ALPHA
        val result = Array(4) { i ->
            Point(
                prev[i].x * (1 - alpha) + alignedCurrent[i].x * alpha,
                prev[i].y * (1 - alpha) + alignedCurrent[i].y * alpha
            )
        }
        
        lastSmoothedCorners = copyPoints(result)
        return result
    }

    private fun alignCornersToPrevious(current: Array<Point>, prev: Array<Point>): Array<Point> {
        if (current.size != 4 || prev.size != 4) return current

        var best = copyPoints(current)
        var bestCost = Double.MAX_VALUE

        // 4 种轮转 * 2 种环方向（正向 / 反向）
        for (reversed in arrayOf(false, true)) {
            for (shift in 0 until 4) {
                val candidate = Array(4) { i ->
                    val idx = if (!reversed) {
                        (i + shift) % 4
                    } else {
                        (shift - i + 4) % 4
                    }
                    Point(current[idx].x, current[idx].y)
                }

                var cost = 0.0
                for (i in 0 until 4) {
                    cost += distance(candidate[i], prev[i])
                }

                if (cost < bestCost) {
                    bestCost = cost
                    best = candidate
                }
            }
        }

        return best
    }
    
    private fun copyPoints(points: Array<Point>): Array<Point> {
        return points.map { Point(it.x, it.y) }.toTypedArray()
    }
    
    private fun selectBestAmongSimilar(
        results: List<DetectionResult>,
        best: DetectionResult
    ): DetectionResult {
        // 如果存在其他结果分数在最佳结果的90%以内，选择面积居中的
        val threshold = best.score * 0.9
        val similar = results.filter { it.score >= threshold }
        
        if (similar.size <= 1) return best
        
        // 计算所有结果的平均面积，选择最接近的
        val avgArea = similar.map { calculatePolygonArea(it.corners) }.average()
        return similar.minByOrNull { abs(calculatePolygonArea(it.corners) - avgArea) } ?: best
    }
    
    private fun calculatePolygonArea(points: Array<Point>): Double {
        if (points.size < 3) return 0.0
        var area = 0.0
        for (i in points.indices) {
            val j = (i + 1) % points.size
            area += points[i].x * points[j].y
            area -= points[j].x * points[i].y
        }
        return abs(area) * 0.5
    }
    
    // ==================== 工具函数 ====================
    
    private fun emptyPointResult(): Array<Point> {
        return arrayOf(Point(), Point(), Point(), Point())
    }

    private fun toNumberResult(points: Array<Point>): Array<Number> {
        if (points.size != 4) return emptyResult()
        return arrayOf(
            points[0].x, points[0].y,
            points[1].x, points[1].y,
            points[2].x, points[2].y,
            points[3].x, points[3].y
        )
    }
    
    private fun emptyResult(): Array<Number> {
        return arrayOf(0, 0, 0, 0, 0, 0, 0, 0)
    }
    
    // ==================== 内部数据类 ====================
    
    private data class DetectionResult(
        val corners: Array<Point>,
        val score: Double,
        val method: String
    )
}