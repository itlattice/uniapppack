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
open class GenPagesCSSBoxShadowBoxShadow : BasePage {
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
    open var radioChangeBoxShadow: (index: Number) -> Unit
        get() {
            return unref(this.`$exposed`["radioChangeBoxShadow"]) as (index: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "radioChangeBoxShadow", value)
        }
    open var data: UTSJSONObject
        get() {
            return unref(this.`$exposed`["data"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSBoxShadowBoxShadow, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSBoxShadowBoxShadow
            val _cache = __ins.renderCache
            val data = reactive(_uO("boxShadow" to "5px 5px black", "boxShadowActual" to "", "boxShadowActualText" to "", "boxShadowActualImage" to "", "boxShadowActualFlat" to "", "boxShadowActualTextFlat" to "", "boxShadowActualImageFlat" to ""))
            val disabled = ref(false)
            val changed = fun(){
                disabled.value = disabled.value == false
            }
            val viewRef = ref(null as UniElement?)
            val textRef = ref(null as UniTextElement?)
            val imageRef = ref(null as UniImageElement?)
            val viewRefFlat = ref(null as UniElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val imageRefFlat = ref(null as UniImageElement?)
            val boxShadowEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "none"),
                ItemType(value = 2, name = "5px 5px black"),
                ItemType(value = 3, name = "5px 5px 5px black"),
                ItemType(value = 4, name = "10px 10px 10px red"),
                ItemType(value = 5, name = "5px 5px 5px 5px black"),
                ItemType(value = 6, name = "-5px -5px 5px black"),
                ItemType(value = 7, name = "0px 1px 3px rgba(0,0,0,0.4)")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(value: String){
                data["boxShadowActual"] = viewRef.value?.style?.getPropertyValue("box-shadow") ?: ""
                if (!value.includes("inset")) {
                    data["boxShadowActualFlat"] = viewRefFlat.value?.style?.getPropertyValue("box-shadow") ?: ""
                } else {
                    data["boxShadowActualFlat"] = "不支持 inset"
                }
                data["boxShadowActualText"] = textRef.value?.style?.getPropertyValue("box-shadow") ?: ""
                if (!value.includes("inset")) {
                    data["boxShadowActualTextFlat"] = textRefFlat.value?.style?.getPropertyValue("box-shadow") ?: ""
                } else {
                    data["boxShadowActualTextFlat"] = "不支持 inset"
                }
                data["boxShadowActualImage"] = imageRef.value?.style?.getPropertyValue("box-shadow") ?: ""
                if (!value.includes("inset")) {
                    data["boxShadowActualImageFlat"] = imageRefFlat.value?.style?.getPropertyValue("box-shadow") ?: ""
                } else {
                    data["boxShadowActualImageFlat"] = "不支持 inset"
                }
            }
            val changeBoxShadow = fun(value: String){
                data["boxShadow"] = value
                viewRef.value?.style?.setProperty("box-shadow", value)
                if (!value.includes("inset")) {
                    viewRefFlat.value?.style?.setProperty("box-shadow", value)
                }
                textRef.value?.style?.setProperty("box-shadow", value)
                if (!value.includes("inset")) {
                    textRefFlat.value?.style?.setProperty("box-shadow", value)
                }
                imageRef.value?.style?.setProperty("box-shadow", value)
                if (!value.includes("inset")) {
                    imageRefFlat.value?.style?.setProperty("box-shadow", value)
                }
                nextTick(fun(){
                    getPropertyValues(value)
                }
                )
            }
            val radioChangeBoxShadow = fun(index: Number){
                val selectedItem = boxShadowEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeBoxShadow(selectedItem.name)
                }
            }
            val inputChangeBoxShadow = fun(value: String){
                changeBoxShadow(value)
            }
            val showFlatSection = fun(): Boolean {
                return (data["boxShadow"] as String).includes("inset") == false
            }
            onReady(fun(){
                nextTick(fun(){
                    val element = uni_getElementById("dynamic-height-textarea")
                    element?.style?.setProperty("height", "26px")
                }
                )
                getPropertyValues(data["boxShadow"] as String)
            }
            )
            __expose(_uM("radioChangeBoxShadow" to radioChangeBoxShadow, "data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("style" to _nS(_uM("flex-grow" to "1"))), _uA(
                        _cE("view", _uM("style" to _nS(_uM("margin-bottom" to "10px"))), _uA(
                            _cE("text", _uM("style" to _nS(_uM("font-weight" to "bold"))), "说明：左边是正常版本，右边是拍平版本", 4)
                        ), 4),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 5px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 5px 5px 5px #00FF00"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px #00FF00"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px #00FF00")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 5px 5px 5px rgb(0,0,255)"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 5px 5px rgb(0,0,255)"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 5px 5px rgb(0,0,255)")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 5px 5px 5px rgba(0,255,255,0.5)"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px rgba(0,255,255,0.5)"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px rgba(0,255,255,0.5)")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5)"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 5px 5px rgba(0, 0, 0, 0.5)"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 5px 5px rgba(0, 0, 0, 0.5)")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 5px 5px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 5px 10px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 10px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 10px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 5px 5px 5px 5px black（harmony暂不支持阴影扩散半径）"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: -5px -5px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "-5px -5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "-5px -5px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: inset 5px 5px black（harmony暂不支持inset）"),
                            _cE("view", _uM("class" to "backgroundview"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "inset 5px 5px black"))), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: inset 5px 5px 5px black（harmony暂不支持inset）"),
                            _cE("view", _uM("class" to "backgroundview"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "inset 5px 5px 5px black"))), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: inset 5px 10px 5px black（harmony暂不支持inset）"),
                            _cE("view", _uM("class" to "backgroundview"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "inset 5px 10px 5px black"))), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: inset 5px 5px 5px 5px black（harmony暂不支持inset）"),
                            _cE("view", _uM("class" to "backgroundview"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "inset 5px 5px 5px 5px black"))), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: inset -5px -5px 5px black（harmony暂不支持inset）"),
                            _cE("view", _uM("class" to "backgroundview"), _uA(
                                _cE("view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "inset -5px -5px 5px black"))), null, 4)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow: 0px 1px 3px rgba(0,0,0,0.4)"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "0px 1px 3px rgba(0, 0, 0, 0.4)"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("box-shadow" to "0px 1px 3px rgba(0, 0, 0, 0.4)")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "circle: box-shadow: 5px 5px black（正圆）"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "5px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "circle: box-shadow: 5px 5px 5px black（椭圆）"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("border-radius" to "24px", "box-shadow" to "5px 5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("border-radius" to "24px", "box-shadow" to "5px 5px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "circle: box-shadow: 5px 10px 5px black（正圆）"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "5px 10px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "5px 10px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "circle: box-shadow: 5px 5px 5px 5px black（椭圆）"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("border-radius" to "24px", "box-shadow" to "5px 5px 5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("border-radius" to "24px", "box-shadow" to "5px 5px 5px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "circle: box-shadow: -5px -5px 5px black（正圆）"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "-5px -5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("class" to "common", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "-5px -5px 5px black")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "circle: box-shadow: 0px 1px 3px rgba(0,0,0,0.4)（椭圆）"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("border-radius" to "24px", "box-shadow" to "0px 1px 3px rgba(0, 0, 0, 0.4)"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("view", _uM("class" to "common-rect", "style" to _nS(_uM("border-radius" to "24px", "box-shadow" to "0px 1px 3px rgba(0, 0, 0, 0.4)")), "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "点击动态切换 box-shadow: none"),
                            _cE("view", _uM("class" to "backgroundview", "onClick" to changed), _uA(
                                _cE("view", _uM("class" to _nC(_uA(
                                    "common",
                                    if (unref(disabled)) {
                                        "disabledShadow"
                                    } else {
                                        "shadow"
                                    }
                                ))), null, 2)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "点击动态切换 box-shadow: 非法值"),
                            _cE("view", _uM("class" to "backgroundview", "onClick" to changed), _uA(
                                _cE("view", _uM("class" to _nC(_uA(
                                    "common",
                                    if (unref(disabled)) {
                                        "invalidShadow"
                                    } else {
                                        "shadow"
                                    }
                                ))), null, 2)
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "box-shadow父视图动态改变高度的渲染效果"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("justify-content" to "center", "align-items" to "center", "width" to "75px", "background-color" to "green", "box-shadow" to "0 0 10px"))), _uA(
                                            _cE("view", null, _uA(
                                                _cE("textarea", _uM("id" to "dynamic-height-textarea", "style" to _nS(_uM("margin" to "10px", "background-color" to "aqua", "height" to "16px", "width" to "55px")), "value" to "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), null, 4)
                                            ))
                                        ), 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("view", _uM("style" to _nS(_uM("justify-content" to "center", "align-items" to "center", "width" to "75px", "background-color" to "green", "box-shadow" to "0 0 10px")), "flatten" to ""), _uA(
                                            _cE("view", null, _uA(
                                                _cE("textarea", _uM("id" to "dynamic-height-textarea-flat", "style" to _nS(_uM("margin" to "10px", "background-color" to "aqua", "height" to "16px", "width" to "55px")), "value" to "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), null, 4)
                                            ))
                                        ), 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "text组件: box-shadow: 5px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("text", _uM("class" to "text-shadow", "style" to _nS(_uM("box-shadow" to "5px 5px black"))), "文本", 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("text", _uM("class" to "text-shadow", "style" to _nS(_uM("box-shadow" to "5px 5px black")), "flatten" to ""), "文本", 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "text组件: box-shadow: 5px 5px 5px #00FF00"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("text", _uM("class" to "text-shadow-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px #00FF00"))), "文本", 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("text", _uM("class" to "text-shadow-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px #00FF00")), "flatten" to ""), "文本", 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("style" to _nS(_uM("font-weight" to "bold", "margin-top" to "20px"))), "圆形图片", 4)
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: box-shadow: 5px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("image", _uM("class" to "image-shadow", "style" to _nS(_uM("box-shadow" to "5px 5px black")), "src" to "/static/test-image/logo.png"), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("image", _uM("class" to "image-shadow", "style" to _nS(_uM("box-shadow" to "5px 5px black")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: box-shadow: 5px 5px 5px #00FF00"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("image", _uM("class" to "image-shadow-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px #00FF00")), "src" to "/static/test-image/logo.png"), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("image", _uM("class" to "image-shadow-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px #00FF00")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件（正圆）: box-shadow: 5px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("image", _uM("class" to "image-shadow-circle", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "5px 5px black")), "src" to "/static/test-image/logo.png"), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("image", _uM("class" to "image-shadow-circle", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "5px 5px black")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", _uM("style" to _nS(_uM("font-weight" to "bold", "margin-top" to "20px"))), "方形图片", 4)
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: box-shadow: 5px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("image", _uM("class" to "image-shadow", "style" to _nS(_uM("box-shadow" to "5px 5px black")), "src" to "/static/logo_square.jpeg"), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("image", _uM("class" to "image-shadow", "style" to _nS(_uM("box-shadow" to "5px 5px black")), "src" to "/static/logo_square.jpeg", "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件: box-shadow: 5px 5px 5px #00FF00"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("image", _uM("class" to "image-shadow-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px #00FF00")), "src" to "/static/logo_square.jpeg"), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview-rect"), _uA(
                                        _cE("image", _uM("class" to "image-shadow-rect", "style" to _nS(_uM("box-shadow" to "5px 5px 5px #00FF00")), "src" to "/static/logo_square.jpeg", "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", null, _uA(
                            _cE("text", null, "image组件（正圆）: box-shadow: 5px 5px black"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("image", _uM("class" to "image-shadow-circle", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "5px 5px black")), "src" to "/static/logo_square.jpeg"), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("image", _uM("class" to "image-shadow-circle", "style" to _nS(_uM("border-radius" to "31px", "box-shadow" to "5px 5px black")), "src" to "/static/logo_square.jpeg", "flatten" to ""), null, 4)
                                    ))
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "scroll-view 组件"),
                            _cE("text", _uM("class" to "uni-subtitle-text"), "box-shadow: 5px 5px black 和 box-shadow: 0 0 10px blue")
                        )),
                        _cE("view", _uM("class" to "row-container"), _uA(
                            _cE("view", _uM("class" to "row-item"), _uA(
                                _cE("scroll-view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "box-shadow" to "5px 5px black", "background-color" to "cyan"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "row-item"), _uA(
                                _cE("scroll-view", _uM("style" to _nS(_uM("width" to "100px", "height" to "100px", "box-shadow" to "0 0 10px blue", "background-color" to "green"))), null, 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 box-shadow ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["boxShadow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["boxShadowActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRef", "ref" to viewRef, "class" to "common-dynamic test-view", "style" to _nS(_uM("boxShadow" to unref(data)["boxShadow"]))), _uA(
                                        _cE("text", _uM("class" to "common-text"), "view")
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["boxShadow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["boxShadowActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common-dynamic common-text test-text", "style" to _nS(_uM("boxShadow" to unref(data)["boxShadow"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["boxShadow"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["boxShadowActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRef", "ref" to imageRef, "class" to "common-dynamic test-image", "style" to _nS(_uM("boxShadow" to unref(data)["boxShadow"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        if (isTrue(showFlatSection())) {
                            _cE("view", _uM("key" to 0, "class" to "test-container"), _uA(
                                _cE("view", _uM("class" to "test-item"), _uA(
                                    _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                    _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["boxShadow"]), 1),
                                    _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["boxShadowActualFlat"]), 1),
                                    _cE("view", _uM("class" to "test-box"), _uA(
                                        _cE("view", _uM("ref_key" to "viewRefFlat", "ref" to viewRefFlat, "class" to "common-dynamic test-view-flatten", "style" to _nS(_uM("boxShadow" to unref(data)["boxShadow"])), "flatten" to ""), _uA(
                                            _cE("text", _uM("class" to "common-text"), "view")
                                        ), 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "test-item"), _uA(
                                    _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                    _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["boxShadow"]), 1),
                                    _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["boxShadowActualTextFlat"]), 1),
                                    _cE("view", _uM("class" to "test-box"), _uA(
                                        _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common-dynamic common-text test-text-flatten", "style" to _nS(_uM("boxShadow" to unref(data)["boxShadow"])), "flatten" to ""), "text", 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "test-item"), _uA(
                                    _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                    _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["boxShadow"]), 1),
                                    _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["boxShadowActualImageFlat"]), 1),
                                    _cE("view", _uM("class" to "test-box"), _uA(
                                        _cE("image", _uM("ref_key" to "imageRefFlat", "ref" to imageRefFlat, "class" to "common-dynamic test-image-flatten", "style" to _nS(_uM("boxShadow" to unref(data)["boxShadow"])), "flatten" to "", "src" to "/static/test-image/logo.png"), null, 4)
                                    ))
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("compact" to true, "items" to boxShadowEnum, "title" to "box-shadow 枚举值", "onChange" to radioChangeBoxShadow)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["boxShadow"], "title" to "box-shadow 自定义值", "type" to "text", "onConfirm" to inputChangeBoxShadow), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mb"), _uA(
                            _cE("text", null, "native-view组件: box-shadow: 5px 5px black 和 box-shadow: 0 0 10px blue"),
                            _cE("view", _uM("class" to "row-container"), _uA(
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "5px 5px black"))), null, 4)
                                    ))
                                )),
                                _cE("view", _uM("class" to "row-item"), _uA(
                                    _cE("view", _uM("class" to "backgroundview"), _uA(
                                        _cE("native-view", _uM("class" to "common", "style" to _nS(_uM("box-shadow" to "0 0 10px blue"))), null, 4)
                                    ))
                                ))
                            ))
                        ))
                    ), 4)
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
                return _uM("common" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#A52A2A")), "common-rect" to _pS(_uM("width" to 48, "height" to 24, "backgroundColor" to "#A52A2A")), "backgroundview" to _pS(_uM("width" to 75, "height" to 75, "backgroundColor" to "#FFFFFF", "justifyContent" to "center", "alignItems" to "center")), "backgroundview-rect" to _pS(_uM("width" to 75, "height" to 50, "backgroundColor" to "#FFFFFF", "justifyContent" to "center", "alignItems" to "center")), "row-container" to _pS(_uM("flexDirection" to "row", "alignItems" to "flex-start", "marginBottom" to 10)), "row-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginRight" to 10)), "big" to _pS(_uM("width" to 200, "height" to 200)), "shadow" to _pS(_uM("boxShadow" to "5px 5px black")), "disabledShadow" to _pS(_uM("boxShadow" to "none")), "invalidShadow" to _pS(_uM("boxShadow" to "abcd")), "text-shadow" to _pS(_uM("width" to 62, "height" to 62, "backgroundColor" to "#A52A2A", "fontSize" to 12, "color" to "#FFFFFF")), "text-shadow-rect" to _pS(_uM("width" to 62, "height" to 31, "backgroundColor" to "#A52A2A", "fontSize" to 12, "color" to "#FFFFFF")), "image-shadow" to _pS(_uM("width" to 62, "height" to 62, "backgroundColor" to "#A52A2A")), "image-shadow-rect" to _pS(_uM("width" to 62, "height" to 31, "backgroundColor" to "#A52A2A")), "image-shadow-circle" to _pS(_uM("width" to 62, "height" to 62, "backgroundColor" to "#A52A2A")), "image-shadow-ellipse" to _pS(_uM("width" to 62, "height" to 40, "backgroundColor" to "#A52A2A")), "test-container" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "100%", "height" to 80, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "backgroundColor" to "#808080")), "common-dynamic" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000")), "common-text" to _pS(_uM("fontSize" to 10, "color" to "#FFFFFF")), "scroll-view-label" to _pS(_uM("fontSize" to 12, "lineHeight" to "100px", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
