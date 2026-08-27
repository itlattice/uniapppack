@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2971F61
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
import uts.sdk.modules.iboxsChooseMedia.MediaScanner
open class GenUniModulesTmxUiComponentsTmxIconTmxIcon : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var name: String by `$props`
    open var fontSize: String by `$props`
    open var fontFamily: String by `$props`
    open var code: String by `$props`
    open var color: String by `$props`
    open var darkColor: String by `$props`
    open var spin: Boolean by `$props`
    open var rotation: Number by `$props`
    open var duration: Number by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxIconTmxIcon) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxIconTmxIcon
            val _cache = __ins.renderCache
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val id = ("xIconspin" + getUid()) as String
            var element: UniElement? = null
            val isLoad = ref<Boolean>(false)
            var isdestory = false
            var tid: Number = 0
            var xt = xTween()
            val xIcons = ref<UniElement?>(null)
            val _mpcode = computed(fun(): String {
                var cname = ""
                return cname
            }
            )
            val _isFileImg = computed(fun(): Boolean {
                if (props.name.lastIndexOf(".") > -1 || props.name.indexOf("ftp:") > -1 || props.name.indexOf("https:") > -1 || props.name.indexOf("http:") > -1 || props.name.indexOf("data:image") > -1) {
                    return true
                }
                return false
            }
            )
            val iconName = computed(fun(): String {
                if (_isFileImg.value) {
                    return props.name
                }
                var texts = ""
                try {
                    var codestr = ""
                    if (props.code == "") {
                        codestr = fonts.getString(props.name)!!
                    } else {
                        codestr = props.code
                    }
                    var codePoint = Integer.parseInt(codestr, 16)
                    var charArray = Character.toChars(codePoint)
                    texts = String(charArray)
                }
                 catch (e: Throwable) {
                    console.error("xicon解析失败。", e)
                }
                return texts
            }
            )
            val _fontSize = computed(fun(): String {
                var fontSize = checkIsCssUnit(props.fontSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 16
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _color = computed(fun(): String {
                var color = if (props.color == "") {
                    "black"
                } else {
                    props.color
                }
                if (xConfig.dark == "dark") {
                    if (props.darkColor != "") {
                        color = props.darkColor!!
                        return getDefaultColor(color)
                    }
                    return setTextColorLightByDark(color)
                }
                return getDefaultColor(color)
            }
            )
            fun gen_setRadeg_fn() {
                try {
                    element = xIcons.value as UniElement
                    element!!.style.setProperty("transition-duration", props.duration.toString(10) + "ms")
                    element!!.style.setProperty("transform", "rotate(" + props.rotation + "deg)")
                }
                 catch (_e: Throwable) {}
            }
            val setRadeg = ::gen_setRadeg_fn
            fun gen_playSpin_fn() {
                if (!props.spin || isdestory) {
                    return
                }
                var elementLocal = xIcons.value as UniElement
                xt.pause()
                xt.destroy()
                xt.startRender()
                xt.addAnimate(xTweenAnimate(loop = -1, duration = props.duration, complete = fun(item: xTweenEventCallFunType){}, enter = fun(item: xTweenEventCallFunType){
                    elementLocal!!.style.setProperty("transition-duration", "0ms")
                    elementLocal!!.style.setProperty("transform", "rotate(" + 360 * item.progress + "deg)")
                }
                , pause = fun(item: xTweenEventCallFunType){}))
                xt.play()
            }
            val playSpin = ::gen_playSpin_fn
            fun gen_clickListen_fn() {
                emits("click")
            }
            val clickListen = ::gen_clickListen_fn
            fun gen_loadFontByX_fn() {
                isLoad.value = true
            }
            val loadFontByX = ::gen_loadFontByX_fn
            watch(fun(): Boolean {
                return props.spin
            }
            , fun(){
                if (props.spin) {
                    playSpin()
                } else {
                    xt.pause()
                    xt.destroy()
                }
            }
            )
            watch(fun(): Number {
                return props.rotation
            }
            , fun(){
                if (props.spin) {
                    return
                }
                setRadeg()
            }
            )
            onBeforeUnmount(fun(){
                isdestory = true
                clearTimeout(tid)
                xt.destroy()
            }
            )
            onMounted(fun(){
                loadFontByX()
                isdestory = false
                if (props.spin) {
                    playSpin()
                } else {
                    nextTick(fun(){
                        setRadeg()
                    }
                    )
                }
            }
            )
            return fun(): Any? {
                return if (isTrue(!_isFileImg.value)) {
                    _cE("text", _uM("key" to 0, "onClick" to clickListen, "id" to id, "ref_key" to "xIcons", "ref" to xIcons, "class" to _nC(_uA(
                        "face",
                        _uA(
                            if (props.spin) {
                                "faceSpinIcon"
                            } else {
                                ""
                            },
                            _mpcode.value
                        )
                    )), "style" to _nS(_uM("font-family" to _ctx.fontFamily, "font-size" to _fontSize.value, "color" to _color.value, "width" to _fontSize.value, "height" to _fontSize.value, "lineHeight" to _fontSize.value))), _tD(iconName.value), 7)
                } else {
                    _cE("image", _uM("key" to 1, "onClick" to clickListen, "id" to id, "ref_key" to "xIcons", "ref" to xIcons, "style" to _nS(_uM("width" to _fontSize.value, "height" to _fontSize.value)), "src" to iconName.value), null, 12, _uA(
                        "src"
                    ))
                }
            }
        }
        var name = "xIcon"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("face" to _pS(_uM("transitionProperty" to "transform", "transitionDuration" to "0ms", "transitionTimingFunction" to "linear", "transform" to "rotate(0deg)", "textAlign" to "center")), "@TRANSITION" to _uM("face" to _uM("property" to "transform", "duration" to "0ms", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("name" to _uM("type" to "String", "required" to true, "default" to "home-3-fill"), "fontSize" to _uM("type" to "String", "required" to true, "default" to "16"), "fontFamily" to _uM("type" to "String", "required" to true, "default" to "remixicon"), "code" to _uM("type" to "String", "required" to true, "default" to ""), "color" to _uM("type" to "String", "required" to true, "default" to "black"), "darkColor" to _uM("type" to "String", "required" to true, "default" to ""), "spin" to _uM("type" to "Boolean", "required" to true, "default" to false), "rotation" to _uM("type" to "Number", "required" to true, "default" to 0), "duration" to _uM("type" to "Number", "required" to true, "default" to 1500)))
        var propsNeedCastKeys = _uA(
            "name",
            "fontSize",
            "fontFamily",
            "code",
            "color",
            "darkColor",
            "spin",
            "rotation",
            "duration"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
