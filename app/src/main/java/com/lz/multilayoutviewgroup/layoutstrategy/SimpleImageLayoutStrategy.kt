package com.lz.camerasample.viewgroup

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/28
 * desc   : 实现加载图片
 * version: 1.0
</pre> *
 */
abstract class SimpleImageLayoutStrategy : LayoutStrategy<String, ImageView>() {

    override fun bindChild(childView: ImageView, data: String) {
        Glide.with(childView.context)
                .load(data)
                .apply(RequestOptions.centerCropTransform())
                .into(childView)
    }

}
