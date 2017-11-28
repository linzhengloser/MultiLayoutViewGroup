package com.lz.camerasample.viewgroup

import android.widget.ImageView

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/28
 * desc   : 单张图片的布局
 * version: 1.0
</pre> *
 */
class SingleImageLayoutStrategy : SimpleImageLayoutStrategy() {

    override fun layoutChild(childViewIndex: Int, childView: ImageView, parentWidth: Int, parentHeight: Int) {
        childView.layout(0, 0, parentWidth, parentHeight)
    }

    override fun parentHeight(): Int = 800

    override fun parentWidth(): Int = 600

}
