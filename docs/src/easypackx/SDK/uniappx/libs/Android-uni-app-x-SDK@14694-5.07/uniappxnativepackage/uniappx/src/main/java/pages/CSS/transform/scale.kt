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
open class GenPagesCSSTransformScale : BasePage {
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
    open var data: UTSJSONObject
        get() {
            return unref(this.`$exposed`["data"]) as UTSJSONObject
        }
        set(value) {
            setRefValue(this.`$exposed`, "data", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesCSSTransformScale, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTransformScale
            val _cache = __ins.renderCache
            val data = reactive(_uO("transformValueDynamic" to "scale(1,1)", "transformActual" to "", "transformActualText" to "", "transformActualImage" to "", "transformActualFlat" to "", "transformActualTextFlat" to "", "transformActualImageFlat" to ""))
            val viewRefDynamic = ref(null as UniElement?)
            val textRefDynamic = ref(null as UniTextElement?)
            val imageRefDynamic = ref(null as UniImageElement?)
            val viewRefDynamicFlat = ref(null as UniElement?)
            val textRefDynamicFlat = ref(null as UniTextElement?)
            val imageRefDynamicFlat = ref(null as UniImageElement?)
            val transformEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "scale(1.5,1.5)"),
                ItemType(value = 2, name = "scale(0.5,0.5)"),
                ItemType(value = 3, name = "scaleX(1.5)"),
                ItemType(value = 4, name = "scaleY(1.5)"),
                ItemType(value = 5, name = "scaleX(-1)"),
                ItemType(value = 6, name = "scaleY(-1)")
            ) as UTSArray<ItemType>
            val getPropertyValues = fun(){
                data["transformActual"] = viewRefDynamic.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualFlat"] = viewRefDynamicFlat.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualText"] = textRefDynamic.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualTextFlat"] = textRefDynamicFlat.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualImage"] = imageRefDynamic.value?.style?.getPropertyValue("transform") ?: ""
                data["transformActualImageFlat"] = imageRefDynamicFlat.value?.style?.getPropertyValue("transform") ?: ""
            }
            val changeTransformDynamic = fun(value: String){
                data["transformValueDynamic"] = value
                viewRefDynamic.value?.style?.setProperty("transform", value)
                viewRefDynamicFlat.value?.style?.setProperty("transform", value)
                textRefDynamic.value?.style?.setProperty("transform", value)
                textRefDynamicFlat.value?.style?.setProperty("transform", value)
                imageRefDynamic.value?.style?.setProperty("transform", value)
                imageRefDynamicFlat.value?.style?.setProperty("transform", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeTransform = fun(index: Number){
                val selectedItem = transformEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeTransformDynamic(selectedItem.name)
                }
            }
            val inputChangeTransform = fun(value: String){
                changeTransformDynamic(value)
            }
            onReady(fun(){
                getPropertyValues()
            }
            )
            __expose(_uM("data" to data))
            return fun(): Any? {
                val _component_enum_data = resolveEasyComponent("enum-data", GenComponentsEnumDataEnumDataClass)
                val _component_input_data = resolveEasyComponent("input-data", GenComponentsInputDataInputDataClass)
                return _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                    _cE("view", _uM("class" to "scale-container"), _uA(
                        _cE("view", _uM("class" to "trace"), _uA(
                            _cE("view", _uM("class" to "base reserve"), _uA(
                                _cE("text", _uM("class" to "reserve-text"), "scaleX(0.6)"),
                                _cE("text", _uM("class" to "reserve-text"), "转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve", "flatten" to ""), _uA(
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "scaleX(0.6)"),
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve"), _uA(
                                _cE("text", _uM("class" to "reserve-text"), "scaleY(0.8)"),
                                _cE("text", _uM("class" to "reserve-text"), "转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve", "flatten" to ""), _uA(
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "scaleY(0.8)"),
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve"), _uA(
                                _cE("text", _uM("class" to "reserve-text"), "scale(0.8,0.8)"),
                                _cE("text", _uM("class" to "reserve-text"), "转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve", "flatten" to ""), _uA(
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "scale(0.8,0.8)"),
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve"), _uA(
                                _cE("text", _uM("class" to "reserve-text"), "scaleX(-1)"),
                                _cE("text", _uM("class" to "reserve-text"), "转变前位置")
                            )),
                            _cE("view", _uM("class" to "base reserve", "flatten" to ""), _uA(
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "scaleY(-1)"),
                                _cE("text", _uM("class" to "reserve-text", "flatten" to ""), "转变前位置")
                            ))
                        )),
                        _cE("view", _uM("class" to "trace-res"), _uA(
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scaleX(0.6)"))), _uA(
                                _cE("text", null, "scaleX(0.6)"),
                                _cE("text", null, "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scaleX(0.6)")), "flatten" to ""), _uA(
                                _cE("text", _uM("flatten" to ""), "拍平"),
                                _cE("text", _uM("flatten" to ""), "scaleX(0.6)"),
                                _cE("text", _uM("flatten" to ""), "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scaleY(0.6)"))), _uA(
                                _cE("text", null, "scaleY(0.6)"),
                                _cE("text", null, "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scaleY(0.6)")), "flatten" to ""), _uA(
                                _cE("text", _uM("flatten" to ""), "拍平"),
                                _cE("text", _uM("flatten" to ""), "scaleY(0.6)"),
                                _cE("text", _uM("flatten" to ""), "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scale(1.2,1.2)"))), _uA(
                                _cE("text", null, "scale(1.2,1.2)"),
                                _cE("text", null, "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scale(1.2,1.2)")), "flatten" to ""), _uA(
                                _cE("text", _uM("flatten" to ""), "拍平"),
                                _cE("text", _uM("flatten" to ""), "scale(1.2,1.2)"),
                                _cE("text", _uM("flatten" to ""), "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scaleX(-1)"))), _uA(
                                _cE("text", null, "scaleX(-1)"),
                                _cE("text", null, "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scaleX(-1)")), "flatten" to ""), _uA(
                                _cE("text", _uM("flatten" to ""), "拍平"),
                                _cE("text", _uM("flatten" to ""), "scaleX(-1)"),
                                _cE("text", _uM("flatten" to ""), "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scaleY(-1)"))), _uA(
                                _cE("text", null, "scaleY(-1)"),
                                _cE("text", null, "转变后位置")
                            ), 4),
                            _cE("view", _uM("class" to "base transform", "style" to _nS(_uM("transform" to "scaleY(-1)")), "flatten" to ""), _uA(
                                _cE("text", _uM("flatten" to ""), "拍平"),
                                _cE("text", _uM("flatten" to ""), "scaleY(-1)"),
                                _cE("text", _uM("flatten" to ""), "转变后位置")
                            ), 4)
                        )),
                        _cE("view", _uM("class" to "base h-50", "style" to _nS(_uM("width" to "auto"))), _uA(
                            _cE("text", null, "通过scaleY(0.5)实现0.5px的线"),
                            _cE("view", _uM("style" to _nS(_uM("width" to "200px", "height" to "1px", "background-color" to "#000", "transform" to "scaleY(0.5)"))), null, 4)
                        ), 4),
                        _cE("view", _uM("class" to "base h-50", "style" to _nS(_uM("width" to "auto"))), _uA(
                            _cE("text", null, "拍平：通过scaleY(0.5)实现0.5px的线"),
                            _cE("view", _uM("style" to _nS(_uM("width" to "200px", "height" to "1px", "background-color" to "#000", "transform" to "scaleY(0.5)")), "flatten" to ""), null, 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("margin-top" to "20px", "margin-left" to "10px"))), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "text 组件 scale ")
                        ), 4),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scaleX(0.6)"))), "scaleX(0.6)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scaleX(0.6)")), "flatten" to ""), "拍平：scaleX(0.6)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scaleY(0.6)"))), "scaleY(0.6)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scaleY(0.6)")), "flatten" to ""), "拍平：scaleY(0.6)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scale(1.2,1.2)"))), "scale(1.2,1.2)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scale(1.2,1.2)")), "flatten" to ""), "拍平：scale(1.2,1.2)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scaleX(-1)"))), "scaleX(-1)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scaleX(-1)")), "flatten" to ""), "拍平：scaleX(-1)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scaleY(-1)"))), "scaleY(-1)", 4)
                        )),
                        _cE("view", _uM("class" to "base text-base-box"), _uA(
                            _cE("text", _uM("class" to "text-base", "style" to _nS(_uM("transform" to "scaleY(-1)")), "flatten" to ""), "拍平：scaleY(-1)", 4)
                        )),
                        _cE("view", _uM("style" to _nS(_uM("margin-top" to "20px", "margin-left" to "10px"))), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "image 组件 scale ")
                        ), 4),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "scaleX(0.6) 水平缩放 0.6 倍"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scaleX(0.6)")), "src" to "/static/test-image/logo.png"), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "拍平：scaleX(0.6) 水平缩放 0.6 倍"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scaleX(0.6)")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "scaleY(0.6) 垂直缩放 0.6 倍"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scaleY(0.6)")), "src" to "/static/test-image/logo.png"), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "拍平：scaleY(0.6) 垂直缩放 0.6 倍"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scaleY(0.6)")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "scale(1.2,1.2) 水平和垂直都缩放 1.2 倍"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scale(1.2,1.2)")), "src" to "/static/test-image/logo.png"), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "拍平：scale(1.2,1.2) 水平和垂直都缩放 1.2 倍"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scale(1.2,1.2)")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "scaleX(-1) 水平翻转"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scaleX(-1)")), "src" to "/static/test-image/logo.png"), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "拍平：scaleX(-1) 水平翻转"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scaleX(-1)")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "scaleY(-1) 垂直翻转"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scaleY(-1)")), "src" to "/static/test-image/logo.png"), null, 4)
                        )),
                        _cE("view", _uM("class" to "base image-container"), _uA(
                            _cE("text", _uM("class" to "image-label"), "拍平：scaleY(-1) 垂直翻转"),
                            _cE("image", _uM("class" to "image-base", "style" to _nS(_uM("transform" to "scaleY(-1)")), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                        )),
                        _cE("view", _uM("class" to "base h-50", "style" to _nS(_uM("width" to "auto"))), _uA(
                            _cE("text", null, "通过scaleY(0.5)实现0.5px的线"),
                            _cE("view", _uM("style" to _nS(_uM("width" to "200px", "height" to "1px", "background-color" to "#000", "transform" to "scaleY(0.5)"))), null, 4)
                        ), 4),
                        _cE("view", _uM("class" to "base h-50", "style" to _nS(_uM("width" to "auto"))), _uA(
                            _cE("text", null, "拍平：通过scaleY(0.5)实现0.5px的线"),
                            _cE("view", _uM("style" to _nS(_uM("width" to "200px", "height" to "1px", "background-color" to "#000", "transform" to "scaleY(0.5)")), "flatten" to ""), null, 4)
                        ), 4),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt"), "scroll-view 组件"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("scroll-view", _uM("class" to "scroll-view-base transform", "style" to _nS(_uM("transform" to "scale(1.2)"))), _uA(
                                    _cE("text", null, "scale(1.2)")
                                ), 4)
                            )),
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("scroll-view", _uM("class" to "scroll-view-base transform", "style" to _nS(_uM("transform" to "scaleX(0.8)"))), _uA(
                                    _cE("text", null, "scaleX(0.8)")
                                ), 4)
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text"), "setProperty 设置与 getPropertyValue 获取 transform (scale) ")
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActual"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefDynamic", "ref" to viewRefDynamic, "class" to "common-image", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"]))), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px"))), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualText"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefDynamic", "ref" to textRefDynamic, "class" to "common-text", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"]))), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualImage"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefDynamic", "ref" to imageRefDynamic, "class" to "common-image", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"])), "src" to "/static/test-image/logo.png"), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "test-container"), _uA(
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "view 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("view", _uM("ref_key" to "viewRefDynamicFlat", "ref" to viewRefDynamicFlat, "class" to "common-image", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"])), "flatten" to ""), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("font-size" to "12px")), "flatten" to ""), "view", 4)
                                    ), 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "text 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualTextFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("text", _uM("ref_key" to "textRefDynamicFlat", "ref" to textRefDynamicFlat, "class" to "common-text", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"])), "flatten" to ""), "text", 4)
                                ))
                            )),
                            _cE("view", _uM("class" to "test-item"), _uA(
                                _cE("text", _uM("class" to "uni-subtitle-text"), "image 组件拍平"),
                                _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["transformValueDynamic"]), 1),
                                _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["transformActualImageFlat"]), 1),
                                _cE("view", _uM("class" to "test-box"), _uA(
                                    _cE("image", _uM("ref_key" to "imageRefDynamicFlat", "ref" to imageRefDynamicFlat, "class" to "common-image", "style" to _nS(_uM("transform" to unref(data)["transformValueDynamic"])), "src" to "/static/test-image/logo.png", "flatten" to ""), null, 4)
                                ))
                            ))
                        )),
                        _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                            _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                            _cV(_component_enum_data, _uM("items" to transformEnum, "title" to "transform 枚举值", "onChange" to radioChangeTransform, "compact" to true)),
                            _cV(_component_input_data, _uM("defaultValue" to unref(data)["transformValueDynamic"], "title" to "transform 自定义值", "type" to "text", "onConfirm" to inputChangeTransform), null, 8, _uA(
                                "defaultValue"
                            ))
                        )),
                        _cE("text", _uM("class" to "uni-title-text uni-common-mt uni-common-mb"), "native-view 组件"),
                        _cE("view", _uM("class" to "demo-box"), _uA(
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("native-view", _uM("class" to "scroll-view-base transform", "style" to _nS(_uM("transform" to "scale(1.2)"))), null, 4)
                            )),
                            _cE("view", _uM("class" to "scroll-view-item"), _uA(
                                _cE("native-view", _uM("class" to "scroll-view-base transform", "style" to _nS(_uM("transform" to "scaleX(0.8)"))), null, 4)
                            ))
                        ))
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
                return _uM("scale-container" to _pS(_uM("display" to "flex", "alignItems" to "center")), "trace" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "alignItems" to "center")), "trace-res" to _pS(_uM("top" to 0, "left" to 0, "width" to "100%", "alignItems" to "center")), "base" to _pS(_uM("marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "width" to 150, "height" to 150, "alignItems" to "center", "justifyContent" to "center")), "h-50" to _pS(_uM("height" to 50)), "reserve" to _pS(_uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "dotted", "borderRightStyle" to "dotted", "borderBottomStyle" to "dotted", "borderLeftStyle" to "dotted", "borderTopColor" to "#558888", "borderRightColor" to "#558888", "borderBottomColor" to "#558888", "borderLeftColor" to "#558888", "backgroundColor" to "#DDDDDD")), "reserve-text" to _pS(_uM("color" to "#CCCCCC")), "transform" to _pS(_uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "backgroundColor" to "rgba(0,255,255,0.5)")), "text-base-box" to _pS(_uM("width" to 190, "height" to 70)), "text-base" to _pS(_uM("width" to 150, "height" to 50, "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10, "fontSize" to 16, "backgroundColor" to "rgba(0,255,255,0.5)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF", "textAlign" to "center")), "image-base" to _pS(_uM("width" to 150, "height" to 150, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#0000FF", "borderRightColor" to "#0000FF", "borderBottomColor" to "#0000FF", "borderLeftColor" to "#0000FF")), "image-container" to _pS(_uM("width" to 250, "height" to 250)), "image-label" to _pS(_uM("marginBottom" to 20, "textAlign" to "center")), "common-text" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000", "fontSize" to 12, "color" to "#FFFFFF")), "common-image" to _pS(_uM("width" to 50, "height" to 50, "backgroundColor" to "#008000")), "test-container" to _pS(_uM("width" to "100%", "flexDirection" to "row", "justifyContent" to "space-between", "marginTop" to 10)), "test-item" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "marginTop" to 0, "marginRight" to 5, "marginBottom" to 0, "marginLeft" to 5)), "test-box" to _pS(_uM("width" to "90%", "height" to 120, "paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20, "backgroundColor" to "#808080")), "demo-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around", "marginTop" to 10, "width" to "100%")), "scroll-view-item" to _pS(_uM("position" to "relative", "width" to 180, "height" to 180, "marginTop" to 10, "marginRight" to 10, "marginBottom" to 10, "marginLeft" to 10, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#dddddd", "borderRightColor" to "#dddddd", "borderBottomColor" to "#dddddd", "borderLeftColor" to "#dddddd", "overflow" to "visible")), "scroll-view-base" to _pS(_uM("width" to 120, "height" to 120, "alignItems" to "center", "justifyContent" to "center", "position" to "absolute", "top" to "50%", "left" to "50%", "marginTop" to -60, "marginLeft" to -60)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
