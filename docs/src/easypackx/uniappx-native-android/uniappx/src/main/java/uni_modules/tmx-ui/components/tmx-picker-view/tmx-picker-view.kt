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
open class GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var list: UTSArray<PICKER_ITEM_INFO> by `$props`
    open var listPro: UTSArray<X_PICKER_X_ITEM> by `$props`
    open var modelValue: UTSArray<String> by `$props`
    open var modelStr: String by `$props`
    open var modelStrJoin: String by `$props`
    open var cellUnits: UTSArray<String> by `$props`
    open var unitsFontSize: String by `$props`
    open var fontSize: String by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxPickerViewTmxPickerView
            val _cache = __ins.renderCache
            val props = __props
            fun emits(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val _fontSize = computed(fun(): String {
                return checkIsCssUnit(props.fontSize, xConfig.unit)
            }
            )
            val _unitsFontSize = computed(fun(): String {
                return checkIsCssUnit(props.unitsFontSize, xConfig.unit)
            }
            )
            val _isDark = computed(fun(): Boolean {
                return xConfig.dark == "dark"
            }
            )
            val pickerValue = ref(_uA<Number>())
            val tempPickerValue = ref(_uA<Number>())
            var timdid: Number = 0
            val isCanChange = ref(true)
            val _maskStyle = computed(fun(): String {
                if (_isDark.value) {
                    return "background-image:linear-gradient(to bottom,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0)),linear-gradient(to top, rgba(0, 0, 0, 0),rgba(0, 0, 0, 0));border:none;"
                }
                return "background-image:linear-gradient(to bottom,rgba(255,255,255,0),rgba(255,255,255,0)),linear-gradient(to top, rgba(255,255,255,0),rgba(255,255,255,0));border:none;"
            }
            )
            var normalizeList: normalizeListType = fun(tree: UTSArray<PICKER_ITEM_INFO>): UTSArray<X_PICKER_X_ITEM> {
                return _uA<X_PICKER_X_ITEM>()
            }
            normalizeList = fun(tree: UTSArray<PICKER_ITEM_INFO>): UTSArray<X_PICKER_X_ITEM> {
                var nowlist = _uA<X_PICKER_X_ITEM>()
                run {
                    var i: Number = 0
                    while(i < tree.length){
                        val node = tree[i]
                        val disabled = if (node.disabled == null) {
                            false
                        } else {
                            (node.disabled!! as Boolean)
                        }
                        val id = if (node.id == null) {
                            i.toString(10)
                        } else {
                            (node.id!! as String)
                        }
                        val children = if (node.children == null) {
                            (_uA<PICKER_ITEM_INFO>())
                        } else {
                            (node.children!! as UTSArray<PICKER_ITEM_INFO>)
                        }
                        var item = X_PICKER_X_ITEM(id = id, title = node.title, disabled = disabled, children = _uA<X_PICKER_X_ITEM>())
                        if (children.length > 0) {
                            item.children = normalizeList(children)
                        }
                        nowlist.push(item)
                        i++
                    }
                }
                return nowlist
            }
            fun gen_getNorMalizeList_fn(): UTSArray<X_PICKER_X_ITEM> {
                if (props.listPro.length > 0) {
                    return props.listPro
                }
                return normalizeList!!(props.list)
            }
            val getNorMalizeList = ::gen_getNorMalizeList_fn
            val _listData = computed(fun(): UTSArray<X_PICKER_X_ITEM> {
                return getNorMalizeList()
            }
            )
            val columnData = ref(_uA<UTSArray<X_PICKER_X_ITEM>>())
            val getColumnsByIndexes = fun(indexes: UTSArray<Number>): UTSArray<UTSArray<X_PICKER_X_ITEM>> {
                val normalized = _listData.value
                if (normalized.length == 0) {
                    return _uA()
                }
                val columns = _uA<UTSArray<X_PICKER_X_ITEM>>()
                var nodes = normalized
                var depth: Number = 0
                while(nodes.length > 0){
                    columns.push(nodes)
                    var idx: Number = 0
                    if (depth < indexes.length) {
                        idx = indexes[depth]
                        if (idx >= nodes.length) {
                            idx = nodes.length - 1
                        }
                        if (idx < 0) {
                            idx = 0
                        }
                    }
                    val node = nodes[idx]
                    nodes = node.children
                    depth++
                    if (nodes.length == 0) {
                        break
                    }
                }
                return columns
            }
            val getIndexesByIds = fun(ids: UTSArray<String>): UTSArray<Number> {
                if (ids.length == 0 || _listData.value.length == 0) {
                    return _uA()
                }
                val indexes: UTSArray<Number> = _uA()
                var nodes = _listData.value
                run {
                    var i: Number = 0
                    while(i < ids.length){
                        val targetId = ids[i]
                        val idx = nodes.findIndex(fun(item: X_PICKER_X_ITEM): Boolean {
                            return item.id == targetId
                        }
                        )
                        if (idx == -1) {
                            indexes.push(0)
                            if (nodes.length > 0) {
                                nodes = nodes[0].children
                            }
                        } else {
                            indexes.push(idx)
                            nodes = nodes[idx].children
                        }
                        if (nodes.length == 0) {
                            break
                        }
                        i++
                    }
                }
                return indexes
            }
            val getPathByIndexes = fun(indexes: UTSArray<Number>): pickerPathResult {
                val ids: UTSArray<String> = _uA()
                val titles: UTSArray<String> = _uA()
                var nodes = _listData.value
                run {
                    var i: Number = 0
                    while(i < indexes.length){
                        val idx = indexes[i]
                        if (idx >= 0 && idx < nodes.length) {
                            val node = nodes[idx]
                            ids.push(node.id)
                            titles.push(node.title)
                            nodes = node.children
                        } else {
                            break
                        }
                        if (nodes.length == 0) {
                            break
                        }
                        i++
                    }
                }
                return pickerPathResult(ids = ids, titles = titles)
            }
            val onPickerChange = fun(e: UniPickerViewChangeEvent){
                val newIndexes = e.detail.value
                val oldIndexes = pickerValue.value
                run {
                    var i: Number = 0
                    while(i < Math.min(oldIndexes.length, newIndexes.length)){
                        if (oldIndexes[i] !== newIndexes[i]) {
                            i
                            break
                        }
                        i + 1
                        i++
                    }
                }
                val result = updatePickerLinkage(_listData.value, oldIndexes, newIndexes)
                if (result == null) {
                    return
                }
                pickerValue.value = result.indexPath
                val ids = result.ids
                val titles = result.pathData.map(fun(el: X_PICKER_X_ITEM): String {
                    return el.title
                }
                )
                emits("update:modelStr", titles.join(props.modelStrJoin))
                emits("update:modelValue", ids)
                emits("change", ids)
                clearTimeout(timdid)
                timdid = setTimeout(fun() {
                    columnData.value = getColumnsByIndexes(result.indexPath)
                    tempPickerValue.value = pickerValue.value
                }
                , 100)
            }
            val getMaxDepth = fun(nodes: UTSArray<X_PICKER_X_ITEM>): Number {
                var depth: Number = 0
                var current = nodes
                while(current.length > 0){
                    depth++
                    current = current[0].children
                }
                return depth
            }
            val initData = fun(){
                val normalized = _listData.value
                if (normalized.length == 0) {
                    columnData.value = _uA()
                    pickerValue.value = _uA()
                    return
                }
                var indexes = getIndexesByIds(props.modelValue as UTSArray<String>)
                if (indexes.length == 0) {
                    val maxDepth = getMaxDepth(normalized)
                    indexes = UTSArray(maxDepth).fill(0)
                }
                val columns = getColumnsByIndexes(indexes)
                if (indexes.length < columns.length) {
                    while(indexes.length < columns.length){
                        indexes.push(0)
                    }
                }
                indexes = indexes.map(fun(idx, colIndex): Number {
                    if (colIndex < columns.length) {
                        val maxIndex = columns[colIndex].length - 1
                        if (idx < 0) {
                            return 0
                        }
                        if (idx > maxIndex) {
                            return maxIndex
                        }
                    }
                    return idx
                }
                )
                columnData.value = columns
                pickerValue.value = indexes
                tempPickerValue.value = indexes
                if (props.modelValue.length == 0 && columns.length > 0) {
                    val path = getPathByIndexes(indexes)
                    emits("update:modelValue", path.ids)
                    emits("update:modelStr", path.titles.join(props.modelStrJoin))
                } else if (props.modelStr == "" && props.modelValue.length > 0) {
                    val path = getPathByIndexes(indexes)
                    emits("update:modelStr", path.titles.join(props.modelStrJoin))
                }
            }
            watch(fun(): UTSArray<PICKER_ITEM_INFO> {
                return props.list
            }
            , fun(){
                nextTick(fun(){
                    initData()
                }
                )
            }
            , WatchOptions(deep = true))
            watch(_uA(
                fun(): Any {
                    return props.modelValue
                }
            ), fun(){
                nextTick(fun(){
                    val indexes = getIndexesByIds(props.modelValue as UTSArray<String>)
                    if (indexes.length > 0) {
                        val currentColumns = columnData.value
                        var finalIndexes = indexes.slice(0)
                        if (finalIndexes.length < currentColumns.length) {
                            while(finalIndexes.length < currentColumns.length){
                                finalIndexes.push(0)
                            }
                        }
                        finalIndexes = finalIndexes.map(fun(idx, colIndex): Number {
                            if (colIndex < currentColumns.length) {
                                val maxIndex = currentColumns[colIndex].length - 1
                                if (idx < 0) {
                                    return 0
                                }
                                if (idx > maxIndex) {
                                    return maxIndex
                                }
                            }
                            return idx
                        }
                        )
                        pickerValue.value = finalIndexes
                        columnData.value = getColumnsByIndexes(finalIndexes)
                        tempPickerValue.value = pickerValue.value
                    }
                }
                )
            }
            , WatchOptions(deep = true))
            onMounted(fun(){
                initData()
            }
            )
            return fun(): Any? {
                val _component_tmx_text = resolveEasyComponent("tmx-text", GenUniModulesTmxUiComponentsTmxTextTmxTextClass)
                val _component_picker_view_column = resolveComponent("picker-view-column")
                val _component_picker_view = resolveComponent("picker-view")
                return _cE("view", _uM("class" to "xPickerView", "ref" to "xPickerView"), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(props.cellUnits, fun(_unitsName, index, __index, _cached): Any {
                        return _cE(Fragment, _uM("key" to index), _uA(
                            if (_unitsName != "") {
                                _cE("view", _uM("key" to 0, "class" to "xPickerViewUnit"), _uA(
                                    _cV(_component_tmx_text, _uM("font-size" to _ctx.unitsFontSize, "class" to "xPickerViewUnitText"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(_unitsName)
                                        )
                                    }), "_" to 2), 1032, _uA(
                                        "font-size"
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 64)
                    }
                    ), 128),
                    _cE("view", _uM("class" to "xPickerBg", "style" to _nS(_uM("height" to "250px"))), _uA(
                        _cE("view", _uM("class" to "xPickerCurrentBg", "style" to _nS(_uM("top" to "100px", "height" to "50px", "backgroundColor" to "rgba(125,125,125,0.1)", "borderRadius" to "0"))), null, 4),
                        if (columnData.value.length > 0) {
                            _cE("view", _uM("key" to 0, "class" to "xPickerViewList", "style" to _nS(_uM("pointerEvents" to if (!isCanChange.value) {
                                "none"
                            } else {
                                "auto"
                            }))), _uA(
                                _cV(_component_picker_view, _uM("class" to "picker-view", "style" to _nS(_uM("height" to "250px")), "value" to tempPickerValue.value, "onChange" to onPickerChange, "mask-style" to _maskStyle.value, "indicator-class" to "indicatorClass", "indicator-style" to "height:50px;border-none;", "mask-top-style" to _maskStyle.value, "mask-bottom-style" to _maskStyle.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(columnData.value, fun(column, columnIndex, __index, _cached): Any {
                                            return _cV(_component_picker_view_column, _uM("key" to columnIndex), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE(Fragment, null, RenderHelpers.renderList(column, fun(item, itemIndex, __index, _cached): Any {
                                                        return _cE("view", _uM("class" to "picker-item", "key" to itemIndex), _uA(
                                                            _cE("text", _uM("class" to _nC(_uA(
                                                                "picker-item-text",
                                                                if (pickerValue.value[columnIndex] === itemIndex) {
                                                                    "picker-item-active"
                                                                } else {
                                                                    ""
                                                                }
                                                            )), "style" to _nS(_uM("fontSize" to _fontSize.value, "color" to if (_isDark.value) {
                                                                "#fff"
                                                            } else {
                                                                "#000"
                                                            }))), _tD(item.title), 7)
                                                        ))
                                                    }), 128)
                                                )
                                            }), "_" to 2), 1024)
                                        }), 128)
                                    )
                                }), "_" to 1), 8, _uA(
                                    "style",
                                    "value",
                                    "mask-style",
                                    "mask-top-style",
                                    "mask-bottom-style"
                                ))
                            ), 4)
                        } else {
                            _cC("v-if", true)
                        }
                    ), 4)
                ), 512)
            }
        }
        var name = "xPickerView"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("indicatorClass" to _pS(_uM("borderTopWidth::before::after" to "medium", "borderRightWidth::before::after" to "medium", "borderBottomWidth::before::after" to "medium", "borderLeftWidth::before::after" to "medium", "borderTopStyle::before::after" to "none", "borderRightStyle::before::after" to "none", "borderBottomStyle::before::after" to "none", "borderLeftStyle::before::after" to "none", "borderTopColor::before::after" to "#000000", "borderRightColor::before::after" to "#000000", "borderBottomColor::before::after" to "#000000", "borderLeftColor::before::after" to "#000000")), "picker-view" to _pS(_uM("width" to "100%", "height" to 250)), "picker-item" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")), "picker-item-text" to _pS(_uM("height" to 50, "lineHeight" to "50px", "textAlign" to "center", "opacity" to 0.6)), "picker-item-active" to _pS(_uM("fontWeight" to "bold", "opacity" to 1)), "xPickerBg" to _pS(_uM("position" to "relative")), "xPickerCurrentBg" to _pS(_uM("position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "zIndex" to 4)), "xPickerViewList" to _pS(_uM("display" to "flex", "flexDirection" to "row", "height" to "100%", "position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "zIndex" to 5)), "xPickerViewUnit" to _pS(_uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8)), "xPickerViewUnitText" to _pS(_uM("fontSize" to 12, "color" to "#888888", "fontWeight" to "bold")), "xPickerViewWrapCoumnText" to _pS(_uM("marginTop" to 0, "marginRight" to 6, "marginBottom" to 0, "marginLeft" to 6, "width" to "100%", "textAlign" to "center")), "xPickerViewWrap" to _pS(_uM("position" to "relative")), "xPickerContent" to _pS(_uM("position" to "absolute", "left" to 0, "top" to 0, "width" to "100%", "zIndex" to 5, "transitionDuration" to "350ms", "transitionProperty" to "left,right,top,bottom", "transitionTimingFunction" to "cubic-bezier(0,0.55,0.45,1)")), "xPickerMasker" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "pointerEvents" to "none", "height" to "100%", "width" to "100%", "top" to 0, "left" to 0, "position" to "absolute")), "xPickErBar" to _pS(_uM("backgroundColor" to "#f5f5f5", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "marginTop" to 0, "marginRight" to 3, "marginBottom" to 0, "marginLeft" to 3, "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "xPickerViewWrapCoumn" to _pS(_uM("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "@TRANSITION" to _uM("xPickerContent" to _uM("duration" to "350ms", "property" to "left,right,top,bottom", "timingFunction" to "cubic-bezier(0,0.55,0.45,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelStr" to null, "update:modelValue" to null)
        var props = _nP(_uM("list" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<PICKER_ITEM_INFO> {
            return _uA<PICKER_ITEM_INFO>()
        }
        ), "listPro" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<X_PICKER_X_ITEM> {
            return _uA<X_PICKER_X_ITEM>()
        }
        ), "modelValue" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<Any> {
            return _uA<Any>()
        }
        ), "modelStr" to _uM("type" to "String", "required" to true, "default" to ""), "modelStrJoin" to _uM("type" to "String", "required" to true, "default" to ","), "cellUnits" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<String> {
            return _uA<String>()
        }
        ), "unitsFontSize" to _uM("type" to "String", "required" to true, "default" to "12"), "fontSize" to _uM("type" to "String", "required" to true, "default" to "16")))
        var propsNeedCastKeys = _uA(
            "list",
            "listPro",
            "modelValue",
            "modelStr",
            "modelStrJoin",
            "cellUnits",
            "unitsFontSize",
            "fontSize"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
