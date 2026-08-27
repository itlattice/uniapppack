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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesCSSTextFontFamily : BasePage {
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
        var setup: (__props: GenPagesCSSTextFontFamily, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesCSSTextFontFamily
            val _cache = __ins.renderCache
            val uniIcon = ref("\ue100")
            val openUniIcon = fun(){
                uni_navigateTo(NavigateToOptions(url = "/pages/CSS/text/font-family-icon"))
            }
            val fontFamilyEnum = _uA(
                ItemType(value = 0, name = ""),
                ItemType(value = 1, name = "monospace"),
                ItemType(value = 2, name = "cursive"),
                ItemType(value = 3, name = "AlimamaDaoLiTiTTF"),
                ItemType(value = 4, name = "AlimamaDaoLiTiOTF"),
                ItemType(value = 5, name = "UniFontFamily")
            ) as UTSArray<ItemType>
            val data = reactive(_uO("fontFamily" to "monospace", "fontFamilyActual" to "", "fontFamilyActualFlat" to ""))
            val textRef = ref(null as UniTextElement?)
            val textRefFlat = ref(null as UniTextElement?)
            val getPropertyValues = fun(){
                data["fontFamilyActual"] = textRef.value?.style?.getPropertyValue("font-family") ?: ""
                data["fontFamilyActualFlat"] = textRefFlat.value?.style?.getPropertyValue("font-family") ?: ""
            }
            val changeFontFamily = fun(value: String){
                data["fontFamily"] = value
                textRef.value?.style?.setProperty("font-family", value)
                textRefFlat.value?.style?.setProperty("font-family", value)
                nextTick(fun(){
                    getPropertyValues()
                }
                )
            }
            val radioChangeFontFamily = fun(index: Number){
                val selectedItem = fontFamilyEnum.find(fun(item): Boolean {
                    return item.value === index
                }
                )
                if (selectedItem != null) {
                    changeFontFamily(selectedItem.name)
                }
            }
            val inputChangeFontFamily = fun(value: String){
                changeFontFamily(value)
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
                    _cE("view", _uM("class" to "uni-padding-wrap"), _uA(
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "monospace"))), "font-family: monospace", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "cursive"))), "font-family: cursive", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiTTF"))), "font-family: 阿里妈妈刀隶体-ttf（网络字体下载后生效）", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiOTF"))), "font-family: 阿里妈妈刀隶体-otf", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiOTF", "font-weight" to "bold", "font-style" to "italic"))), "font-family: 阿里妈妈刀隶体-otf（粗斜体）", 4),
                        _cE("text", _uM("style" to _nS(_uM("font-family" to "UniFontFamily"))), "style 加载非 static 目录字体文件：" + _tD(unref(uniIcon)), 5),
                        _cE("text", _uM("class" to "uni-title-text title-color"), "【拍平测试】"),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "monospace")), "flatten" to ""), "font-family: monospace", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "cursive")), "flatten" to ""), "font-family: cursive", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiTTF")), "flatten" to ""), "font-family: 阿里妈妈刀隶体-ttf（网络字体下载后生效）", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiOTF")), "flatten" to ""), "font-family: 阿里妈妈刀隶体-otf", 4),
                        _cE("text", _uM("class" to "common", "style" to _nS(_uM("font-family" to "AlimamaDaoLiTiOTF", "font-weight" to "bold", "font-style" to "italic")), "flatten" to ""), "font-family: 阿里妈妈刀隶体-otf（粗斜体）", 4),
                        _cE("text", _uM("style" to _nS(_uM("font-family" to "UniFontFamily")), "flatten" to ""), "style 加载非 static 目录字体文件：" + _tD(unref(uniIcon)), 5),
                        _cE("view", _uM("class" to "uni-common-mt"), _uA(
                            _cE("text", _uM("class" to "uni-title-text title-color"), "setProperty 设置与 getPropertyValue 获取 font-family 测试"),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["fontFamily"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["fontFamilyActual"]), 1),
                            _cE("text", _uM("ref_key" to "textRef", "ref" to textRef, "class" to "common", "style" to _nS(_uM("fontFamily" to unref(data)["fontFamily"]))), "当前 font-family: " + _tD(unref(data)["fontFamily"]), 5),
                            _cE("text", _uM("class" to "uni-info"), "设置值: " + _tD(unref(data)["fontFamily"]), 1),
                            _cE("text", _uM("class" to "uni-info"), "获取值: " + _tD(unref(data)["fontFamilyActualFlat"]), 1),
                            _cE("text", _uM("ref_key" to "textRefFlat", "ref" to textRefFlat, "class" to "common", "style" to _nS(_uM("fontFamily" to unref(data)["fontFamily"])), "flatten" to ""), "当前 font-family: " + _tD(unref(data)["fontFamily"]), 5),
                            _cE("view", _uM("class" to "uni-common-mt uni-common-mb"), _uA(
                                _cE("text", _uM("class" to "uni-tips"), "第一个枚举值，'' (空字符串) - 空值情况"),
                                _cV(_component_enum_data, _uM("items" to fontFamilyEnum, "title" to "font-family 枚举值", "onChange" to radioChangeFontFamily, "compact" to true)),
                                _cV(_component_input_data, _uM("defaultValue" to unref(data)["fontFamily"], "title" to "font-family 自定义值", "type" to "text", "onConfirm" to inputChangeFontFamily), null, 8, _uA(
                                    "defaultValue"
                                ))
                            ))
                        ))
                    )),
                    _cE("view", _uM("style" to _nS(_uM("margin" to "24px 12px"))), _uA(
                        _cE("button", _uM("type" to "default", "onClick" to openUniIcon), "内置字体图标uni-icon示例")
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
                return _uM("common" to _pS(_uM("fontSize" to 20, "lineHeight" to "40px")), "title-color" to _pS(_uM("color" to "#007aff", "marginBottom" to 10)), "common-box" to _pS(_uM("flexDirection" to "row", "justifyContent" to "space-around")), "test-box" to _pS(_uM("width" to 180, "height" to 80, "backgroundColor" to "#808080", "justifyContent" to "center", "alignItems" to "center")), "@FONT-FACE" to _uM("0" to _uM("fontFamily" to "AlimamaDaoLiTiTTF", "src" to "url('https://qiniu-web-assets.dcloud.net.cn/uni-app-x/static/font/AlimamaDaoLiTi.ttf')"), "1" to _uM("fontFamily" to "AlimamaDaoLiTiOTF", "src" to "url('/static/font/AlimamaDaoLiTi.otf')"), "2" to _uM("fontFamily" to "UniFontFamily", "src" to "url('/assets/uni.173d2b94.ttf')")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
