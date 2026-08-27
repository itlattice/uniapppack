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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenPagesTemplateDropCardCardCard : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var img: String by `$props`
    open var cardIndex: Number by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateDropCardCardCard) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateDropCardCardCard
            val _cache = __ins.renderCache
            val card = ref<UniElement?>(null)
            val cardImg = ref<UniElement?>(null)
            val stateIconLike = ref<UniElement?>(null)
            val stateIconDislike = ref<UniElement?>(null)
            val props = __props
            var sX: Number = 0
            var sY: Number = 0
            var screenWidth: Number = 1
            var screenHeight: Number = 1
            var floating: Boolean = false
            var touchstartAfter: Boolean = false
            val `$elementMap` = Map<String, UniElement>()
            val x = ref(0 as Number)
            val y = ref(0 as Number)
            var floatCount: Number = 0
            val movePercent = computed(fun(): Number {
                return Math.abs(x.value) / (screenWidth / 2 * 3)
            }
            )
            val likeOpacity = computed(fun(): Number {
                return if (x.value < 0) {
                    0
                } else {
                    movePercent.value * 100
                }
            }
            )
            val dislikeOpacity = computed(fun(): Number {
                return if (x.value > 0) {
                    0
                } else {
                    movePercent.value * 100
                }
            }
            )
            fun gen_setElementStyle_fn(refName: String, propertyName: String, propertyStyle: Any): Unit {
                var element: UniElement? = `$elementMap`.get(refName)
                if (element == null) {
                    if (refName == "card") {
                        element = card.value
                    } else if (refName == "card-img") {
                        element = cardImg.value
                    } else if (refName == "state-icon-like") {
                        element = stateIconLike.value
                    } else if (refName == "state-icon-dislike") {
                        element = stateIconDislike.value
                    }
                    if (element != null) {
                        `$elementMap`.set(refName, element)
                    }
                }
                if (element != null) {
                    element.style.setProperty(propertyName, propertyStyle.toString())
                }
            }
            val setElementStyle = ::gen_setElementStyle_fn
            fun gen_initCardStyle_fn() {
                var _index = (props.cardIndex + floatCount) % 3
                setElementStyle("card", "z-index", _index.toString(10))
                setElementStyle("card", "margin-top", screenHeight * 0.15 - 30 * _index + "px")
                setElementStyle("card", "transform", "scale(" + (0.9 + 0.05 * _index) + ")")
            }
            val initCardStyle = ::gen_initCardStyle_fn
            fun gen_moveCard_fn() {
                setElementStyle("card", "transform", "translate(" + x.value + "px," + y.value + "px) rotate(" + x.value / -30 + "deg) scale(1)")
                setElementStyle("state-icon-like", "opacity", if (x.value < 0) {
                    0
                } else {
                    movePercent.value * 10
                }
                )
                setElementStyle("state-icon-dislike", "opacity", if (x.value > 0) {
                    0
                } else {
                    movePercent.value * 10
                }
                )
            }
            val moveCard = ::gen_moveCard_fn
            fun gen_touchstart_fn(e: TouchEvent) {
                if (floating) {
                    return
                }
                sX = e.touches[0].screenX
                sY = e.touches[0].screenY
                x.value = 0
                y.value = 0
                touchstartAfter = true
            }
            val touchstart = ::gen_touchstart_fn
            fun gen_touchmove_fn(e: TouchEvent) {
                if (!touchstartAfter || floating) {
                    return
                }
                x.value += e.touches[0].screenX - sX
                y.value += e.touches[0].screenY - sY
                sX = e.touches[0].screenX
                sY = e.touches[0].screenY
                moveCard()
            }
            val touchmove = ::gen_touchmove_fn
            fun gen_touchend_fn() {
                touchstartAfter = false
                if (floating) {
                    return
                }
                floating = true
                var k: Number = 0
                if (x.value > screenWidth / 10) {
                    k = 1
                } else if (x.value < screenWidth * -1 / 10) {
                    k = -1
                }
                fun cardTo(targetX: Number, targetY: Number, callback: () -> Unit, speed: Number = 10) {
                    var interval: Number = 0
                    var acceleration: Number = 1
                    interval = setInterval(fun(){
                        acceleration += 0.2
                        val dx = targetX - x.value
                        if (Math.abs(dx) < 1) {
                            x.value = targetX
                        } else {
                            x.value += dx / speed * acceleration
                        }
                        val dy = targetY - y.value
                        if (Math.abs(dy) < 1) {
                            y.value = targetY
                        } else {
                            y.value += dy / speed * acceleration
                        }
                        moveCard()
                        if (x.value == targetX && y.value == targetY) {
                            clearInterval(interval)
                            callback()
                        }
                    }
                    , 16)
                }
                if (Math.floor(k) != 0) {
                    cardTo(k * screenWidth * 1.3, y.value * 3, fun(){
                        setElementStyle("state-icon-like", "opacity", 0)
                        setElementStyle("state-icon-dislike", "opacity", 0)
                        setElementStyle("card", "opacity", 0)
                        setTimeout(fun(){
                            setElementStyle("card", "opacity", 1)
                        }, 300)
                        uni__emit("uni-drop-card-float", null)
                        floating = false
                    }, 8)
                } else {
                    val _x: Number = x.value
                    val _y: Number = y.value
                    cardTo(Math.floor(_x * -0.05), Math.floor(_y * -0.05), fun(){
                        cardTo(0, 0, fun(){
                            console.log("bounce")
                            floating = false
                        }
                        , 30)
                    }
                    )
                }
            }
            val touchend = ::gen_touchend_fn
            onMounted(fun(){
                screenWidth = uni_getWindowInfo().screenWidth
                screenHeight = uni_getWindowInfo().screenHeight
                setTimeout(fun(){
                    setElementStyle("card", "height", screenHeight * 0.7 + "px")
                    setElementStyle("card-img", "height", screenHeight * 0.7 + "px")
                    initCardStyle()
                }
                , 200)
                uni__on("uni-drop-card-float", fun(){
                    floatCount++
                    initCardStyle()
                }
                )
            }
            )
            onUnmounted(fun(){
                uni__off("uni-drop-card-float", null)
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "card", "ref_key" to "card", "ref" to card, "onTouchstart" to fun(`$event`: Any){
                    touchstart(`$event` as TouchEvent)
                }
                , "onTouchmove" to fun(`$event`: Any){
                    touchmove(`$event` as TouchEvent)
                }
                , "onTouchend" to touchend, "onTouchcancel" to touchend), _uA(
                    _cE("image", _uM("class" to "card-img", "ref_key" to "cardImg", "ref" to cardImg, "src" to _ctx.img), null, 8, _uA(
                        "src"
                    )),
                    _cE("view", _uM("class" to "state"), _uA(
                        _cE("image", _uM("class" to "state-icon like", "ref_key" to "stateIconLike", "ref" to stateIconLike, "src" to "/static/template/drop-card/like.png", "mode" to "widthFix"), null, 512),
                        _cE("image", _uM("class" to "state-icon dislike", "ref_key" to "stateIconDislike", "ref" to stateIconDislike, "src" to "/static/dislike.png", "mode" to "widthFix"), null, 512)
                    ))
                ), 40, _uA(
                    "onTouchstart",
                    "onTouchmove"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("card" to _pS(_uM("width" to "95%", "height" to 0, "position" to "absolute", "top" to 0, "marginTop" to 50, "marginRight" to 12, "marginBottom" to 0, "marginLeft" to 12, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "boxShadow" to "0 0 5px rgba(0, 0, 0, 0.1)", "backgroundColor" to "#FFFFFF", "transitionProperty" to "marginTop", "transitionDuration" to "300ms", "transitionTimingFunction" to "ease-in")), "card-img" to _pS(_uM("width" to "100%", "height" to 0, "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10)), "state" to _pS(_uM("top" to 10, "left" to 10, "width" to "86%", "paddingTop" to 4, "paddingRight" to 4, "paddingBottom" to 4, "paddingLeft" to 4, "position" to "absolute", "flexDirection" to "row", "justifyContent" to "space-between")), "state-icon" to _pS(_uM("width" to 30, "height" to 30, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#FFFFFF", "borderRightColor" to "#FFFFFF", "borderBottomColor" to "#FFFFFF", "borderLeftColor" to "#FFFFFF", "backgroundColor" to "#FFFFFF", "paddingTop" to 3, "paddingRight" to 3, "paddingBottom" to 3, "paddingLeft" to 3, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "boxShadow" to "0 0 1px #EBEBEB", "opacity" to 0)), "@TRANSITION" to _uM("card" to _uM("property" to "marginTop", "duration" to "300ms", "timingFunction" to "ease-in")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("img" to _uM("type" to "String", "default" to "https://web-ext-storage.dcloud.net.cn/hello-uni-app-x/drop-card-1.jpg"), "cardIndex" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "img",
            "cardIndex"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
