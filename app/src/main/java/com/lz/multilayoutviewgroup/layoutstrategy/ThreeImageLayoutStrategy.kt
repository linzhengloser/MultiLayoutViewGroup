package com.lz.camerasample.viewgroup

import android.widget.ImageView

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/27
 * desc   : 三张图的布局
 * version: 1.0
</pre> *
 */
class ThreeImageLayoutStrategy : SimpleImageLayoutStrategy() {

    override fun layoutChild(childViewIndex: Int, childView: ImageView, parentWidth: Int, parentHeight: Int) {
        val width = parentWidth / 2
        if (childViewIndex / 2 != 0) {
            //第三个图
            childView.layout(width, 0, parentWidth, parentWidth)
        } else {
            childView.layout(0, childViewIndex * width, width, (childViewIndex + 1) * width)
        }
    }

    override fun parentWidth(): Int = 800

    override fun parentHeight(): Int = 800

}
