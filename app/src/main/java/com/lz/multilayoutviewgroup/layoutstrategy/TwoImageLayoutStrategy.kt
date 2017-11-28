package com.lz.camerasample.viewgroup

import android.widget.ImageView

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/27
 * desc   : 两张图的布局
 * version: 1.0
</pre> *
 */
class TwoImageLayoutStrategy : SimpleImageLayoutStrategy() {

    override fun layoutChild(childViewIndex: Int, childView: ImageView, parentWidth: Int, parentHeight: Int) {
        val width = parentWidth / 2
        val top = childViewIndex * width
        val bottom = (childViewIndex + 1) * width
        childView.layout(0, top, parentWidth, bottom)
    }

}
