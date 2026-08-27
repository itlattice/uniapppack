@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNIHelloUniAppX
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
open class GenPagesCSSTransitionTransition : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onLoad(fun(_: OnLoadOptions) {
            stat_instance.onLoad(this)
        }
        , __ins)
        onPageShow(fun() {
            stat_instance.onShow(this)
        }
        , __ins)
        onPageHide(fun() {
            stat_instance.onHide(this)
        }
        , __ins)
        onUnload(fun() {
            stat_instance.onUnload(this)
        }
        , __ins)
    }
    open var changeWidthOrHeight: () -> Unit
        get() {
            return unref(this.`$exposed`["changeWidthOrHeight"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeWidthOrHeight", value)
        }
    open var changeWidthProgress: () -> Unit
        get() {
            return unref(this.`$exposed`["changeWidthProgress"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeWidthProgress", value)
        }
    open var changeMargin: () -> Unit
        get() {
            return unref(this.`$exposed`["changeMargin"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeMargin", value)
        }
    open var changePadding: () -> Unit
        get() {
            return unref(this.`$exposed`["changePadding"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changePadding", value)
        }
    open var changeBackground: () -> Unit
        get() {
            return unref(this.`$exposed`["changeBackground"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeBackground", value)
        }
    open var changeBackground2: () -> Unit
        get() {
            return unref(this.`$exposed`["changeBackground2"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeBackground2", value)
        }
    open var changeStyleOpacity: () -> Unit
        get() {
            return unref(this.`$exposed`["changeStyleOpacity"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeStyleOpacity", value)
        }
    open var propertyChangeBackground: () -> Unit
        get() {
            return unref(this.`$exposed`["propertyChangeBackground"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "propertyChangeBackground", value)
        }
    open var changeTransform: () -> Unit
        get() {
            return unref(this.`$exposed`["changeTransform"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeTransform", value)
        }
    open var changeTransformTranslate: () -> Unit
        get() {
            return unref(this.`$exposed`["changeTransformTranslate"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeTransformTranslate", value)
        }
    open var changeTransformWithWidth: () -> Unit
        get() {
            return unref(this.`$exposed`["changeTransformWithWidth"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeTransformWithWidth", value)
        }
    open var changeTransformWithOrigin: () -> Unit
        get() {
            return unref(this.`$exposed`["changeTransformWithOrigin"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeTransformWithOrigin", value)
        }
    open var changeBorder: () -> Unit
        get() {
            return unref(this.`$exposed`["changeBorder"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeBorder", value)
        }
    open var changestylePosition: () -> Unit
        get() {
            return unref(this.`$exposed`["changestylePosition"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changestylePosition", value)
        }
    open var changeTransitionAll: () -> Unit
        get() {
            return unref(this.`$exposed`["changeTransitionAll"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeTransitionAll", value)
        }
    open var changeWidthInEndFun: () -> Unit
        get() {
            return unref(this.`$exposed`["changeWidthInEndFun"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeWidthInEndFun", value)
        }
    open var getChangeWidthInEndCount: () -> Number
        get() {
            return unref(this.`$exposed`["getChangeWidthInEndCount"]) as () -> Number
        }
        set(value) {
            setRefValue(this.`$exposed`, "getChangeWidthInEndCount", value)
        }
    open var changeBorderAndBackgroundColor: () -> Unit
        get() {
            return unref(this.`$exposed`["changeBorderAndBackgroundColor"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "changeBorderAndBackgroundColor", value)
        }
    open var data: TransitionData
        get() {
            return unref(this.`$exposed`["data"]) as TransitionData
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSTransitionTransition, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTransitionTransition
            val _cache = __ins.renderCache
            var isTranstionWidthOrHeight = false
            var isTranstionWidthAuto = false
            var widthOrHeightAuto: UniElement? = null
            var widthOrHeight: UniElement? = null
            var widthProgress: UniElement? = null
            var isTranstionWidthOrHeightStyle = false
            var widthOrHeightStyle: UniElement? = null
            var progressWidth: Number = 200
            var isScrollViewWidth1 = false
            var isScrollViewWidth2 = false
            val scrollView1 = ref(null as UniElement?)
            val scrollView2 = ref(null as UniElement?)
            var isNativeViewWidth1 = false
            var isNativeViewWidth2 = false
            val nativeView1 = ref(null as UniElement?)
            val nativeView2 = ref(null as UniElement?)
            var isTranstionChangeMargin = false
            var styleMargin: UniElement? = null
            var isTransitionStylePadding = false
            var stylePadding: UniElement? = null
            var isTransitionstyleBackground = false
            var isTransitionstyleBackground2 = false
            var isTransitionstyleOpacity = false
            var styleBackground: UniElement? = null
            var styleBackground2: UniElement? = null
            var styleOpacity: UniElement? = null
            var isTransitionStyleTransform = false
            var styleTransform: UniElement? = null
            var isTransitionStyleTransformWithWidth = false
            var styleTransformWithWidth: UniElement? = null
            var isTransitionstyleBorder = false
            var styleBorder: UniElement? = null
            var isTransitionstylePosition = false
            var stylePosition: UniElement? = null
            var isSetTransition = false
            var isTransitionpropertystyleBackground = false
            var propertyStyleBackground: UniElement? = null
            var isTransitionStyleTransformWithOrigin = false
            var styleTransformWithOrigin: UniElement? = null
            var styleTransformTranslate: UniElement? = null
            var isTransformTranslate = false
            var styleTransformTranslateScale: UniElement? = null
            var startX: Number = 0
            var moveX: Number = 0
            var oldX: Number = 0
            val changestyleTransitionDuration = ref("background-color:brown;")
            var styleTransitionAll: UniElement? = null
            var isTransitionAll = false
            val lineLeft = ref(0)
            val lineWidth = ref(200)
            var changeWidthInEnd: UniElement? = null
            var changeWidthInEndCount: Number = 0
            var isTextTransform = false
            var textTransform: UniElement? = null
            var isTextOpacity = false
            var textOpacity: UniElement? = null
            var isTextBackground = false
            var textBackground: UniElement? = null
            var isImageTransform = false
            var imageTransform: UniElement? = null
            var isImageOpacity = false
            var imageOpacity: UniElement? = null
            var isImageScale = false
            var imageScale: UniElement? = null
            var isChangeBorderAndBackgroundColor = false
            var elChangeBorderAndBackgroundColor: UniElement? = null
            val getChangeWidthInEndCount = fun(): Number {
                return changeWidthInEndCount
            }
            onReady(fun(){
                widthOrHeight = uni_getElementById("widthOrHeight")
                widthProgress = uni_getElementById("widthProgress")
                widthOrHeightStyle = uni_getElementById("widthOrHeightStyle")
                styleMargin = uni_getElementById("styleMargin")
                stylePadding = uni_getElementById("stylePadding")
                styleBackground = uni_getElementById("styleBackground")
                styleBackground2 = uni_getElementById("styleBackground2")
                styleOpacity = uni_getElementById("styleOpacity")
                styleTransform = uni_getElementById("styleTransform")
                styleBorder = uni_getElementById("styleBorder")
                stylePosition = uni_getElementById("stylePosition")
                propertyStyleBackground = uni_getElementById("propertyStyleBackground")
                styleTransformWithOrigin = uni_getElementById("styleTransformWithOrigin")
                styleTransformWithWidth = uni_getElementById("styleTransformWithWidth")
                styleTransformTranslate = uni_getElementById("transformTranslate")
                styleTransformTranslateScale = uni_getElementById("styleTransformTranslateScale")
                styleTransitionAll = uni_getElementById("styleTransitionAll")
                widthOrHeightAuto = uni_getElementById("widthOrHeightAuto")
                changeWidthInEnd = uni_getElementById("changeWidthInEnd")
                textTransform = uni_getElementById("textTransform")
                textOpacity = uni_getElementById("textOpacity")
                textBackground = uni_getElementById("textBackground")
                imageTransform = uni_getElementById("imageTransform")
                imageOpacity = uni_getElementById("imageOpacity")
                imageScale = uni_getElementById("imageScale")
                elChangeBorderAndBackgroundColor = uni_getElementById("borderAndBackgroundColor")
            }
            )
            val changeWidthOrHeight = fun(){
                widthOrHeight?.style?.setProperty("width", if (isTranstionWidthOrHeight) {
                    "200px"
                } else {
                    "300px"
                }
                )
                isTranstionWidthOrHeight = !isTranstionWidthOrHeight
            }
            val changeWidthOrHeightAuto = fun(){
                widthOrHeightAuto?.style?.setProperty("width", if (isTranstionWidthAuto) {
                    "200px"
                } else {
                    "auto"
                }
                )
                isTranstionWidthAuto = !isTranstionWidthAuto
            }
            val changeWidthProgress = fun(){
                progressWidth += 20
                widthProgress?.style?.setProperty("width", progressWidth + "px")
            }
            val changeWidthOrHeightStyle = fun(){
                widthOrHeightStyle?.style?.setProperty("width", if (isTranstionWidthOrHeightStyle) {
                    "200px"
                } else {
                    "300px"
                }
                )
                isTranstionWidthOrHeightStyle = !isTranstionWidthOrHeightStyle
            }
            val changeScrollViewWidth1 = fun(){
                scrollView1.value?.style?.setProperty("width", if (isScrollViewWidth1) {
                    "100px"
                } else {
                    "150px"
                }
                )
                isScrollViewWidth1 = !isScrollViewWidth1
            }
            val changeScrollViewWidth2 = fun(){
                scrollView2.value?.style?.setProperty("width", if (isScrollViewWidth2) {
                    "100px"
                } else {
                    "150px"
                }
                )
                isScrollViewWidth2 = !isScrollViewWidth2
            }
            val changeNativeViewWidth1 = fun(){
                nativeView1.value?.style?.setProperty("width", if (isNativeViewWidth1) {
                    "100px"
                } else {
                    "150px"
                }
                )
                isNativeViewWidth1 = !isNativeViewWidth1
            }
            val changeNativeViewWidth2 = fun(){
                nativeView2.value?.style?.setProperty("width", if (isNativeViewWidth2) {
                    "100px"
                } else {
                    "150px"
                }
                )
                isNativeViewWidth2 = !isNativeViewWidth2
            }
            val changeMargin = fun(){
                styleMargin?.style?.setProperty("margin-top", if (isTranstionChangeMargin) {
                    "0px"
                } else {
                    "50px"
                }
                )
                styleMargin?.style?.setProperty("margin-left", if (isTranstionChangeMargin) {
                    "0px"
                } else {
                    "50px"
                }
                )
                isTranstionChangeMargin = !isTranstionChangeMargin
            }
            val changePadding = fun(){
                stylePadding?.style?.setProperty("padding-top", if (isTransitionStylePadding) {
                    "0px"
                } else {
                    "50px"
                }
                )
                stylePadding?.style?.setProperty("padding-left", if (isTransitionStylePadding) {
                    "0px"
                } else {
                    "50px"
                }
                )
                isTransitionStylePadding = !isTransitionStylePadding
            }
            val changeBackground = fun(){
                styleBackground?.style?.setProperty("background-color", if (isTransitionstyleBackground) {
                    "brown"
                } else {
                    "black"
                }
                )
                styleBackground?.style?.setProperty("opacity", if (isTransitionstyleBackground) {
                    "1"
                } else {
                    "0.5"
                }
                )
                isTransitionstyleBackground = !isTransitionstyleBackground
            }
            val changeBackground2 = fun(){
                styleBackground2?.style?.setProperty("background-color", if (isTransitionstyleBackground2) {
                    "brown"
                } else {
                    "rgba(0, 0, 0, 0.5)"
                }
                )
                isTransitionstyleBackground2 = !isTransitionstyleBackground2
            }
            val changeStyleOpacity = fun(){
                styleOpacity?.style?.setProperty("opacity", if (isTransitionstyleOpacity) {
                    "1"
                } else {
                    "0"
                }
                )
                isTransitionstyleOpacity = !isTransitionstyleOpacity
            }
            val propertyChangeBackground = fun(){
                if (!isSetTransition) {
                    propertyStyleBackground?.style?.setProperty("transition-property", "background-color")
                    propertyStyleBackground?.style?.setProperty("transition-duration", "1000ms")
                    isSetTransition = true
                }
                propertyStyleBackground?.style?.setProperty("background-color", if (isTransitionpropertystyleBackground) {
                    "brown"
                } else {
                    "black"
                }
                )
                isTransitionpropertystyleBackground = !isTransitionpropertystyleBackground
            }
            val changeTransform = fun(){
                styleTransform?.style?.setProperty("transform", if (isTransitionStyleTransform) {
                    "rotate(0deg)"
                } else {
                    "rotate(135deg)"
                }
                )
                isTransitionStyleTransform = !isTransitionStyleTransform
            }
            val changeTransformTranslate = fun(){
                val translate = if (isTransformTranslate) {
                    "translate(0%,0%)"
                } else {
                    "translate(100%,0%)"
                }
                styleTransformTranslate?.style?.setProperty("transform", translate)
                isTransformTranslate = !isTransformTranslate
            }
            val changeTransformWithWidth = fun(){
                styleTransformWithWidth?.style?.setProperty("transform", if (isTransitionStyleTransformWithWidth) {
                    "rotate(0deg)"
                } else {
                    "rotate(135deg)"
                }
                )
                styleTransformWithWidth?.style?.setProperty("width", if (isTransitionStyleTransformWithWidth) {
                    "200px"
                } else {
                    "100px"
                }
                )
                isTransitionStyleTransformWithWidth = !isTransitionStyleTransformWithWidth
            }
            val changeTransformWithOrigin = fun(){
                styleTransformWithOrigin?.style?.setProperty("transform", if (isTransitionStyleTransformWithOrigin) {
                    "scaleX(1)"
                } else {
                    "scaleX(0)"
                }
                )
                isTransitionStyleTransformWithOrigin = !isTransitionStyleTransformWithOrigin
            }
            val changeBorder = fun(){
                styleBorder?.style?.setProperty("border-color", if (isTransitionstyleBorder) {
                    "brown"
                } else {
                    "yellow"
                }
                )
                isTransitionstyleBorder = !isTransitionstyleBorder
            }
            val changestylePosition = fun(){
                stylePosition?.style?.setProperty("left", if (isTransitionstylePosition) {
                    "0px"
                } else {
                    "100px"
                }
                )
                isTransitionstylePosition = !isTransitionstylePosition
            }
            val changestyleScale = fun(){
                val el = uni_getElementById("styleChangScale")
                el?.style?.setProperty("transition-duration", "0ms")
                el?.style?.setProperty("transform", "translate(10px,10px) scale(1)")
                setTimeout(fun(){
                    el?.style?.setProperty("transition-duration", "200ms")
                    el?.style?.setProperty("transform", "translate(10px,10px) scale(0.5)")
                }
                , 200)
            }
            val handleTouchStart = fun(e: UniTouchEvent){
                startX = e.changedTouches[0].clientX
            }
            val handleTouchMove = fun(e: UniTouchEvent){
                console.log("touchmove:" + e.touches[0].clientX + "," + e.touches[0].clientY)
                e.preventDefault()
                e.stopPropagation()
                val difX = e.changedTouches[0].clientX
                moveX = difX - startX + oldX
                styleTransformTranslateScale?.style?.setProperty("transition-duration", "0ms")
                styleTransformTranslateScale?.style?.setProperty("transform", "translate(" + moveX + "px,0px) scale(0.5) rotate(90deg)")
            }
            val handleTouchEnd = fun(_: UniTouchEvent){
                oldX = moveX
            }
            val doChangeTransitionDuration = fun(){
                console.log("doChangeTransitionDuration")
                changestyleTransitionDuration.value = if (changestyleTransitionDuration.value == "background-color:brown;") {
                    "transition-duration: 2000ms;background-color: blue;"
                } else {
                    "background-color:brown;"
                }
            }
            val changeTransitionAll = fun(){
                if (!isTransitionAll) {
                    styleTransitionAll?.style?.setProperty("transition-property", "all")
                    styleTransitionAll?.style?.setProperty("width", "300px")
                    styleTransitionAll?.style?.setProperty("height", "300px")
                    styleTransitionAll?.style?.setProperty("background-color", "blue")
                    styleTransitionAll?.style?.setProperty("transform", "rotate(45deg)")
                } else {
                    styleTransitionAll?.style?.setProperty("transition-property", "none")
                    styleTransitionAll?.style?.setProperty("width", "200px")
                    styleTransitionAll?.style?.setProperty("height", "200px")
                    styleTransitionAll?.style?.setProperty("background-color", "brown")
                    styleTransitionAll?.style?.setProperty("transform", "rotate(0deg)")
                }
                isTransitionAll = !isTransitionAll
            }
            val changeTransform61 = fun(){
                if (lineLeft.value == 0) {
                    lineLeft.value = 70
                    lineWidth.value = 300
                } else {
                    lineLeft.value = 0
                    lineWidth.value = 200
                }
            }
            val onChangeWidthEnd = fun(event: UniEvent){
                changeWidthInEnd?.style?.setProperty("width", "300px")
                changeWidthInEndCount++
            }
            val changeWidthInEndFun = fun(){
                changeWidthInEnd?.style?.setProperty("width", "300px")
            }
            val changeTextTransform = fun(){
                textTransform?.style?.setProperty("transform", if (isTextTransform) {
                    "rotate(0deg)"
                } else {
                    "rotate(45deg)"
                }
                )
                isTextTransform = !isTextTransform
            }
            val changeTextOpacity = fun(){
                textOpacity?.style?.setProperty("opacity", if (isTextOpacity) {
                    "1"
                } else {
                    "0.5"
                }
                )
                isTextOpacity = !isTextOpacity
            }
            val changeTextBackground = fun(){
                textBackground?.style?.setProperty("background-color", if (isTextBackground) {
                    "transparent"
                } else {
                    "yellow"
                }
                )
                isTextBackground = !isTextBackground
            }
            val changeImageTransform = fun(){
                imageTransform?.style?.setProperty("transform", if (isImageTransform) {
                    "rotate(0deg)"
                } else {
                    "rotate(45deg)"
                }
                )
                isImageTransform = !isImageTransform
            }
            val changeImageOpacity = fun(){
                imageOpacity?.style?.setProperty("opacity", if (isImageOpacity) {
                    "1"
                } else {
                    "0.5"
                }
                )
                isImageOpacity = !isImageOpacity
            }
            val changeImageScale = fun(){
                imageScale?.style?.setProperty("transform", if (isImageScale) {
                    "scale(1)"
                } else {
                    "scale(1.5)"
                }
                )
                isImageScale = !isImageScale
            }
            fun gen_changeBorderAndBackgroundColor_fn() {
                elChangeBorderAndBackgroundColor?.style?.setProperty("background-color", if (!isChangeBorderAndBackgroundColor) {
                    "pink"
                } else {
                    "brown"
                }
                )
                elChangeBorderAndBackgroundColor?.style?.setProperty("border-color", if (!isChangeBorderAndBackgroundColor) {
                    "yellow"
                } else {
                    "blue"
                }
                )
                isChangeBorderAndBackgroundColor = !isChangeBorderAndBackgroundColor
            }
            val changeBorderAndBackgroundColor = ::gen_changeBorderAndBackgroundColor_fn
            val data = reactive(TransitionData(transitionValue = "width 1s", transitionActual = "", transitionActualText = "", transitionActualImage = "", transitionActualFlat = "", transitionActualTextFlat = "", transitionActualImageFlat = ""))
            val viewRefTransition = ref(null as UniElement?)
            val textRefTransition = ref(null as UniTextElement?)
            val imageRefTransition = ref(null as UniImageElement?)
            val viewRefTransitionFlat = ref(null as UniElement?)
            val textRefTransitionFlat = ref(null as UniTextElement?)
            val imageRefTransitionFlat = ref(null as UniImageElement?)
            val isExpandedTransition = ref(false)
            val isExpandedTransitionText = ref(false)
            val isExpandedTransitionImage = ref(false)
            val transitionEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "width 2s"),
                ItemType(value = 2, name = "background-color 1s"),
                ItemType(value = 3, name = "transform 1s"),
                ItemType(value = 4, name = "all 1s"),
                ItemType(value = 5, name = "width 1s, background-color 1s")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data.transitionActual = viewRefTransition.value?.style?.getPropertyValue("transition") ?: ""
                data.transitionActualFlat = viewRefTransitionFlat.value?.style?.getPropertyValue("transition") ?: ""
                data.transitionActualText = textRefTransition.value?.style?.getPropertyValue("transition") ?: ""
                data.transitionActualTextFlat = textRefTransitionFlat.value?.style?.getPropertyValue("transition") ?: ""
                data.transitionActualImage = imageRefTransition.value?.style?.getPropertyValue("transition") ?: ""
                data.transitionActualImageFlat = imageRefTransitionFlat.value?.style?.getPropertyValue("transition") ?: ""
            }
            val changeTransition = fun(value: String){
                data.transitionValue = value
                viewRefTransition.value?.style?.setProperty("transition", value)
                viewRefTransitionFlat.value?.style?.setProperty("transition", value)
                textRefTransition.value?.style?.setProperty("transition", value)
                textRefTransitionFlat.value?.style?.setProperty("transition", value)
                imageRefTransition.value?.style?.setProperty("transition", value)
                imageRefTransitionFlat.value?.style?.setProperty("transition", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTransition = fun(index: Number){
                val selectedItem = transitionEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTransition(selectedItem.name)
                }
            }
            val inputChangeTransition = fun(value: String){
                changeTransition(value)
            }
            val triggerTransitionView = fun(){
                val transition: String = data.transitionValue
                isExpandedTransition.value = !isExpandedTransition.value
                if (transition.includes("background-color")) {
                    val color = if (isExpandedTransition.value) {
                        "red"
                    } else {
                        "green"
                    }
                    viewRefTransition.value?.style?.setProperty("background-color", color)
                    viewRefTransitionFlat.value?.style?.setProperty("background-color", color)
                } else if (transition.includes("width")) {
                    val width = if (isExpandedTransition.value) {
                        "100px"
                    } else {
                        "50px"
                    }
                    viewRefTransition.value?.style?.setProperty("width", width)
                    viewRefTransitionFlat.value?.style?.setProperty("width", width)
                } else if (transition.includes("transform")) {
                    val transform = if (isExpandedTransition.value) {
                        "rotate(45deg)"
                    } else {
                        "rotate(0deg)"
                    }
                    viewRefTransition.value?.style?.setProperty("transform", transform)
                    viewRefTransitionFlat.value?.style?.setProperty("transform", transform)
                } else if (transition.includes("all")) {
                    val width = if (isExpandedTransition.value) {
                        "100px"
                    } else {
                        "50px"
                    }
                    val color = if (isExpandedTransition.value) {
                        "red"
                    } else {
                        "green"
                    }
                    viewRefTransition.value?.style?.setProperty("width", width)
                    viewRefTransition.value?.style?.setProperty("background-color", color)
                    viewRefTransitionFlat.value?.style?.setProperty("width", width)
                    viewRefTransitionFlat.value?.style?.setProperty("background-color", color)
                }
            }
            val triggerTransitionText = fun(){
                val transition: String = data.transitionValue
                isExpandedTransitionText.value = !isExpandedTransitionText.value
                if (transition.includes("background-color")) {
                    val color = if (isExpandedTransitionText.value) {
                        "red"
                    } else {
                        "green"
                    }
                    textRefTransition.value?.style?.setProperty("background-color", color)
                    textRefTransitionFlat.value?.style?.setProperty("background-color", color)
                } else if (transition.includes("width")) {
                    val width = if (isExpandedTransitionText.value) {
                        "100px"
                    } else {
                        "50px"
                    }
                    textRefTransition.value?.style?.setProperty("width", width)
                    textRefTransitionFlat.value?.style?.setProperty("width", width)
                } else if (transition.includes("transform")) {
                    val transform = if (isExpandedTransitionText.value) {
                        "rotate(45deg)"
                    } else {
                        "rotate(0deg)"
                    }
                    textRefTransition.value?.style?.setProperty("transform", transform)
                    textRefTransitionFlat.value?.style?.setProperty("transform", transform)
                } else if (transition.includes("all")) {
                    val width = if (isExpandedTransitionText.value) {
                        "100px"
                    } else {
                        "50px"
                    }
                    val color = if (isExpandedTransitionText.value) {
                        "red"
                    } else {
                        "green"
                    }
                    textRefTransition.value?.style?.setProperty("width", width)
                    textRefTransition.value?.style?.setProperty("background-color", color)
                    textRefTransitionFlat.value?.style?.setProperty("width", width)
                    textRefTransitionFlat.value?.style?.setProperty("background-color", color)
                }
            }
            val triggerTransitionImage = fun(){
                val transition: String = data.transitionValue
                isExpandedTransitionImage.value = !isExpandedTransitionImage.value
                if (transition.includes("background-color")) {
                    val color = if (isExpandedTransitionImage.value) {
                        "red"
                    } else {
                        "green"
                    }
                    imageRefTransition.value?.style?.setProperty("background-color", color)
                    imageRefTransitionFlat.value?.style?.setProperty("background-color", color)
                } else if (transition.includes("width")) {
                    val width = if (isExpandedTransitionImage.value) {
                        "100px"
                    } else {
                        "50px"
                    }
                    imageRefTransition.value?.style?.setProperty("width", width)
                    imageRefTransitionFlat.value?.style?.setProperty("width", width)
                } else if (transition.includes("transform")) {
                    val transform = if (isExpandedTransitionImage.value) {
                        "rotate(45deg)"
                    } else {
                        "rotate(0deg)"
                    }
                    imageRefTransition.value?.style?.setProperty("transform", transform)
                    imageRefTransitionFlat.value?.style?.setProperty("transform", transform)
                } else if (transition.includes("all")) {
                    val width = if (isExpandedTransitionImage.value) {
                        "100px"
                    } else {
                        "50px"
                    }
                    val color = if (isExpandedTransitionImage.value) {
                        "red"
                    } else {
                        "green"
                    }
                    imageRefTransition.value?.style?.setProperty("width", width)
                    imageRefTransition.value?.style?.setProperty("background-color", color)
                    imageRefTransitionFlat.value?.style?.setProperty("width", width)
                    imageRefTransitionFlat.value?.style?.setProperty("background-color", color)
                }
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("changeWidthOrHeight" to changeWidthOrHeight, "changeWidthProgress" to changeWidthProgress, "changeMargin" to changeMargin, "changePadding" to changePadding, "changeBackground" to changeBackground, "changeBackground2" to changeBackground2, "changeStyleOpacity" to changeStyleOpacity, "propertyChangeBackground" to propertyChangeBackground, "changeTransform" to changeTransform, "changeTransformTranslate" to changeTransformTranslate, "changeTransformWithWidth" to changeTransformWithWidth, "changeTransformWithOrigin" to changeTransformWithOrigin, "changeBorder" to changeBorder, "changestylePosition" to changestylePosition, "changeTransitionAll" to changeTransitionAll, "changeWidthInEndFun" to changeWidthInEndFun, "getChangeWidthInEndCount" to getChangeWidthInEndCount, "changeBorderAndBackgroundColor" to changeBorderAndBackgroundColor, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改宽度"),
                        _cE("view", _uM("class" to "base-style transition-width", "id" to "widthOrHeight", "onClick" to changeWidthOrHeight))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改宽度(递增)"),
                        _cE("view", _uM("class" to "width-progress transition-width", "id" to "widthProgress", "onClick" to changeWidthProgress))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改宽度(通过style设置transition)"),
                        _cE("view", _uM("class" to "base-style", "style" to _nS(_uM("transition-property" to "width", "transition-duration" to "1s")), "id" to "widthOrHeightStyle", "onClick" to changeWidthOrHeightStyle), null, 4)
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改Margin"),
                        _cE("view", _uM("class" to "base-style transition-margin", "id" to "styleMargin", "onClick" to changeMargin))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改Padding"),
                        _cE("view", _uM("class" to "base-style transition-padding", "id" to "stylePadding", "onClick" to changePadding), _uA(
                            _cE("view", _uM("style" to _nS(_uM("background-color" to "black", "height" to "50px", "width" to "50px"))), null, 4)
                        ))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改background-color和opacity"),
                        _cE("view", _uM("class" to "base-style transition-background", "id" to "styleBackground", "onClick" to changeBackground))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改background-color（rgba）"),
                        _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                            _cE("view", _uM("class" to "base-style transition-background", "id" to "styleBackground2", "onClick" to changeBackground2))
                        ), 4)
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改opacity渐隐渐现"),
                        _cE("view", _uM("class" to "base-style transition-opacity", "id" to "styleOpacity", "onClick" to changeStyleOpacity))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "动态修改background-color和duration"),
                        _cE("view", _uM("class" to "base-style", "id" to "propertyStyleBackground", "onClick" to propertyChangeBackground))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改Transform"),
                        _cE("view", _uM("class" to "base-style transition-transform", "id" to "styleTransform", "onClick" to changeTransform))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改TransformTranslate"),
                        _cE("view", _uM("class" to "base-style transition-transform", "id" to "transformTranslate", "onClick" to changeTransformTranslate))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改Transform和宽"),
                        _cE("view", _uM("class" to "base-style transition-transform-width", "id" to "styleTransformWithWidth", "onClick" to changeTransformWithWidth))
                    )),
                    _cE("view", _uM("class" to "container", "onClick" to changeTransformWithOrigin), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改Transform（含transform-origin）"),
                        _cE("view", _uM("class" to "base-style transition-transform", "style" to _nS(_uM("transform-origin" to "0 0")), "id" to "styleTransformWithOrigin"), null, 4)
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改Border"),
                        _cE("view", _uM("class" to "base-style transition-border", "id" to "styleBorder", "onClick" to changeBorder))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改Position"),
                        _cE("view", _uM("class" to "base-style transition-position", "id" to "stylePosition", "onClick" to changestylePosition))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改Scale "),
                        _cE("view", _uM("class" to "base-style transition-transform", "id" to "styleChangScale", "onClick" to changestyleScale))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "仅指定transition-duration背影有动画为正常"),
                        _cE("view", _uM("style" to _nS(_uA(
                            _uM("width" to "100%", "height" to "50px"),
                            unref(changestyleTransitionDuration)
                        )), "onClick" to doChangeTransitionDuration), null, 4)
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "transition-property: all/none 演示"),
                        _cE("view", _uM("class" to "base-style transition-all", "id" to "styleTransitionAll", "onClick" to changeTransitionAll))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "在组件内滑动测试是否闪动"),
                        _cE("view", _uM("class" to "base-style transition-transform", "id" to "styleTransformTranslateScale", "onTouchmove" to handleTouchMove, "onTouchstart" to handleTouchStart, "onTouchend" to handleTouchEnd), " 这是一段文字 ", 32)
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "测试在style中同时修改transform和width"),
                        _cE("view", _uM("style" to _nS(_uM("width" to "100%", "height" to "100%"))), _uA(
                            _cE("view", _uM("class" to "base-style transition-transform-width", "style" to _nS(_uM("transform" to ("translateX(" + unref(lineLeft) + "px)"), "width" to ("" + unref(lineWidth) + "px"))), "onClick" to changeTransform61), null, 4)
                        ), 4)
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "点击修改宽度(值为auto有无动画交替出现)"),
                        _cE("view", _uM("class" to "base-style transition-width", "id" to "widthOrHeightAuto", "onClick" to changeWidthOrHeightAuto))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("view", _uM("class" to "text"), "重复修改width"),
                        _cE("view", _uM("class" to "base-style transition-width", "id" to "changeWidthInEnd", "style" to _nS(_uM("transition-duration" to "0.5s")), "onTransitionend" to onChangeWidthEnd, "onClick" to changeWidthInEndFun), null, 36)
                    )),
                    _cE("view", _uM("style" to _nS(_uM("margin-top" to "20px", "margin-left" to "7px"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "18px", "font-weight" to "bold"))), "text 组件 transition ", 4)
                    ), 4),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "text 点击修改 transform (rotate)"),
                        _cE("text", _uM("class" to "text-base-style transition-transform", "id" to "textTransform", "onClick" to changeTextTransform), "文字内容")
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "text 点击修改 opacity"),
                        _cE("text", _uM("class" to "text-base-style transition-opacity", "id" to "textOpacity", "onClick" to changeTextOpacity), "文字内容")
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "text 点击修改 background-color"),
                        _cE("text", _uM("class" to "text-base-style transition-background", "id" to "textBackground", "onClick" to changeTextBackground), "文字内容")
                    )),
                    _cE("view", _uM("style" to _nS(_uM("margin-top" to "20px", "margin-left" to "7px"))), _uA(
                        _cE("text", _uM("style" to _nS(_uM("font-size" to "18px", "font-weight" to "bold"))), "image 组件 transition ", 4)
                    ), 4),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "image 点击修改 transform (rotate)"),
                        _cE("image", _uM("class" to "image-base-style transition-transform", "id" to "imageTransform", "onClick" to changeImageTransform, "src" to "/static/test-image/logo.png"))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "image 点击修改 opacity"),
                        _cE("image", _uM("class" to "image-base-style transition-opacity", "id" to "imageOpacity", "onClick" to changeImageOpacity, "src" to "/static/test-image/logo.png"))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "image 点击修改 transform (scale)"),
                        _cE("image", _uM("class" to "image-base-style transition-transform", "id" to "imageScale", "onClick" to changeImageScale, "src" to "/static/test-image/logo.png"))
                    )),
                    _cE("view", _uM("class" to "container"), _uA(
                        _cE("text", _uM("class" to "text"), "设置box-shadow之后验证border和background-color效果"),
                        _cE("view", _uM("class" to "base-style transition-border-background", "id" to "borderAndBackgroundColor", "onClick" to changeBorderAndBackgroundColor))
                    )),
                    _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                    _cE("text", _uM("class" to "text"), "点击 scroll-view 查看 transition 效果"),
                    _cE("view", _uM("class" to "demo-box"), _uA(
                        _cE("scroll-view", _uM("ref_key" to "scrollView1", "ref" to scrollView1, "class" to "base-style", "style" to _nS(_uM("transition" to "width 1s")), "onClick" to changeScrollViewWidth1), _uA(
                            _cE("text", null, "transition: width 1s")
                        ), 4),
                        _cE("scroll-view", _uM("ref_key" to "scrollView2", "ref" to scrollView2, "class" to "base-style", "style" to _nS(_uM("transition" to "width 2s ease-in-out")), "onClick" to changeScrollViewWidth2), _uA(
                            _cE("text", null, "transition: width 2s ease-in-out")
                        ), 4)
                    )),
                    _cE("view", _uM("class" to "uni-common-mt"), _uA(
                        _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 transition ")
                    )),
                    _cE("view", _uM("class" to "test-container"), _uA(
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).transitionValue), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).transitionActual), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("view", _uM("ref_key" to "viewRefTransition", "ref" to viewRefTransition, "class" to "common-image", "style" to _nS(_uM("transition" to unref(data).transitionValue)), "onClick" to triggerTransitionView), _uA(
                                    _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "点击view", 4)
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).transitionValue), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).transitionActualText), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("text", _uM("ref_key" to "textRefTransition", "ref" to textRefTransition, "class" to "common-text", "style" to _nS(_uM("transition" to unref(data).transitionValue)), "onClick" to triggerTransitionText), "点击text", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).transitionValue), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).transitionActualImage), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("image", _uM("ref_key" to "imageRefTransition", "ref" to imageRefTransition, "class" to "common-image", "style" to _nS(_uM("transition" to unref(data).transitionValue)), "onClick" to triggerTransitionImage, "src" to "/static/test-image/logo.png"), null, 4)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "test-container"), _uA(
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).transitionValue), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).transitionActualFlat), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("view", _uM("ref_key" to "viewRefTransitionFlat", "ref" to viewRefTransitionFlat, "class" to "common-image", "style" to _nS(_uM("transition" to unref(data).transitionValue)), "onClick" to triggerTransitionView, "flatten" to ""), _uA(
                                    _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "点击view", 4)
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).transitionValue), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).transitionActualTextFlat), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("text", _uM("ref_key" to "textRefTransitionFlat", "ref" to textRefTransitionFlat, "class" to "common-text", "style" to _nS(_uM("transition" to unref(data).transitionValue)), "onClick" to triggerTransitionText, "flatten" to ""), "点击text", 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "test-item"), _uA(
                            _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data).transitionValue), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data).transitionActualImageFlat), 1),
                            _cE("view", _uM("class" to "test-box"), _uA(
                                _cE("image", _uM("ref_key" to "imageRefTransitionFlat", "ref" to imageRefTransitionFlat, "class" to "common-image", "style" to _nS(_uM("transition" to unref(data).transitionValue)), "onClick" to triggerTransitionImage, "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                            ))
                        ))
                    )),
                    _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                        _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                        _cV(_component_enum_data, _uM("items" to transitionEnum, "title" to "transition 枚举值", "onChange" to radioChangeTransition, "compact" to true)),
                        _cV(_component_input_data, _uM("defaultValue" to unref(data).transitionValue, "title" to "transition 自定义值", "type" to "text", "onConfirm" to inputChangeTransition), null, 8, _uA(
                            "defaultValue"
                        ))
                    )),
                    _cE("text", _uM("class" to "uni-title-text uni-common-mt uni-common-mb"), "native-view 组件"),
                    _cE("text", _uM("class" to "text"), "点击 native-view 查看 transition 效果"),
                    _cE("view", _uM("class" to "demo-box"), _uA(
                        _cE("native-view", _uM("ref_key" to "nativeView1", "ref" to nativeView1, "class" to "base-style", "style" to _nS(_uM("transition" to "width 1s")), "onClick" to changeNativeViewWidth1), null, 4),
                        _cE("native-view", _uM("ref_key" to "nativeView2", "ref" to nativeView2, "class" to "base-style", "style" to _nS(_uM("transition" to "width 2s ease-in-out")), "onClick" to changeNativeViewWidth2), null, 4)
                    ))
                ), 4)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("container" to _pS(_uM("marginTop" to 7, "marginRight" to 7, "marginBottom" to 7, "marginLeft" to 7, "backgroundColor" to "#FFFFFF")), "text" to _pS(_uM("marginTop" to 10, "marginBottom" to 16)), "base-style" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#A52A2A")), "demo-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to 10)), "width-progress" to _pS(_uM("width" to 100, "height" to 100, "backgroundColor" to "#A52A2A")), "transform-bgColor" to _pS(_uM("transitionProperty" to "backgroundColor", "transitionDuration" to "0.5s")), "transition-width" to _pS(_uM("transitionProperty" to "width", "transitionDuration" to "1s")), "transition-margin" to _pS(_uM("transitionProperty" to "marginLeft,marginTop", "transitionDuration" to "1s")), "transition-padding" to _pS(_uM("transitionProperty" to "paddingLeft,paddingTop", "transitionDuration" to "1s")), "transition-background" to _pS(_uM("transitionProperty" to "backgroundColor,opacity", "transitionDuration" to "1s")), "transition-opacity" to _pS(_uM("transitionProperty" to "opacity", "transitionDuration" to "1s")), "transition-transform" to _pS(_uM("transform" to "translate(0%, 0%) scaleX(1) rotate(0deg)", "transitionProperty" to "transform", "transitionDuration" to "1s")), "transition-border" to _pS(_uM("borderTopWidth" to 5, "borderRightWidth" to 5, "borderBottomWidth" to 5, "borderLeftWidth" to 5, "borderTopColor" to "#A52A2A", "borderRightColor" to "#A52A2A", "borderBottomColor" to "#A52A2A", "borderLeftColor" to "#A52A2A", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "transitionProperty" to "borderColor", "transitionDuration" to "1s")), "transition-position" to _pS(_uM("left" to 0, "transitionProperty" to "left", "transitionDuration" to "1s")), "transition-transform-width" to _pS(_uM("transform" to "rotate(0deg)", "transitionProperty" to "transform,width", "transitionDuration" to "1s")), "transition-all" to _pS(_uM("transitionProperty" to "all", "transitionDuration" to "1s")), "text-base-style" to _pS(_uM("width" to 200, "height" to 50, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "fontSize" to 16, "textAlign" to "center", "backgroundColor" to "#ADD8E6")), "image-base-style" to _pS(_uM("width" to 100, "height" to 100)), "transition-border-background" to _pS(_uM("boxShadow" to "8px 8px 8px rgba(0, 255, 0, 1)", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "borderTopWidth" to 3, "borderRightWidth" to 3, "borderBottomWidth" to 3, "borderLeftWidth" to 3, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "transitionProperty" to "borderColor,backgroundColor", "transitionDuration" to "1s")), "common-text" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000", "fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 120, "backgroundColor" to "#808080")), "@TRANSITION" to _uM("transform-bgColor" to _uM("property" to "backgroundColor", "duration" to "0.5s"), "transition-width" to _uM("property" to "width", "duration" to "1s"), "transition-margin" to _uM("property" to "marginLeft,marginTop", "duration" to "1s"), "transition-padding" to _uM("property" to "paddingLeft,paddingTop", "duration" to "1s"), "transition-background" to _uM("property" to "backgroundColor,opacity", "duration" to "1s"), "transition-opacity" to _uM("property" to "opacity", "duration" to "1s"), "transition-transform" to _uM("property" to "transform", "duration" to "1s"), "transition-border" to _uM("property" to "borderColor", "duration" to "1s"), "transition-position" to _uM("property" to "left", "duration" to "1s"), "transition-transform-width" to _uM("property" to "transform,width", "duration" to "1s"), "transition-all" to _uM("property" to "all", "duration" to "1s"), "transition-border-background" to _uM("property" to "borderColor,backgroundColor", "duration" to "1s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
