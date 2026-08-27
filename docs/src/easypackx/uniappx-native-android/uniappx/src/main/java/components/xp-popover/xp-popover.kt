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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenComponentsXpPopoverXpPopover : VueComponent, PopoverProps {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    override var closeOnClickOutside: Boolean by `$props`
    override var content: String? by `$props`
    override var placement: String by `$props`
    override var showArrow: Boolean by `$props`
    override var theme: String by `$props`
    override var visible: Boolean? by `$props`
    override var color: String? by `$props`
    override var disabled: Boolean by `$props`
    override var menus: UTSArray<UTSJSONObject> by `$props`
    open var modelValue: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXpPopoverXpPopover, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXpPopoverXpPopover
            val _cache = __ins.renderCache
            val props = __props
            val instance = getCurrentInstance()!!
            pushToQueue(instance.proxy!!)
            val innerPlacement = ref(props.placement)
            val referenceRef = ref<UniElement?>(null)
            val popoverRef = ref<UniElement?>(null)
            val targetRef = ref<UniElement?>(null)
            val zIndex = ref(2)
            val popoverStyle = reactive(_uO())
            val popoverState = ref("")
            val modelValue = useModel<Boolean>(__ins.props, "modelValue")
            val currentVisible = computed(WritableComputedOptions(set = fun(v: Boolean) {
                modelValue.value = v
            }
            , get = fun(): Boolean {
                return props.visible ?: modelValue.value
            }
            ))
            val styles = computed(fun(): Map<String, Any> {
                val style = Map<String, Any>()
                return style
            }
            )
            val contentStyles = computed(fun(): Map<String, Any> {
                val style = Map<String, Any>()
                if (!_uA(
                    "light",
                    "dark"
                ).includes(props.theme)) {
                    style.set("background", props.theme)
                }
                return style
            }
            )
            val textStyles = computed(fun(): Map<String, Any> {
                val style = Map<String, Any>()
                if (!_uA(
                    "light",
                    "dark"
                ).includes(props.theme)) {
                    style.set("color", props.color ?: "white")
                }
                return style
            }
            )
            val arrowStyles = computed(fun(): Map<String, Any> {
                val style = Map<String, Any>()
                if (!_uA(
                    "light",
                    "dark"
                ).includes(props.theme)) {
                    if (innerPlacement.value.startsWith("top")) {
                        style.set("border-top-color", props.theme)
                    } else if (innerPlacement.value.startsWith("bottom")) {
                        style.set("border-bottom-color", props.theme)
                    } else if (innerPlacement.value.startsWith("left")) {
                        style.set("border-left-color", props.theme)
                    } else if (innerPlacement.value.startsWith("right")) {
                        style.set("border-right-color", props.theme)
                    }
                }
                return style
            }
            )
            val updatePosition = fun(updateWidth: Boolean): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        val windowWidth = uni_getWindowInfo().windowWidth
                        val target = (targetRef.value ?: referenceRef.value) as UniElement?
                        if (target == null || popoverRef.value == null) {
                            return@w1
                        }
                        val popoverRect = await(popoverRef.value!!.getBoundingClientRectAsync()) as DOMRect?
                        val referenceRect = await(target.getBoundingClientRectAsync()) as DOMRect?
                        val referenceTop = referenceRect?.top ?: 0
                        val referenceLeft = referenceRect?.left ?: 0
                        val referenceRight = referenceRect?.right ?: 0
                        val referenceBottom = referenceRect?.bottom ?: 0
                        val referenceHeight = referenceRect?.height ?: 0
                        val referenceWidth = referenceRect?.width ?: 0
                        val popoverTop = popoverRect?.top ?: 0
                        val popoverLeft = popoverRect?.left ?: 0
                        val popoverRight = popoverRect?.right ?: 0
                        val popoverBottom = popoverRect?.bottom ?: 0
                        val popoverHeight = popoverRect?.height ?: 0
                        val popoverWidth = popoverRect?.width ?: 0
                        val availableLeft = referenceLeft - 8
                        val availableRight = windowWidth - 8 - referenceRight
                        val _calculateWidthAndAdjustPlacement = calculateWidthAndAdjustPlacement__1(props.placement, availableLeft, availableRight, popoverRect?.width ?: 0)
                        val placement = _calculateWidthAndAdjustPlacement.placement
                        val finalWidth = _calculateWidthAndAdjustPlacement.finalWidth
                        if (innerPlacement.value != placement) {
                            innerPlacement.value = placement
                        }
                        if (placement == "top") {
                            popoverRef.value!!.style.setProperty("top", "" + (referenceTop - popoverHeight) + "px")
                            popoverRef.value!!.style.setProperty("left", "" + (referenceLeft - finalWidth / 2 + referenceWidth / 2) + "px")
                        } else if (placement == "top-left") {
                            popoverRef.value!!.style.setProperty("top", "" + (referenceTop - popoverHeight) + "px")
                            popoverRef.value!!.style.setProperty("left", "" + referenceLeft + "px")
                        } else if (placement == "top-right") {
                            popoverRef.value!!.style.setProperty("top", "" + (referenceTop - popoverHeight) + "px")
                            popoverRef.value!!.style.setProperty("right", "" + (windowWidth - referenceRight) + "px")
                        } else if (placement == "bottom") {
                            popoverRef.value!!.style.setProperty("top", "" + referenceBottom + "px")
                            popoverRef.value!!.style.setProperty("left", "" + (referenceLeft - finalWidth / 2 + referenceWidth / 2) + "px")
                        } else if (placement == "bottom-left") {
                            popoverRef.value!!.style.setProperty("top", "" + referenceBottom + "px")
                            popoverRef.value!!.style.setProperty("left", "" + referenceLeft + "px")
                        } else if (placement == "bottom-right") {
                            popoverRef.value!!.style.setProperty("top", "" + referenceBottom + "px")
                            popoverRef.value!!.style.setProperty("right", "" + (windowWidth - referenceRight) + "px")
                        } else if (placement == "right") {
                            popoverRef.value!!.style.setProperty("left", "" + referenceRight + "px")
                            popoverRef.value!!.style.setProperty("top", "" + (referenceTop + referenceHeight / 2) + "px")
                            popoverRef.value!!.style.setProperty("transform", "translateY(-50%)")
                        } else if (placement == "right-top") {
                            popoverRef.value!!.style.setProperty("top", "" + referenceTop + "px")
                            popoverRef.value!!.style.setProperty("left", "" + referenceRight + "px")
                        } else if (placement == "right-bottom") {
                            popoverRef.value!!.style.setProperty("left", "" + referenceRight + "px")
                            popoverRef.value!!.style.setProperty("top", "" + (referenceTop + referenceHeight) + "px")
                            popoverRef.value!!.style.setProperty("transform", "translateY(-100%)")
                        } else if (placement == "left") {
                            popoverRef.value!!.style.setProperty("top", "" + (referenceTop + referenceHeight / 2) + "px")
                            popoverRef.value!!.style.setProperty("right", "" + (windowWidth - referenceLeft) + "px")
                            popoverRef.value!!.style.setProperty("transform", "translateY(-50%)")
                        } else if (placement == "left-top") {
                            popoverRef.value!!.style.setProperty("top", "" + referenceTop + "px")
                            popoverRef.value!!.style.setProperty("right", "" + (windowWidth - referenceLeft) + "px")
                        } else if (placement == "left-bottom") {
                            popoverRef.value!!.style.setProperty("top", "" + (referenceTop + referenceHeight) + "px")
                            popoverRef.value!!.style.setProperty("right", "" + (windowWidth - referenceLeft) + "px")
                            popoverRef.value!!.style.setProperty("transform", "translateY(-100%)")
                        }
                        if (!updateWidth) {
                            return@w1
                        }
                        popoverRef.value!!.style.setProperty("width", finalWidth + "px")
                })
            }
            val display = ref(false)
            val classes = ref("")
            val close = fun(){
                currentVisible.value = false
                setTimeout(fun(){
                    zIndex.value = 2
                }
                , 100)
            }
            var markTime = Date.now()
            var clickTimer: Number = -1
            val outsideClick = fun(e: UniPointerEvent){
                if (!props.closeOnClickOutside || !currentVisible.value) {
                    return
                }
                clearTimeout(clickTimer)
                clickTimer = setTimeout(fun(){
                    close()
                }
                , 100)
            }
            val handleClick = fun(e: UniPointerEvent){
                if (Date.now() - markTime < 200 || props.disabled) {
                    return
                }
                e.stopPropagation()
                closeOther(instance.proxy!!)
                currentVisible.value = !currentVisible.value
                if (!currentVisible.value) {
                    return
                }
                zIndex.value = 3
            }
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val clickMenu = fun(index: Number){
                console.log("点击了菜单", index, props.menus[index])
                emit("clickMenu", props.menus[index] as UTSJSONObject)
            }
            onPageScroll(fun(_e: OnPageScrollOptions){
                if (!currentVisible.value) {
                    return
                }
                updatePosition(false)
            }
            )
            __expose(_uM("close" to close))
            var pageElementCallbackWrapper: UniCallbackWrapper? = null
            var pageElement: UniElement? = null
            var targetCallbackWrapper: UniCallbackWrapper? = null
            var uniAnimation: UniAnimation? = null
            val enterKeyframes = _uA<UTSJSONObject>(_uO("opacity" to 0), _uO("opacity" to 1))
            val leaveKeyframes = _uA<UTSJSONObject>(_uO("opacity" to 1), _uO("opacity" to 0))
            var enterTimer: Number = -1
            val createAnimation = fun(isEnter: Boolean){
                uniAnimation?.cancel()
                var transform = ""
                var transformOrigin = transformOriginMap__1.get(innerPlacement.value)
                if (!appTransformMap__1.has(innerPlacement.value)) {
                    if (isEnter) {
                        enterKeyframes[0].set("transformOrigin", transformOrigin)
                        enterKeyframes[1].set("transformOrigin", transformOrigin)
                        enterKeyframes[0].set("transform", "" + transform + "scale(0.4)")
                        enterKeyframes[1].set("transform", "" + transform + "scale(1)")
                    } else {
                        leaveKeyframes[0].set("transformOrigin", transformOrigin)
                        leaveKeyframes[1].set("transformOrigin", transformOrigin)
                        leaveKeyframes[0].set("transform", "" + transform + "scale(1)")
                        leaveKeyframes[1].set("transform", "" + transform + "scale(0.4)")
                    }
                }
                val keyframes = if (isEnter) {
                    enterKeyframes
                } else {
                    leaveKeyframes
                }
                uniAnimation = popoverRef.value?.animate(keyframes, UniAnimationOption(duration = 150, easing = "ease", fill = "forwards"))
                uniAnimation!!.onfinish = fun(e: UniAnimationPlaybackEvent){
                    if (!isEnter) {
                        display.value = false
                    }
                }
            }
            watch(currentVisible, fun(v: Boolean){
                uniAnimation?.cancel()
                clearTimeout(enterTimer)
                if (v) {
                    display.value = true
                    nextTick(fun(){
                        uniAnimation?.cancel()
                        requestAnimationFrame(fun(_task){
                            popoverRef.value?.getBoundingClientRectAsync()?.then(fun(res){
                                nextTick(fun(){
                                    updatePosition(v).then(fun(){
                                        createAnimation(v)
                                    })
                                })
                            })
                        })
                    })
                } else {
                    createAnimation(v)
                }
            }
            )
            onMounted(fun(){
                nextTick(fun(){
                    pageElement = findPageElement__1(instance.proxy!!.`$el`)
                    if (pageElement != null) {
                        pageElementCallbackWrapper = pageElement!!.addEventListener("click", outsideClick)
                    }
                    if (referenceRef.value == null) {
                        return
                    }
                    run {
                        var i: Number = 0
                        while(i < referenceRef.value!!.children.length){
                            val el = referenceRef.value!!.children[i]
                            if (!_uA(
                                "#text",
                                "#comment"
                            ).includes(el.nodeName)) {
                                targetRef.value = el
                                break
                            }
                            i++
                        }
                    }
                    if (targetRef.value == null) {
                        return
                    }
                    targetCallbackWrapper = targetRef.value!!.addEventListener("click", handleClick)
                }
                )
            }
            )
            onBeforeUnmount(fun(){
                clearTimeout(clickTimer!!)
                close()
                if (pageElement == null || pageElementCallbackWrapper == null) {
                    return
                }
                pageElement!!.removeEventListener("click", pageElementCallbackWrapper!!)
                pageElementCallbackWrapper = null
                if (targetRef.value != null || targetCallbackWrapper != null) {
                    targetRef.value!!.removeEventListener("touchstart", targetCallbackWrapper!!)
                }
                removeFromQueue(instance.proxy!!)
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to "l-popover__wrapper", "ref_key" to "referenceRef", "ref" to referenceRef), _uA(
                    renderSlot(_ctx.`$slots`, "default"),
                    if (isTrue(unref(display))) {
                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                            "l-popover",
                            _uA(
                                "l-popover--" + unref(innerPlacement),
                                "l-popover--" + _ctx.theme,
                                unref(classes)
                            )
                        )), "style" to _nS(_uA(
                            unref(popoverStyle),
                            unref(styles)
                        )), "ref_key" to "popoverRef", "ref" to popoverRef), _uA(
                            if (isTrue(_ctx.showArrow)) {
                                _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                    "l-popover__arrow",
                                    _uA(
                                        "l-popover__arrow--" + unref(innerPlacement)
                                    )
                                )), "style" to _nS(_uA(
                                    unref(arrowStyles)
                                ))), null, 6)
                            } else {
                                _cC("v-if", true)
                            },
                            _cE("view", _uM("class" to _nC(_uA(
                                "l-popover__content",
                                _uA(
                                    "l-popover__content--" + unref(innerPlacement)
                                )
                            )), "style" to _nS(_uA(
                                unref(contentStyles)
                            ))), _uA(
                                _cE("view", _uM("class" to "xmenulist"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(_ctx.menus, fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "xmenu", "key" to index, "style" to _nS(_uM("borderBottom" to if ((index + 1 == _ctx.menus.length)) {
                                            "0px solid #ccc"
                                        } else {
                                            "1px solid #ccc"
                                        })), "onClick" to fun(){
                                            clickMenu(index)
                                        }), _uA(
                                            _cE("text", _uM("class" to "xcontent"), _tD(item["name"]), 1)
                                        ), 12, _uA(
                                            "onClick"
                                        ))
                                    }), 128)
                                ))
                            ), 6)
                        ), 6)
                    } else {
                        _cC("v-if", true)
                    }
                ), 512)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("l-popover" to _pS(_uM("zIndex" to 1500, "position" to "fixed", "overflow" to "visible", "maxWidth" to "650rpx", "opacity" to 0)), "l-popover__mark" to _pS(_uM("position" to "fixed", "width" to "100%", "height" to "100%", "top" to 0, "left" to 0, "zIndex" to 1)), "l-popover__slot" to _pS(_uM("alignSelf" to "flex-start")), "l-popover__wrapper" to _pS(_uM("position" to "relative", "overflow" to "visible")), "l-popover__text" to _uM("" to _uM("fontSize" to 14, "lineHeight" to "24px"), ".l-popover--dark " to _uM("color" to "#ffffff"), ".l-popover--light " to _uM("color" to "#000000E0")), "l-popover__content" to _uM("" to _uM("overflow" to "visible", "position" to "relative", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6, "boxShadow" to "0 0 25px rgba(0, 0, 0, 0.1)"), ".l-popover--dark " to _uM("backgroundColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("backgroundColor" to "#ffffff")), "l-popover__content--top" to _pS(_uM("marginTop" to 0, "marginRight" to 0, "marginBottom" to 8, "marginLeft" to 0)), "l-popover__content--top-left" to _pS(_uM("marginTop" to 0, "marginRight" to 0, "marginBottom" to 8, "marginLeft" to 0)), "l-popover__content--top-right" to _pS(_uM("marginTop" to 0, "marginRight" to 0, "marginBottom" to 8, "marginLeft" to 0)), "l-popover__content--bottom" to _pS(_uM("marginTop" to 8, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 0)), "l-popover__content--bottom-left" to _pS(_uM("marginTop" to 8, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 0)), "l-popover__content--bottom-right" to _pS(_uM("marginTop" to 8, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 0)), "l-popover__content--left" to _pS(_uM("marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 0)), "l-popover__content--left-top" to _pS(_uM("marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 0)), "l-popover__content--left-bottom" to _pS(_uM("marginTop" to 0, "marginRight" to 8, "marginBottom" to 0, "marginLeft" to 0)), "l-popover__content--right" to _pS(_uM("marginTop" to 0, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 8)), "l-popover__content--right-top" to _pS(_uM("marginTop" to 0, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 8)), "l-popover__content--right-bottom" to _pS(_uM("marginTop" to 0, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 8)), "l-popover__arrow" to _pS(_uM("position" to "absolute", "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopWidth" to 8, "borderRightWidth" to 8, "borderBottomWidth" to 8, "borderLeftWidth" to 8, "zIndex" to 1)), "l-popover__arrow--top" to _uM("" to _uM("bottom" to 0, "left" to "50%", "transform" to "translateX(-50%)", "borderTopColor" to "#FF0000", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderTopWidth" to 8, "borderRightWidth" to 8, "borderLeftWidth" to 8, "borderBottomWidth" to 0), ".l-popover--dark " to _uM("borderTopColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderTopColor" to "#ffffff")), "l-popover__arrow--top-left" to _uM("" to _uM("bottom" to 0, "left" to 12, "borderTopColor" to "#FF0000", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderTopWidth" to 8, "borderRightWidth" to 8, "borderLeftWidth" to 8, "borderBottomWidth" to 0), ".l-popover--dark " to _uM("borderTopColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderTopColor" to "#ffffff")), "l-popover__arrow--top-right" to _uM("" to _uM("bottom" to 0, "right" to 12, "borderTopColor" to "#FF0000", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderTopWidth" to 8, "borderRightWidth" to 8, "borderLeftWidth" to 8, "borderBottomWidth" to 0), ".l-popover--dark " to _uM("borderTopColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderTopColor" to "#ffffff")), "l-popover__arrow--bottom" to _uM("" to _uM("top" to 0, "left" to "50%", "transform" to "translate(-50%, 0)", "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderRightWidth" to 8, "borderLeftWidth" to 8, "borderTopWidth" to 0), ".l-popover--dark " to _uM("borderBottomColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderBottomColor" to "#ffffff")), "l-popover__arrow--bottom-left" to _uM("" to _uM("top" to 0, "left" to 12, "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderRightWidth" to 8, "borderLeftWidth" to 8, "borderTopWidth" to 0), ".l-popover--dark " to _uM("borderBottomColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderBottomColor" to "#ffffff")), "l-popover__arrow--bottom-right" to _uM("" to _uM("top" to 0, "right" to 12, "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderRightWidth" to 8, "borderLeftWidth" to 8, "borderTopWidth" to 0), ".l-popover--dark " to _uM("borderBottomColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderBottomColor" to "#ffffff")), "l-popover__arrow--left" to _uM("" to _uM("top" to "50%", "right" to 0, "transform" to "translateY(-50%)", "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderTopWidth" to 8, "borderLeftWidth" to 8, "borderRightWidth" to 0), ".l-popover--dark " to _uM("borderLeftColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderLeftColor" to "#ffffff")), "l-popover__arrow--left-top" to _uM("" to _uM("top" to 12, "right" to 0, "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderTopWidth" to 8, "borderLeftWidth" to 8, "borderRightWidth" to 0), ".l-popover--dark " to _uM("borderLeftColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderLeftColor" to "#ffffff")), "l-popover__arrow--left-bottom" to _uM("" to _uM("bottom" to 12, "right" to 0, "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderTopWidth" to 8, "borderLeftWidth" to 8, "borderRightWidth" to 0), ".l-popover--dark " to _uM("borderLeftColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderLeftColor" to "#ffffff")), "l-popover__arrow--right" to _uM("" to _uM("top" to "50%", "left" to 0, "transform" to "translateY(-50%)", "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderRightWidth" to 8, "borderTopWidth" to 8, "borderLeftWidth" to 0), ".l-popover--dark " to _uM("borderRightColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderRightColor" to "#ffffff")), "l-popover__arrow--right-top" to _uM("" to _uM("top" to 12, "left" to 0, "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderRightWidth" to 8, "borderTopWidth" to 8, "borderLeftWidth" to 0), ".l-popover--dark " to _uM("borderRightColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderRightColor" to "#ffffff")), "l-popover__arrow--right-bottom" to _uM("" to _uM("bottom" to 12, "left" to 0, "borderTopColor" to "rgba(0,0,0,0)", "borderRightColor" to "rgba(0,0,0,0)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "borderBottomWidth" to 8, "borderRightWidth" to 8, "borderTopWidth" to 8, "borderLeftWidth" to 0), ".l-popover--dark " to _uM("borderRightColor" to "rgba(0,0,0,0.85)"), ".l-popover--light " to _uM("borderRightColor" to "#ffffff")), "l-popover--top" to _pS(_uM("transformOrigin" to "50% 100%")), "l-popover--top-left" to _pS(_uM("transformOrigin" to "0 100%")), "l-popover--top-right" to _pS(_uM("transformOrigin" to "100% 100%")), "l-popover--bottom" to _pS(_uM("transformOrigin" to "50% 0%")), "l-popover--bottom-left" to _pS(_uM("transformOrigin" to "0% 0%")), "l-popover--bottom-right" to _pS(_uM("transformOrigin" to "100% 0")), "l-popover--left" to _pS(_uM("transformOrigin" to "100% 50%", "transform" to "translate(-100%, -50%)")), "l-popover--left-top" to _pS(_uM("transformOrigin" to "100% 0")), "l-popover--left-bottom" to _pS(_uM("transformOrigin" to "100% 100%")), "l-popover--right" to _pS(_uM("transformOrigin" to "0 50%")), "l-popover--right-top" to _pS(_uM("transformOrigin" to "0 0")), "l-popover--right-bottom" to _pS(_uM("transformOrigin" to "0 100%")), "l-popover-animation-enter" to _pS(_uM("opacity" to 0, "visibility" to "hidden")), "l-popover-animation-enter-from" to _pS(_uM("opacity" to 0, "visibility" to "hidden")), "l-popover-animation-exiting" to _pS(_uM("opacity" to 0, "visibility" to "hidden")), "l-popover-animation-leave-to" to _pS(_uM("opacity" to 0, "visibility" to "hidden")), "l-popover-animation-enter-to" to _pS(_uM("opacity" to 1, "visibility" to "visible")), "l-popover-animation-entering" to _pS(_uM("opacity" to 1, "visibility" to "visible")), "l-popover-animation-leave-from" to _pS(_uM("opacity" to 1, "visibility" to "visible")), "l-popover-animation-leave" to _pS(_uM("opacity" to 1, "visibility" to "visible")), "l-popover-animation-enter-active" to _pS(_uM("transitionProperty" to "opacity", "transitionDuration" to "300ms", "transitionTimingFunction" to "linear")), "l-popover-animation-leave-active" to _pS(_uM("transitionProperty" to "opacity,visibility", "transitionDuration" to "300ms", "transitionTimingFunction" to "linear")), "xmenulist" to _pS(_uM("minWidth" to "94rpx")), "xmenu" to _uM(".xmenulist " to _uM("height" to 40, "paddingLeft" to "38rpx", "paddingRight" to "38rpx", "paddingTop" to 11, "paddingBottom" to 4)), "xcontent" to _uM(".xmenulist .xmenu " to _uM("textAlign" to "center", "fontSize" to 15)), "@TRANSITION" to _uM("l-popover-animation-enter-active" to _uM("property" to "opacity", "duration" to "300ms", "timingFunction" to "linear"), "l-popover-animation-leave-active" to _uM("property" to "opacity,visibility", "duration" to "300ms", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("clickMenu" to null, "update:modelValue" to null)
        var props = _nP(_uM("closeOnClickOutside" to _uM("type" to "Boolean", "required" to true, "default" to true), "content" to _uM("type" to "String", "required" to false), "placement" to _uM("type" to "String", "required" to true, "default" to "top"), "showArrow" to _uM("type" to "Boolean", "required" to true, "default" to true), "theme" to _uM("type" to "String", "required" to true, "default" to "light"), "visible" to _uM("type" to "Boolean", "required" to false, "default" to null), "color" to _uM("type" to "String", "required" to false), "disabled" to _uM("type" to "Boolean", "required" to true, "default" to false), "menus" to _uM("type" to "Array", "required" to true, "default" to _uA<UTSJSONObject>()), "modelValue" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "closeOnClickOutside",
            "placement",
            "showArrow",
            "theme",
            "visible",
            "disabled",
            "menus",
            "modelValue"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
