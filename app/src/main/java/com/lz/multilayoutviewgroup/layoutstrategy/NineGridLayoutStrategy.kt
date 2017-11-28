package com.lz.camerasample.viewgroup

import android.widget.ImageView

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/27
 * desc   : 九宫格 Layout Strategy
 * version: 1.0
</pre> *
 */
class NineGridLayoutStrategy : SimpleImageLayoutStrategy() {

    val gap: Int = 20

    override fun layoutChild(childViewIndex: Int, childView: ImageView, parentWidth: Int, parentHeight: Int) {
        val row = childViewIndex / 3 + 1
        val column = childViewIndex % 3 + 1
        val width = parentWidth / 3
        val left = if (column > 1) (column - 1) * width + gap else (column - 1) * width
        val top = if (row > 1) (row - 1) * width + gap else (row - 1) * width
        childView.layout(left, top, column * width, row * width)
    }

}
