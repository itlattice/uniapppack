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
open class GenPagesTemplateLongListDeleteableLongListDeleteable : BasePage {
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
    open var jest_getListRect: () -> Unit
        get() {
            return unref(this.`$exposed`["jest_getListRect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "jest_getListRect", value)
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
        var setup: (__props: GenPagesTemplateLongListDeleteableLongListDeleteable, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesTemplateLongListDeleteableLongListDeleteable
            val _cache = __ins.renderCache
            val baseColors = _uA(
                _uA(
                    180,
                    40,
                    40
                ),
                _uA(
                    200,
                    120,
                    40
                ),
                _uA(
                    180,
                    160,
                    40
                ),
                _uA(
                    40,
                    140,
                    60
                ),
                _uA(
                    40,
                    140,
                    160
                ),
                _uA(
                    40,
                    80,
                    160
                ),
                _uA(
                    120,
                    60,
                    160
                ),
                _uA(
                    180,
                    80,
                    120
                ),
                _uA(
                    140,
                    90,
                    60
                ),
                _uA(
                    100,
                    100,
                    100
                )
            ) as UTSArray<UTSArray<Number>>
            val generateColor = fun(groupIndex: Number, itemInGroup: Number): String {
                val base = baseColors[groupIndex]
                val factor = itemInGroup * 0.067
                val r = Math.floor(base[0] + (255 - base[0]) * factor)
                val g = Math.floor(base[1] + (255 - base[1]) * factor)
                val b = Math.floor(base[2] + (255 - base[2]) * factor)
                return "rgba(" + r + ", " + g + ", " + b + ", 1)"
            }
            val generateItems = fun(): UTSArray<ListItemData> {
                val result: UTSArray<ListItemData> = _uA()
                run {
                    var i: Number = 0
                    while(i < 100){
                        val groupIndex = Math.floor(i / 10)
                        val itemInGroup = i % 10
                        val height = 60 + i * 2
                        val bgColor = generateColor(groupIndex, itemInGroup)
                        val subItems: UTSArray<SubItemData> = _uA()
                        run {
                            var j: Number = 0
                            while(j < itemInGroup){
                                subItems.push(SubItemData(index = j, bgColor = generateColor(groupIndex, j)))
                                j++
                            }
                        }
                        result.push(ListItemData(id = i, height = height, bgColor = bgColor, subItems = subItems))
                        i++
                    }
                }
                return result
            }
            val items = ref<UTSArray<ListItemData>>(generateItems())
            val itemMetas = ref<UTSArray<ListItemMeta>>(items.value.map(fun(item): ListItemMeta {
                return (ListItemMeta(translateX = 0, translateY = 0, zIndex = 0))
            }
            ))
            val listRef = ref<UniElement?>(null)
            val MENU_WIDTH: Number = 80
            var isScrolling = false
            var scrollEndTimer: Number? = null
            val SCROLL_END_DELAY: Number = 150
            var startX: Number = 0
            var startY: Number = 0
            var currentIndex: Number = -1
            var isSwiping = false
            var swipeStarted = false
            var currentListItemElement: UniElement? = null
            var swipingMetaIndex: Number = -1
            val menuTop = ref(0)
            val menuHeight = ref(0)
            val menuVisible = ref(false)
            val menuShowWidth = ref(0)
            val activeIndex = ref(-1)
            var isDeleting = false
            val isDeleteAnimating = ref(false)
            var deletingIndex: Number = -1
            var deleteAnimationOffsetBelow: Number = 0
            var deleteAnimationOffsetAbove: Number = 0
            var deletedItemHeight: Number = 0
            var deleteItemOffsetX: Number = 0
            val isMultiSelectMode = ref(false)
            val selectedIds = ref(_uA<Number>())
            val isAllSelected = computed(fun(): Boolean {
                return items.value.length > 0 && selectedIds.value.length == items.value.length
            }
            )
            var visibleStartIndex: Number = 0
            var visibleEndIndex: Number = -1
            val VISIBLE_RANGE_BUFFER: Number = 2
            val resetItemMeta = fun(index: Number){
                if (index < 0 || index >= itemMetas.value.length) {
                    return
                }
                val meta = itemMetas.value[index]
                meta.translateX = 0
                meta.translateY = 0
                meta.zIndex = 0
            }
            val resetAllItemMetas = fun(){
                run {
                    var i: Number = 0
                    while(i < itemMetas.value.length){
                        resetItemMeta(i)
                        i++
                    }
                }
            }
            val applyDeleteAnimationMetas = fun(){
                if (deletingIndex == -1) {
                    return
                }
                val start = Math.max(0, visibleStartIndex - VISIBLE_RANGE_BUFFER)
                val end = Math.min(itemMetas.value.length - 1, visibleEndIndex + VISIBLE_RANGE_BUFFER)
                run {
                    var i = start
                    while(i <= end){
                        val meta = itemMetas.value[i]
                        if (i > deletingIndex) {
                            meta.translateY = -deleteAnimationOffsetBelow
                        } else if (i < deletingIndex) {
                            meta.translateY = deleteAnimationOffsetAbove
                        } else {
                            meta.translateX = deleteItemOffsetX
                        }
                        i++
                    }
                }
            }
            var containerTop: Number = 0
            val menuTransform = computed(fun(): String {
                return "translateY(" + menuTop.value + "px) translateX(" + -menuShowWidth.value + "px)"
            }
            )
            val findListItemElement = fun(target: UniElement?): UniElement? {
                if (target == null) {
                    return null
                }
                var element: UniElement? = target
                while(element != null){
                    if (element.tagName == "LIST-ITEM") {
                        return element
                    }
                    val classAttr = element.getAttribute("class")
                    if (classAttr != null && classAttr.indexOf("scroll-item") != -1) {
                        return element
                    }
                    element = element.parentElement
                }
                return null
            }
            val closeMenu = fun(){
                if (swipingMetaIndex != -1) {
                    resetItemMeta(swipingMetaIndex)
                    swipingMetaIndex = -1
                }
                if (activeIndex.value != -1) {
                    resetItemMeta(activeIndex.value)
                }
                menuVisible.value = false
                menuShowWidth.value = 0
                activeIndex.value = -1
                currentListItemElement = null
            }
            val updateMenuPosition = fun(){
                if (currentListItemElement == null) {
                    return
                }
                if (currentIndex == -1 || currentIndex >= items.value.length) {
                    return
                }
                if (!menuVisible.value) {
                    menuVisible.value = true
                    val rect = currentListItemElement!!.getBoundingClientRect()
                    val item = items.value[currentIndex]
                    menuTop.value = rect.top - containerTop
                    menuHeight.value = item.height
                }
            }
            val onLongPress = fun(){
                if (isDeleting || isMultiSelectMode.value) {
                    return
                }
                closeMenu()
                isMultiSelectMode.value = true
                selectedIds.value = _uA()
            }
            val exitMultiSelectMode = fun(){
                isMultiSelectMode.value = false
                selectedIds.value = _uA()
            }
            val toggleSelect = fun(id: Number){
                val index = selectedIds.value.indexOf(id)
                if (index == -1) {
                    selectedIds.value.push(id)
                } else {
                    selectedIds.value.splice(index, 1)
                }
            }
            val toggleSelectAll = fun(){
                if (isAllSelected.value) {
                    selectedIds.value = _uA()
                } else {
                    selectedIds.value = items.value.map(fun(item): Number {
                        return item.id
                    }
                    )
                }
            }
            val onBatchDelete = fun(){
                if (selectedIds.value.length == 0) {
                    return
                }
                val idsToDelete = selectedIds.value.slice()
                items.value = items.value.filter(fun(item): Boolean {
                    return !idsToDelete.includes(item.id)
                }
                )
                itemMetas.value = items.value.map(fun(item): ListItemMeta {
                    return (ListItemMeta(translateX = 0, translateY = 0, zIndex = 0))
                }
                )
                selectedIds.value = _uA()
                if (items.value.length == 0) {
                    exitMultiSelectMode()
                }
            }
            val onTouchStart = fun(e: TouchEvent, index: Number){
                if (isScrolling || isDeleting) {
                    return
                }
                if (isMultiSelectMode.value) {
                    return
                }
                val touch = e.touches[0]
                startX = touch.screenX
                startY = touch.screenY
                currentIndex = index
                isSwiping = false
                swipeStarted = false
                if (activeIndex.value != -1 && activeIndex.value != index) {
                    closeMenu()
                }
                val target = e.target as UniElement?
                currentListItemElement = findListItemElement(target)
                if (activeIndex.value == index) {
                    val meta = itemMetas.value[index]
                    meta.translateX = -MENU_WIDTH
                    swipingMetaIndex = index
                    menuShowWidth.value = MENU_WIDTH
                }
            }
            val onTouchMove = fun(e: TouchEvent){
                if (isScrolling || isDeleting) {
                    return
                }
                if (currentIndex == -1) {
                    return
                }
                if (isMultiSelectMode.value) {
                    return
                }
                val touch = e.touches[0]
                val deltaX = touch.screenX - startX
                val deltaY = touch.screenY - startY
                if (!swipeStarted) {
                    if (Math.abs(deltaX) > 10 || Math.abs(deltaY) > 10) {
                        swipeStarted = true
                        isSwiping = Math.abs(deltaX) > Math.abs(deltaY)
                    }
                }
                if (!isSwiping) {
                    return
                } else {
                    e.preventDefault()
                }
                var offsetX: Number
                if (activeIndex.value == currentIndex) {
                    offsetX = -MENU_WIDTH + deltaX
                } else {
                    offsetX = deltaX
                }
                offsetX = Math.max(-MENU_WIDTH, Math.min(0, offsetX))
                if (swipingMetaIndex != -1 && swipingMetaIndex != currentIndex) {
                    resetItemMeta(swipingMetaIndex)
                }
                val meta = itemMetas.value[currentIndex]
                meta.translateX = offsetX
                swipingMetaIndex = currentIndex
                if (offsetX < 0) {
                    updateMenuPosition()
                    menuShowWidth.value = Math.abs(offsetX)
                } else {
                    menuVisible.value = false
                    menuShowWidth.value = 0
                }
            }
            val onTouchEnd = fun(_: TouchEvent){
                if (isScrolling || isDeleting) {
                    return
                }
                if (currentIndex == -1) {
                    return
                }
                if (isMultiSelectMode.value) {
                    return
                }
                if (isSwiping) {
                    if (itemMetas.value[currentIndex].translateX < -MENU_WIDTH / 2) {
                        itemMetas.value[currentIndex].translateX = -MENU_WIDTH
                        menuShowWidth.value = MENU_WIDTH
                        activeIndex.value = currentIndex
                        menuVisible.value = true
                    } else {
                        closeMenu()
                    }
                }
                currentIndex = -1
                isSwiping = false
                swipeStarted = false
            }
            val onListScroll = fun(e: UniScrollEvent){
                isScrolling = true
                if (scrollEndTimer != null) {
                    clearTimeout(scrollEndTimer!!)
                    scrollEndTimer = null
                }
                scrollEndTimer = setTimeout(fun(){
                    isScrolling = false
                    scrollEndTimer = null
                }
                , SCROLL_END_DELAY) as Number
                if (menuVisible.value) {
                    closeMenu()
                }
            }
            val onScrollEnd = fun(_: ScrollEvent){
                if (scrollEndTimer != null) {
                    clearTimeout(scrollEndTimer!!)
                    scrollEndTimer = null
                }
                isScrolling = false
            }
            var deleteAnimationStartTime: Number = 0
            var deleteAnimationTargetBelow: Number = 0
            var deleteAnimationTargetAbove: Number = 0
            var deleteAnimationTargetHorizontal: Number = 0
            var deleteAnimationStartHorizontal: Number = 0
            var deleteAnimationIndexToDelete: Number = -1
            val DELETE_ANIMATION_DURATION: Number = 280
            val executeDeleteAnimationFrame = fun(): Boolean {
                val elapsed = Date.now() - deleteAnimationStartTime
                val progress = Math.min(elapsed / DELETE_ANIMATION_DURATION, 1)
                val easeOut = 1 - Math.pow(1 - progress, 2)
                deleteAnimationOffsetBelow = deleteAnimationTargetBelow * easeOut
                deleteAnimationOffsetAbove = deleteAnimationTargetAbove * easeOut
                val horizontalProgress = Math.min(progress * 0.85, 1)
                val horizontalEaseOut = 1 - Math.pow(1 - horizontalProgress, 2)
                deleteItemOffsetX = deleteAnimationStartHorizontal + (deleteAnimationTargetHorizontal - deleteAnimationStartHorizontal) * horizontalEaseOut
                menuShowWidth.value = Math.max(0, MENU_WIDTH * (1 - easeOut))
                applyDeleteAnimationMetas()
                return progress < 1
            }
            val finishDeleteAnimation = fun(){
                val indexToDelete = deleteAnimationIndexToDelete
                deleteAnimationOffsetBelow = 0
                deleteAnimationOffsetAbove = 0
                deletingIndex = -1
                deletedItemHeight = 0
                deleteItemOffsetX = 0
                isDeleting = false
                isDeleteAnimating.value = false
                menuShowWidth.value = 0
                currentListItemElement = null
                deleteAnimationIndexToDelete = -1
                itemMetas.value.splice(indexToDelete, 1)
                resetAllItemMetas()
                items.value.splice(indexToDelete, 1)
            }
            var scheduleNextAnimationFrame: () -> Unit = fun(): Unit {}
            scheduleNextAnimationFrame = fun(): Unit {
                if (executeDeleteAnimationFrame()) {
                    setTimeout(scheduleNextAnimationFrame, 16)
                } else {
                    finishDeleteAnimation()
                }
            }
            val onDeleteClick = fun(){
                if (activeIndex.value == -1 || isDeleting) {
                    return
                }
                val indexToDelete = activeIndex.value
                val itemToDelete = items.value[indexToDelete]
                deletingIndex = indexToDelete
                deletedItemHeight = currentListItemElement!!.getBoundingClientRect().height
                deleteAnimationOffsetBelow = 0
                deleteAnimationOffsetAbove = 0
                deleteItemOffsetX = -MENU_WIDTH
                isDeleting = true
                isDeleteAnimating.value = true
                if (swipingMetaIndex != -1) {
                    resetItemMeta(swipingMetaIndex)
                    swipingMetaIndex = -1
                }
                itemMetas.value[indexToDelete].translateX = -MENU_WIDTH
                if (indexToDelete + 1 < itemMetas.value.length) {
                    itemMetas.value[indexToDelete + 1].zIndex = 1
                }
                if (indexToDelete - 1 >= 0) {
                    itemMetas.value[indexToDelete - 1].zIndex = 1
                }
                menuVisible.value = false
                activeIndex.value = -1
                var itemElements = listRef.value!!.querySelectorAll(".item-wrapper")!!
                val itemRenderIndex = itemElements.indexOf(currentListItemElement!!)
                if (itemRenderIndex == -1) {
                    return
                }
                val lastItemElement = itemElements[itemElements.length - 1]
                val lastItemRect = lastItemElement.getBoundingClientRect()
                val lastItemBottom = lastItemRect.top + lastItemRect.height
                val listRect = listRef.value!!.getBoundingClientRect()
                val listBottom = listRect.top + listRect.height
                val lastItemOffsetBottom = Math.max(0, lastItemBottom - listBottom)
                if (lastItemOffsetBottom < deletedItemHeight) {
                    deleteAnimationTargetBelow = lastItemOffsetBottom
                    deleteAnimationTargetAbove = deletedItemHeight - lastItemOffsetBottom
                } else {
                    deleteAnimationTargetBelow = deletedItemHeight
                    deleteAnimationTargetAbove = 0
                }
                deleteAnimationStartTime = Date.now()
                deleteAnimationStartHorizontal = -MENU_WIDTH
                deleteAnimationTargetHorizontal = -(MENU_WIDTH + 400)
                deleteAnimationIndexToDelete = indexToDelete
                visibleStartIndex = indexToDelete
                visibleEndIndex = indexToDelete
                run {
                    var i = itemRenderIndex - 1
                    while(i >= 0){
                        val itemElement = itemElements[i]
                        val itemRect = itemElement.getBoundingClientRect()
                        val itemBottom = itemRect.top + itemRect.height
                        if (itemBottom <= listRect.top || i == 0) {
                            visibleStartIndex = Math.max(0, indexToDelete - itemRenderIndex + i - 1)
                            break
                        }
                        i--
                    }
                }
                run {
                    var i = itemRenderIndex + 1
                    while(i < itemElements.length){
                        val itemElement = itemElements[i]
                        val itemRect = itemElement.getBoundingClientRect()
                        if (itemRect.top >= listRect.bottom || i == itemElements.length - 1) {
                            visibleEndIndex = Math.min(indexToDelete + i - itemRenderIndex + 1, items.value.length - 1)
                            break
                        }
                        i++
                    }
                }
                scheduleNextAnimationFrame()
            }
            val data = reactive(_uO("listTop" to 0, "listWidth" to 0))
            fun gen_jest_getListRect_fn() {
                val listRect = listRef.value!!.getBoundingClientRect()
                data["listTop"] = listRect.top
                data["listWidth"] = listRect.width
            }
            val jest_getListRect = ::gen_jest_getListRect_fn
            __expose(_uM("jest_getListRect" to jest_getListRect, "data" to data))
            return fun(): Any? {
                val _component_checkbox = resolveComponent("checkbox")
                return _cE("view", _uM("class" to "container", "id" to "container"), _uA(
                    _cE("list-view", _uM("ref_key" to "listRef", "ref" to listRef, "class" to "list", "onScroll" to onListScroll, "onScrollend" to onScrollEnd), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(items), fun(item, index, __index, _cached): Any {
                            return _cE("list-item", _uM("key" to item.id, "class" to "item-wrapper", "style" to _nS(_uM("backgroundColor" to item.bgColor, "transform" to ("translateY(" + unref(itemMetas)[index].translateY + "px)"), "zIndex" to unref(itemMetas)[index].zIndex)), "onTouchstart" to fun(e: TouchEvent){
                                return onTouchStart(e, index)
                            }
                            , "onTouchmove" to onTouchMove, "onTouchend" to onTouchEnd, "onTouchcancel" to onTouchEnd, "onLongpress" to onLongPress), _uA(
                                if (isTrue(unref(isMultiSelectMode))) {
                                    _cV(_component_checkbox, _uM("key" to 0, "style" to _nS(_uM("margin-left" to "10px")), "checked" to unref(selectedIds).includes(item.id), "onClick" to fun(){
                                        toggleSelect(item.id)
                                    }), null, 8, _uA(
                                        "style",
                                        "checked",
                                        "onClick"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                _cE("view", _uM("class" to "item-content", "style" to _nS(_uM("height" to (item.height + "px"), "transform" to ("translateX(" + unref(itemMetas)[index].translateX + "px)")))), _uA(
                                    _cE("text", _uM("class" to "item-text"), "试试左滑和长按 " + _tD(item.id + 1), 1),
                                    _cE("text", _uM("class" to "item-info"), "高度: " + _tD(item.height) + "px", 1),
                                    _cE("view", _uM("class" to "item-sub-items"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(item.subItems, fun(subItem, __key, __index, _cached): Any {
                                            return _cE("view", _uM("key" to subItem.index, "style" to _nS(_uM("backgroundColor" to subItem.bgColor))), _uA(
                                                _cE("text", _uM("class" to "item-info"), _tD(subItem.index + 1), 1)
                                            ), 4)
                                        }
                                        ), 128)
                                    ))
                                ), 4)
                            ), 44, _uA(
                                "onTouchstart"
                            ))
                        }
                        ), 128)
                    ), 544),
                    _cE("view", _uM("class" to "swipe-menu", "style" to _nS(_uM("transform" to unref(menuTransform), "height" to (unref(menuHeight) + "px")))), _uA(
                        _cE("view", _uM("class" to "menu-item delete-btn", "onClick" to onDeleteClick), _uA(
                            _cE("text", _uM("class" to "menu-text"), "删除")
                        ))
                    ), 4),
                    if (isTrue(unref(isMultiSelectMode))) {
                        _cE("view", _uM("key" to 0, "class" to "bottom-toolbar"), _uA(
                            _cE("view", _uM("class" to "toolbar"), _uA(
                                _cV(_component_checkbox, _uM("checked" to unref(isAllSelected), "onClick" to toggleSelectAll), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("text", null, _tD(if (unref(isAllSelected)) {
                                            "取消全选"
                                        } else {
                                            "全选"
                                        }), 1)
                                    )
                                }), "_" to 1), 8, _uA(
                                    "checked"
                                )),
                                _cE("text", _uM("style" to _nS(_uM("margin" to "0px 10px"))), "已选 " + _tD(unref(selectedIds).length) + " 项", 5),
                                _cE("button", _uM("style" to _nS(_uM("margin" to "0px 10px")), "onClick" to exitMultiSelectMode), "取消", 4),
                                _cE("button", _uM("type" to "warn", "disabled" to (unref(selectedIds).length == 0), "onClick" to onBatchDelete), "删除", 8, _uA(
                                    "disabled"
                                ))
                            ))
                        ))
                    } else {
                        _cC("v-if", true)
                    }
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
                return _uM("container" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "backgroundColor" to "#f5f5f5")), "list" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%")), "item-wrapper" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "overflow" to "hidden")), "item-content" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "item-text" to _pS(_uM("fontSize" to 18, "fontWeight" to "bold", "color" to "#ffffff", "textShadow" to "0px 1px 2px rgba(0, 0, 0, 0.3)")), "item-info" to _pS(_uM("fontSize" to 14, "color" to "rgba(255,255,255,0.8)", "marginTop" to 5)), "item-sub-items" to _pS(_uM("width" to "100%", "flexDirection" to "row", "justifyContent" to "center")), "swipe-menu" to _pS(_uM("position" to "absolute", "right" to -80, "top" to 0, "width" to 80, "flexDirection" to "row", "overflow" to "hidden")), "menu-item" to _pS(_uM("width" to 80, "justifyContent" to "center", "alignItems" to "center")), "delete-btn" to _pS(_uM("backgroundColor" to "#ff4d4f")), "menu-text" to _pS(_uM("color" to "#ffffff")), "bottom-toolbar" to _pS(_uM("position" to "absolute", "left" to 0, "right" to 0, "bottom" to 0, "backgroundColor" to "#ffffff", "alignItems" to "center", "paddingLeft" to 15, "paddingRight" to 15, "paddingBottom" to "var(--uni-safe-area-inset-bottom)", "borderTopWidth" to 1, "borderTopColor" to "#e5e5e5", "borderTopStyle" to "solid")), "toolbar" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "marginTop" to 2, "marginRight" to 0, "marginBottom" to 2, "marginLeft" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
