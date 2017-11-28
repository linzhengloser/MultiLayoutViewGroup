package com.lz.camerasample.viewgroup

import android.view.View
import android.view.ViewGroup

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/27
 * desc   : 布局策略
 * version: 1.0
</pre> *
 */
abstract class LayoutStrategy<in T, in V : View> {

    open abstract fun layoutChild(
            childViewIndex: Int,
            childView: V,
            parentWidth: Int,
            parentHeight: Int
    )

    open abstract fun bindChild(childView: V, data: T)

    open fun parentWidth(): Int = ViewGroup.LayoutParams.MATCH_PARENT

    open fun parentHeight(): Int = ViewGroup.LayoutParams.MATCH_PARENT

}
