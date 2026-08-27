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
import io.dcloud.uniapp.extapi.request as uni_request
open class GenPagesTemplateListNewsDetailDetail : BasePage {
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
    open var post_id: String by `$props`
    open var cover: String by `$props`
    open var title: String by `$props`
    open var isWideScreen: Boolean by `$props`
    open var shareKey: String by `$props`
    open var firstDetailContent: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTemplateListNewsDetailDetail) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateListNewsDetailDetail
            val _cache = __ins.renderCache
            val props = __props
            val isDarkMode = computed(fun(): Boolean {
                return state.isDarkMode
            }
            )
            val htmlNodes = ref("")
            val usedContent = ref(false)
            val btCover = ref("")
            fun gen_processHtmlContent_fn(reassignedContent: String, color: String): String {
                var content = reassignedContent
                content = content.replace(UTSRegExp("(<p[^>]*style=\")([^\"]*)\"", "g"), "\$1\$2;color:" + color + ";\"")
                content = content.replace(UTSRegExp("<p((?!style)[^>]*)>", "g"), "<p\$1 style=\"color:" + color + ";\">")
                content = content.replace(UTSRegExp("<h2[^>]*>", "g"), "<p style=\"color:" + color + ";\"><big>")
                content = content.replace(UTSRegExp("</h2>", "g"), "</big></p>")
                content = content.replace(UTSRegExp("<h3[^>]*>", "g"), "<p style=\"color:" + color + ";\"><big>")
                content = content.replace(UTSRegExp("</h3>", "g"), "</big></p>")
                content = content.replace(UTSRegExp("(<\\/p>|<\\/img>)([^<\\s][^<]*)", "g"), "\$1<p style=\"color:" + color + ";\">\$2</p>")
                content = content.replace(UTSRegExp("(<span[^>]*style=\")([^\"]*)\"", "g"), "\$1\$2;color:" + color + ";\"")
                content = content.replace(UTSRegExp("<span((?!style)[^>]*)>", "g"), "<span\$1 style=\"color:" + color + ";\">")
                return content
            }
            val processHtmlContent = ::gen_processHtmlContent_fn
            fun gen_adaptContentForDarkMode_fn(content: String): String {
                if (isDarkMode.value) {
                    return processHtmlContent(content, "#ffffff")
                }
                return content
            }
            val adaptContentForDarkMode = ::gen_adaptContentForDarkMode_fn
            fun gen_getDetail_fn(post_id: String) {
                uni_request<Any>(RequestOptions(url = "https://unidemo.dcloud.net.cn/api/news/36kr/" + post_id, success = fun(data){
                    if (data.statusCode == 200) {
                        val result = data.data as UTSJSONObject
                        var content = result["content"] as String
                        htmlNodes.value = adaptContentForDarkMode(content)
                    }
                }
                , fail = fun(_){
                    console.log("fail")
                }
                ))
            }
            val getDetail = ::gen_getDetail_fn
            watch(fun(): String {
                return props.post_id
            }
            , fun(newVal: String){
                if (newVal != "") {
                    if (props.firstDetailContent !== "") {
                        var content = props.firstDetailContent
                        htmlNodes.value = adaptContentForDarkMode(content)
                        usedContent.value = true
                    } else {
                        getDetail(newVal)
                        usedContent.value = false
                    }
                }
            }
            , WatchOptions(immediate = true, deep = true))
            watch(fun(): String {
                return props.firstDetailContent
            }
            , fun(newVal: String){
                if (!usedContent.value && newVal !== "") {
                    var content = newVal
                    htmlNodes.value = adaptContentForDarkMode(content)
                    usedContent.value = true
                }
            }
            )
            onLoad(fun(_options){
                if (!props.isWideScreen) {
                    btCover.value = props.cover
                    btCover.value = atob(btCover.value)
                }
            }
            )
            return fun(): Any? {
                val _component_rich_text = resolveComponent("rich-text")
                return _cE("scroll-view", _uM("class" to _nC(_uA(
                    if (unref(isDarkMode)) {
                        "theme-dark"
                    } else {
                        "theme-light"
                    }
                    ,
                    "detail-container"
                )), "style" to _nS(_uM("flex" to "1"))), _uA(
                    if (isTrue(_ctx.isWideScreen)) {
                        _cE("view", _uM("key" to 0), _uA(
                            _cE("image", _uM("class" to "banner-img", "src" to _ctx.cover), null, 8, _uA(
                                "src"
                            )),
                            _cE("text", _uM("class" to "banner-title"), _tD(_ctx.title), 1)
                        ))
                    } else {
                        _cE("share-element", _uM("key" to 1, "share-key" to _ctx.shareKey), _uA(
                            _cE("view", null, _uA(
                                _cE("image", _uM("class" to "banner-img", "src" to unref(btCover)), null, 8, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "banner-title"), _tD(_ctx.title), 1)
                            ))
                        ), 8, _uA(
                            "share-key"
                        ))
                    }
                    ,
                    if (isTrue(unref(htmlNodes))) {
                        _cV(_component_rich_text, _uM("key" to 2, "class" to "rich-text", "nodes" to unref(htmlNodes), "mode" to "native"), null, 8, _uA(
                            "nodes"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("detail-container" to _pS(_uM("backgroundColor" to "var(--background-color,#f8f8f8)")), "banner" to _pS(_uM("height" to 180, "overflow" to "hidden", "position" to "relative", "backgroundColor" to "var(--background-color,#f8f8f8)")), "banner-img" to _pS(_uM("width" to "100%")), "banner-title" to _pS(_uM("maxHeight" to 42, "overflow" to "hidden", "position" to "absolute", "left" to 15, "bottom" to 15, "width" to "90%", "fontSize" to 16, "fontWeight" to "400", "lineHeight" to "21px", "color" to "#FFFFFF")), "rich-text" to _pS(_uM("paddingTop" to 3, "paddingRight" to 3, "paddingBottom" to 0, "paddingLeft" to 3)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("post_id" to _uM("type" to "String", "default" to ""), "cover" to _uM("type" to "String", "default" to ""), "title" to _uM("type" to "String", "default" to ""), "isWideScreen" to _uM("type" to "Boolean", "default" to false), "shareKey" to _uM("type" to "String", "default" to ""), "firstDetailContent" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "post_id",
            "cover",
            "title",
            "isWideScreen",
            "shareKey",
            "firstDetailContent"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
