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
import uts.sdk.modules.iboxsChoosemedia.chooseImage
import uts.sdk.modules.iboxsChoosemedia.chooseOptions
import uts.sdk.modules.iboxsChoosemedia.previewImage
import uts.sdk.modules.iboxsChoosemedia.previewMedia
import uts.sdk.modules.iboxsChoosemedia.previewOptions
open class GenComponentsXRemarkshow : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var remark: String by `$props`
    open var thumb: UTSArray<UTSJSONObject>? by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsXRemarkshow) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsXRemarkshow
            val _cache = __ins.renderCache
            val props = __props
            val remark = computed(fun(): String {
                return props.remark
            }
            )
            val filesList = ref(_uA<UTSJSONObject>())
            watch(fun(): UTSArray<UTSJSONObject>? {
                return props.thumb
            }
            , fun(newVal: UTSArray<UTSJSONObject>?): Unit {
                console.log("数据", newVal)
                filesList.value = JSON.parseArray(JSON.stringify(newVal)) as UTSArray<UTSJSONObject>
            }
            )
            val showImage = fun(index: Number){
                var f = filesList.value[index] as UTSJSONObject
                var t = f["type"] as String
                var ext = f["ext"] as String
                if (t == "document") {
                    if (ext == "pdf") {
                        common.goto("/pages/common/pdfview?url=" + (f["url"] as String))
                        return
                    }
                }
                var list = _uA<previewMedia>()
                for(it in resolveUTSValueIterator(filesList.value)){
                    var type = it["type"] as String
                    if (type != "video" && type != "image") {
                        continue
                    }
                    list.push(previewMedia(uri = it["url"] as String, type = type))
                }
                if (list.length < 1) {
                    common.toast("无可展示图片")
                    return
                }
                previewImage(previewOptions(list = list, index = index))
            }
            return fun(): Any? {
                return _cE("view", _uM("class" to "remarkshow background-white cardborder"), _uA(
                    _cE("view", _uM("class" to "lineitem space-between"), _uA(
                        _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                            _cE("text", _uM("class" to "title"), "备注"),
                            _cE("text", _uM("class" to "content overline"), _tD(unref(remark)), 1)
                        )),
                        _cE("view", _uM("class" to "icon"))
                    )),
                    _cE("view", _uM("class" to "lineitem space-between", "style" to _nS(_uM("border-bottom" to "0px solid"))), _uA(
                        _cE("view", _uM("class" to "pagedata display-flex"), _uA(
                            _cE("text", _uM("class" to "title"), "附件")
                        ))
                    ), 4),
                    _cE("view", _uM("class" to "list-items imglist display-flex"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(filesList), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "litem imtitem", "key" to index, "onClick" to fun(){
                                showImage(index)
                            }
                            ), _uA(
                                _cE("image", _uM("class" to "image", "src" to item["thumb"]), null, 8, _uA(
                                    "src"
                                ))
                            ), 8, _uA(
                                "onClick"
                            ))
                        }
                        ), 128)
                    ))
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
                return _uM("remarkshow" to _pS(_uM("paddingBottom" to 4, "paddingLeft" to "27rpx", "paddingRight" to "21rpx", "marginBottom" to 6)), "lineitem" to _uM(".remarkshow " to _uM("height" to 30, "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#f5f5f5")), "title" to _uM(".remarkshow .lineitem .pagedata " to _uM("width" to "80rpx", "textAlign" to "right", "lineHeight" to "30px", "fontSize" to 13, "color" to "#ABABAB")), "content" to _uM(".remarkshow .lineitem .pagedata " to _uM("lineHeight" to "30px", "paddingLeft" to "29rpx", "fontSize" to 13, "width" to "550rpx")), "icon" to _uM(".remarkshow .lineitem " to _uM("width" to "50rpx", "paddingTop" to 4)), "addfile" to _uM(".remarkshow " to _uM("marginTop" to 8, "width" to 88, "height" to 21, "lineHeight" to "19px", "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "fontSize" to 12, "paddingTop" to 3, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#1776FC", "borderRightColor" to "#1776FC", "borderBottomColor" to "#1776FC", "borderLeftColor" to "#1776FC")), "imglist" to _uM(".remarkshow " to _uM("width" to "710rpx", "marginLeft" to "17rpx")), "imtitem" to _uM(".remarkshow .imglist " to _uM("width" to "160rpx", "marginRight" to "17rpx", "position" to "relative")), "image" to _uM(".remarkshow .imglist .imtitem " to _uM("width" to "160rpx", "height" to "160rpx", "borderTopLeftRadius" to 6, "borderTopRightRadius" to 6, "borderBottomRightRadius" to 6, "borderBottomLeftRadius" to 6)), "jindutiao" to _uM(".remarkshow .imglist .imtitem " to _uM("position" to "absolute", "left" to "0rpx", "top" to "0rpx", "width" to "160rpx", "height" to "160rpx", "backgroundColor" to "#00000090", "paddingLeft" to "30rpx", "paddingTop" to "70rpx")), "current" to _uM(".remarkshow .imglist .imtitem .jindutiao " to _uM("fontSize" to 12)), "deletebtnback" to _uM(".remarkshow .imglist .imtitem " to _uM("position" to "absolute", "right" to 0, "top" to 0, "height" to "30rpx", "width" to "35rpx", "backgroundImage" to "none", "backgroundColor" to "#FFFFFF")), "deletebtn" to _uM(".remarkshow .imglist .imtitem " to _uM("position" to "absolute", "right" to 0, "top" to "0rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("remark" to _uM("type" to "String", "default" to ""), "thumb" to _uM("type" to "Object")))
        var propsNeedCastKeys = _uA(
            "remark"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
