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
open class GenUniModulesTmxUiComponentsTmxCascaderTmxCascader : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var width: String by `$props`
    open var height: String by `$props`
    open var list: UTSArray<CASCADER_ITEM_INFO> by `$props`
    open var modelValue: String by `$props`
    open var fontSize: String by `$props`
    open var itemTextColor: String by `$props`
    open var darkItemTextColor: String by `$props`
    open var itemActiveColor: String by `$props`
    open var sliderContentBgColor: String by `$props`
    open var showCurrentBtn: Boolean by `$props`
    open var i18n: Tmui4xI18nTml by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("i18n" to xConfig.i18n as Tmui4xI18nTml)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesTmxUiComponentsTmxCascaderTmxCascader) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesTmxUiComponentsTmxCascaderTmxCascader
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val _width = computed(fun(): String {
                return checkIsCssUnit(props.width, xConfig.unit)
            }
            )
            val _height = computed(fun(): String {
                return checkIsCssUnit(props.height, xConfig.unit)
            }
            )
            val _fontSize = computed(fun(): String {
                var fontSize = checkIsCssUnit(props.fontSize, xConfig.unit)
                if (xConfig.fontScale == 1) {
                    return fontSize
                }
                var sizeNumber = parseInt(fontSize)
                if (isNaN(sizeNumber)) {
                    sizeNumber = 15
                }
                return (sizeNumber * xConfig.fontScale).toString(10) + getUnit(fontSize)
            }
            )
            val _itemActiveColor = computed(fun(): String {
                return if (props.itemActiveColor != "") {
                    getDefaultColor(props.itemActiveColor)
                } else {
                    getDefaultColor(xConfig.color)
                }
            }
            )
            val _itemTextColor = computed(fun(): String {
                var color = props.itemTextColor
                if (xConfig.dark == "dark") {
                    color = if (props.darkItemTextColor != "") {
                        props.darkItemTextColor
                    } else {
                        "#ffffff"
                    }
                }
                return getDefaultColor(color)
            }
            )
            val _borderColor = computed(fun(): String {
                if (xConfig.dark == "dark") {
                    return xConfig.borderDarkColor
                }
                return "#f5f5f5"
            }
            )
            val nowVal = ref("")
            fun getNodeArrayPaths(list: UTSArray<CASCADER_ITEM_INFO>, id: String = ""): UTSArray<menuTypeCascaderType> {
                if (list.length == 0) {
                    return _uA<menuTypeCascaderType>()
                }
                if (id == "") {
                    val firstNode = list[0]
                    val path = _uA(
                        firstNode
                    ) as UTSArray<CASCADER_ITEM_INFO>
                    var currentNode = firstNode
                    var children = currentNode?.children ?: (_uA<CASCADER_ITEM_INFO>())
                    while(children.length > 0){
                        currentNode = children[0]
                        path.push(currentNode)
                        children = currentNode?.children ?: (_uA<CASCADER_ITEM_INFO>())
                    }
                    return path.map(fun(item, index): menuTypeCascaderType {
                        return (menuTypeCascaderType(selected = false, item = item))
                    }
                    )
                }
                var findNodePath: findNodePathType? = null
                findNodePath = fun(nodes: UTSArray<CASCADER_ITEM_INFO>, targetId: String, currentPath: UTSArray<CASCADER_ITEM_INFO>): UTSArray<CASCADER_ITEM_INFO>? {
                    run {
                        var i: Number = 0
                        while(i < nodes.length){
                            val node = nodes[i]
                            val newPath: UTSArray<CASCADER_ITEM_INFO> = currentPath.concat(_uA(
                                node
                            ))
                            if (node.id == targetId) {
                                var currentNode = node
                                var finalPath: UTSArray<CASCADER_ITEM_INFO> = newPath.slice()
                                var children = currentNode?.children ?: (_uA<CASCADER_ITEM_INFO>())
                                while(children.length > 0){
                                    currentNode = children[0]
                                    finalPath.push(currentNode)
                                    children = currentNode?.children ?: (_uA<CASCADER_ITEM_INFO>())
                                }
                                return finalPath
                            }
                            var children = node?.children ?: (_uA<CASCADER_ITEM_INFO>())
                            if (children.length > 0) {
                                var fph = findNodePath!!
                                val result = fph(children, targetId, newPath)
                                if (result != null) {
                                    return result
                                }
                            }
                            i++
                        }
                    }
                    return null
                }
                val result = findNodePath(list, id, _uA<CASCADER_ITEM_INFO>())
                if (result != null) {
                    var targetIndex: Number = -1
                    run {
                        var i: Number = 0
                        while(i < result.length){
                            if (result[i].id == id) {
                                targetIndex = i
                                break
                            }
                            i++
                        }
                    }
                    return result.map(fun(item, index): menuTypeCascaderType {
                        return (menuTypeCascaderType(selected = targetIndex >= 0 && index <= targetIndex, item = item))
                    }
                    )
                }
                return _uA<menuTypeCascaderType>()
            }
            fun getNodeArraySlier(list: UTSArray<CASCADER_ITEM_INFO>, id: String = ""): UTSArray<UTSArray<CASCADER_ITEM_INFO>> {
                if (list.length == 0) {
                    return _uA<UTSArray<CASCADER_ITEM_INFO>>()
                }
                if (id == "") {
                    val layers = _uA(
                        list
                    ) as UTSArray<UTSArray<CASCADER_ITEM_INFO>>
                    var currentNodes = list
                    while(currentNodes.length > 0 && (currentNodes[0]?.children ?: (_uA<CASCADER_ITEM_INFO>())).length > 0){
                        currentNodes = (currentNodes[0]?.children ?: (_uA<CASCADER_ITEM_INFO>()))
                        layers.push(currentNodes)
                    }
                    return layers
                }
                var findNodeLayers: findNodeLayersType? = null
                findNodeLayers = fun(nodes: UTSArray<CASCADER_ITEM_INFO>, targetId: String, currentLayers: UTSArray<UTSArray<CASCADER_ITEM_INFO>>): UTSArray<UTSArray<CASCADER_ITEM_INFO>>? {
                    val newLayers: UTSArray<UTSArray<CASCADER_ITEM_INFO>> = currentLayers.concat(_uA(
                        nodes
                    ))
                    run {
                        var i: Number = 0
                        while(i < nodes.length){
                            val node = nodes[i]
                            if (node.id == targetId) {
                                var finalLayers: UTSArray<UTSArray<CASCADER_ITEM_INFO>> = newLayers.slice()
                                var currentNode = node
                                var children = currentNode?.children ?: (_uA<CASCADER_ITEM_INFO>())
                                while(children.length > 0){
                                    finalLayers.push(children)
                                    currentNode = children[0]
                                    children = currentNode?.children ?: (_uA<CASCADER_ITEM_INFO>())
                                }
                                return finalLayers
                            }
                            var children = node?.children ?: (_uA<CASCADER_ITEM_INFO>())
                            if (children.length > 0) {
                                val result = findNodeLayers!!(children, targetId, newLayers)
                                if (result != null) {
                                    return result
                                }
                            }
                            i++
                        }
                    }
                    return null
                }
                val result = findNodeLayers(list, id, _uA<UTSArray<CASCADER_ITEM_INFO>>())
                return if (result != null) {
                    result
                } else {
                    _uA<UTSArray<CASCADER_ITEM_INFO>>(list)
                }
            }
            val currentIndex = ref(0)
            val _list = computed(fun(): UTSArray<UTSArray<CASCADER_ITEM_INFO>> {
                return getNodeArraySlier(props.list, nowVal.value)
            }
            )
            val _menus = computed(fun(): UTSArray<menuTypeCascaderType> {
                return getNodeArrayPaths(props.list, nowVal.value)
            }
            )
            val _selectedIds = computed(fun(): Set<String> {
                var set = Set<String>()
                run {
                    var i: Number = 0
                    while(i < _menus.value.length){
                        var m = _menus.value[i]
                        if (m.selected) {
                            set.add(m.item.id)
                        }
                        i++
                    }
                }
                return set
            }
            )
            val _menusList = computed(fun(): UTSArray<CASCADER_ITEM_INFO> {
                return _menus.value.map(fun(el: menuTypeCascaderType): CASCADER_ITEM_INFO {
                    return el.item
                }
                )
            }
            )
            val getIds = fun(): UTSArray<String> {
                var ids: UTSArray<String> = _uA()
                run {
                    var i: Number = 0
                    while(i < _menus.value.length){
                        var item = _menus.value[i]
                        if (!item.selected) {
                            break
                        }
                        ids.push(item.item.id)
                        i++
                    }
                }
                return ids
            }
            val elitext = fun(text: String): String {
                var len = text.length
                return if (len <= 7) {
                    text
                } else {
                    (text.substring(0, 7) + "..")
                }
            }
            val isSelected = fun(item: CASCADER_ITEM_INFO): Boolean {
                return _selectedIds.value.has(item.id)
            }
            val isCurrentNext = computed(fun(): Boolean {
                return _menus.value.some(fun(el: menuTypeCascaderType): Boolean {
                    return el.selected == false
                }
                )
            }
            )
            val getNowvalIndex = fun(): Number {
                var index: Number = 0
                run {
                    var i: Number = 0
                    while(i < _menus.value.length){
                        var item = _menus.value[i]
                        if (!item.selected) {
                            break
                        }
                        index += 1
                        i++
                    }
                }
                index = Math.min(_menus.value.length - 1, index)
                return index
            }
            val menuBarClick = fun(item: menuTypeCascaderType, index: Number){
                if (item.selected) {
                    if (index == 0) {
                        nowVal.value = ""
                    } else {
                        var cureentindex = index - 1
                        cureentindex = Math.max(0, Math.min(cureentindex, _menus.value.length - 1))
                        nowVal.value = _menus.value[cureentindex].item.id
                    }
                } else {
                    nowVal.value = item.item.id
                }
                nextTick(fun(){
                    currentIndex.value = getNowvalIndex()
                    emit("change", getIds())
                    emit("update:modelValue", nowVal.value)
                }
                )
            }
            val selectedCurrentChildren = fun(item: CASCADER_ITEM_INFO, index: Number){
                var disabled = item?.disabled ?: false
                if (item.id == nowVal.value || disabled) {
                    return
                }
                nowVal.value = item.id
                emit("change", getIds())
            }
            val nextCellClick = fun(item: CASCADER_ITEM_INFO, index: Number, childrenIndex: Number){
                var disabled = item?.disabled ?: false
                if (disabled) {
                    return
                }
                if (nowVal.value != item.id) {
                    emit("change", getIds())
                }
                nowVal.value = item.id
                nextTick(fun(){
                    currentIndex.value = getNowvalIndex()
                    emit("update:modelValue", nowVal.value)
                    emit("cellClick", item, index, childrenIndex)
                    if ((item?.children?.length ?: 0) == 0) {
                        emit("confirm", nowVal.value, getIds())
                    }
                }
                )
            }
            watch(fun(): Any {
                return props.modelValue
            }
            , fun(){
                nowVal.value = props.modelValue
                nextTick(fun(){
                    currentIndex.value = getNowvalIndex()
                }
                )
            }
            )
            onMounted(fun(){
                nowVal.value = props.modelValue
                nextTick(fun(){
                    currentIndex.value = getNowvalIndex()
                }
                )
            }
            )
            return fun(): Any? {
                val _component_tmx_icon = resolveEasyComponent("tmx-icon", GenUniModulesTmxUiComponentsTmxIconTmxIconClass)
                return _cE("view", _uM("class" to "xCascaderTree", "style" to _nS(_uM("width" to unref(_width), "height" to unref(_height)))), _uA(
                    _cE("scroll-view", _uM("direction" to "horizontal", "class" to "xCascaderTreeBar"), _uA(
                        renderSlot(_ctx.`$slots`, "header", _uM("menus" to unref(_menusList)), fun(): UTSArray<Any> {
                            return _uA(
                                if (unref(_menus).length > 0) {
                                    _cE(Fragment, _uM("key" to 0), RenderHelpers.renderList(unref(_menus), fun(item, index, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "xCascaderBarTreeItem", "key" to index), _uA(
                                            if (isTrue(item.selected)) {
                                                _cE("text", _uM("key" to 0, "onClick" to fun(){
                                                    menuBarClick(item, index)
                                                }, "class" to "xCascaderTreeItemBarText", "style" to _nS(_uM("color" to unref(_itemActiveColor), "fontSize" to unref(_fontSize), "whiteSpace" to "nowrap", "border" to ("1px solid " + unref(_itemActiveColor))))), _tD(elitext(item.item.title)), 13, _uA(
                                                    "onClick"
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            },
                                            if (isTrue((item.item?.children ?: _uA()).length > 0 && item.selected)) {
                                                _cV(_component_tmx_icon, _uM("key" to 1, "class" to "xCascaderBarTreeItemRight", "font-size" to unref(_fontSize), "name" to "arrow-right-s-line", "color" to unref(_itemActiveColor)), null, 8, _uA(
                                                    "font-size",
                                                    "color"
                                                ))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        ))
                                    }), 128)
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (isTrue(unref(isCurrentNext))) {
                                    _cE("view", _uM("key" to 1, "class" to "xCascaderBarTreeItem"), _uA(
                                        _cE("text", _uM("style" to _nS(_uM("color" to unref(_itemTextColor), "fontSize" to unref(_fontSize), "whiteSpace" to "nowrap"))), _tD(_ctx.i18n!!.t("tmui4x.cascader.placeholder")), 5),
                                        _cV(_component_tmx_icon, _uM("class" to "xCascaderBarTreeItemRight", "font-size" to "14", "name" to "arrow-right-s-line", "color" to unref(_itemActiveColor)), null, 8, _uA(
                                            "color"
                                        ))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            )
                        }
                        )
                    )),
                    _cE("view", _uM("style" to _nS(_uM("height" to "1px", "borderBottom" to ("1px solid " + unref(_borderColor))))), null, 4),
                    _cE("view", _uM("style" to _nS(_uM("flex" to "1"))), _uA(
                        _cE("swiper", _uM("duration" to 0, "current" to unref(currentIndex), "class" to "xCascaderTreeSwiper", "disable-touch" to true), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(unref(_list), fun(item, index, __index, _cached): Any {
                                return _cE("swiper-item", _uM("key" to index, "class" to "xCascaderTreeSwiperItem"), _uA(
                                    _cE("list-view", _uM("class" to "xCascaderScoll", "direction" to "vertical"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(item, fun(item2, index2, __index, _cached): Any {
                                            return _cE("list-item", _uM("key" to item2.id), _uA(
                                                _cE("view", _uM("onClick" to fun(){
                                                    nextCellClick(item2, index, index2)
                                                }
                                                , "class" to _nC(_uA(
                                                    _uA(
                                                        if ((item2?.disabled ?: false)) {
                                                            "xCascaderItemDisabled"
                                                        } else {
                                                            ""
                                                        }
                                                    ),
                                                    "xCascaderItem"
                                                ))), _uA(
                                                    _cE("text", _uM("class" to "xCascaderItemLeft", "style" to _nS(_uM("fontSize" to unref(_fontSize), "color" to if (isSelected(item2)) {
                                                        unref(_itemActiveColor)
                                                    } else {
                                                        unref(_itemTextColor)
                                                    }
                                                    ))), _tD(item2.title) + _tD(item2.id), 5),
                                                    _cE("view", _uM("class" to "xCascaderItemRight"), _uA(
                                                        if (isTrue((item2?.children ?: _uA()).length > 0 && _ctx.showCurrentBtn)) {
                                                            _cE("text", _uM("key" to 0, "class" to "xCascaderTreeItemRightTextBtns", "style" to _nS(_uM("color" to unref(_itemActiveColor), "border" to ("1px solid " + unref(_itemActiveColor)))), "onClick" to withModifiers(fun(){
                                                                selectedCurrentChildren(item2, index)
                                                            }, _uA(
                                                                "stop"
                                                            ))), _tD(_ctx.i18n!!.t("tmui4x.cascader.currentPlaceholder")), 13, _uA(
                                                                "onClick"
                                                            ))
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                        ,
                                                        if ((item2?.children ?: _uA()).length > 0) {
                                                            _cV(_component_tmx_icon, _uM("key" to 1, "color" to unref(_itemTextColor), "name" to "arrow-right-s-line"), null, 8, _uA(
                                                                "color"
                                                            ))
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                        ,
                                                        if (isTrue(isSelected(item2) && (((item2?.children ?: _uA()).length > 0 && !_ctx.showCurrentBtn) || (item2?.children ?: _uA()).length == 0))) {
                                                            _cV(_component_tmx_icon, _uM("key" to 2, "color" to unref(_itemActiveColor), "name" to "check-line"), null, 8, _uA(
                                                                "color"
                                                            ))
                                                        } else {
                                                            _cC("v-if", true)
                                                        }
                                                    ))
                                                ), 10, _uA(
                                                    "onClick"
                                                ))
                                            ))
                                        }
                                        ), 128)
                                    ))
                                ))
                            }
                            ), 128)
                        ), 8, _uA(
                            "current"
                        ))
                    ), 4)
                ), 4)
            }
        }
        var name = "xCascader"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("xCascaderItemDisabled" to _pS(_uM("opacity" to 0.6)), "xCascaderTreeBar" to _pS(_uM("display" to "flex", "flexDirection" to "row", "position" to "relative", "height" to 50)), "xCascaderBarTreeItem" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "height" to "100%")), "xCascaderBarTreeItemRight" to _pS(_uM("marginTop" to 0, "marginRight" to 0, "marginBottom" to 0, "marginLeft" to 0)), "xCascaderTreeItemBarText" to _pS(_uM("textOverflow" to "ellipsis", "lines" to 1, "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3, "paddingTop" to 0, "paddingRight" to 8, "paddingBottom" to 0, "paddingLeft" to 8, "lineHeight" to 1.5)), "xCascaderItem" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "height" to 44)), "xCascaderItemLeft" to _pS(_uM("lines" to 1, "marginRight" to 24)), "xCascaderItemRight" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "xCascaderTreeItemRightTextBtns" to _pS(_uM("fontSize" to 11, "paddingTop" to 1, "paddingRight" to 3, "paddingBottom" to 1, "paddingLeft" to 3, "borderTopLeftRadius" to 3, "borderTopRightRadius" to 3, "borderBottomRightRadius" to 3, "borderBottomLeftRadius" to 3)), "xCascaderTree" to _pS(_uM("display" to "flex", "flexDirection" to "column")), "xCascaderTreeSwiper" to _pS(_uM("height" to "100%")), "xCascaderTreeSwiperItem" to _pS(_uM("height" to "100%")), "xCascaderScoll" to _pS(_uM("height" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "cellClick" to null, "confirm" to null, "update:modelValue" to null)
        var props = _nP(_uM("width" to _uM("type" to "String", "required" to true, "default" to "auto"), "height" to _uM("type" to "String", "required" to true, "default" to "150"), "list" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<CASCADER_ITEM_INFO> {
            return _uA<CASCADER_ITEM_INFO>()
        }
        ), "modelValue" to _uM("type" to "String", "required" to true), "fontSize" to _uM("type" to "String", "required" to true, "default" to "16"), "itemTextColor" to _uM("type" to "String", "required" to true, "default" to "#333333"), "darkItemTextColor" to _uM("type" to "String", "required" to true, "default" to ""), "itemActiveColor" to _uM("type" to "String", "required" to true, "default" to ""), "sliderContentBgColor" to _uM("type" to "String", "required" to true, "default" to "rgba(0,0,0,0)"), "showCurrentBtn" to _uM("type" to "Boolean", "required" to true)))
        var propsNeedCastKeys = _uA(
            "width",
            "height",
            "list",
            "fontSize",
            "itemTextColor",
            "darkItemTextColor",
            "itemActiveColor",
            "sliderContentBgColor",
            "showCurrentBtn"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
