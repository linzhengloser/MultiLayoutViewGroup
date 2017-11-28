package com.lz.camerasample.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/11/27
 *     desc   : 多布局 ViewGroup
 *     version: 1.0
 * </pre>
 */
class MultiLayoutViewGroup : ViewGroup {

    private var mDatas: MutableList<String> = mutableListOf()

    private var mLayoutStrategyList: SparseArray<LayoutStrategy<*, *>> = SparseArray()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (mDatas.isEmpty()) return
        recycleChild()
        val layoutStrategy = getLayoutStrategy()
        val parentWidth = layoutStrategy.parentWidth()
        val parentHeight = layoutStrategy.parentHeight()

        if (parentWidth == LayoutParams.MATCH_PARENT && parentHeight == LayoutParams.MATCH_PARENT) {
            super.onMeasure(widthMeasureSpec, widthMeasureSpec)
        } else {
            setMeasuredDimension(parentWidth, parentHeight)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (mDatas.isEmpty()) return
        layoutChild()
    }

    init {
        mLayoutStrategyList.put(1, SingleImageLayoutStrategy())
        mLayoutStrategyList.put(2, TwoImageLayoutStrategy())
        mLayoutStrategyList.put(3, ThreeImageLayoutStrategy())
        mLayoutStrategyList.put(9, NineGridLayoutStrategy())
    }

    /**
     * 设置数据
     */
    fun setData(datas: MutableList<String>) {
        mDatas.clear()
        mDatas.addAll(datas)
        requestLayout()
    }

    /**
     * 判断子 View 个数，多则加，少则减。
     */
    private fun recycleChild() {
        val dataSize = mDatas.size
        val diff = childCount - dataSize
        if (diff > 0) {
            removeViews(dataSize - 1, diff)
        } else if (diff < 0) {
            repeat(Math.abs(diff)) {
                val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
                addView(ImageView(context), layoutParams)
            }
        }
        repeat(childCount) {
            getChildAt(it).tag = null
        }
//        removeAllViews()
//        repeat(mDatas.size) {
//            val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
//            addView(ImageView(context), layoutParams)
//        }
    }


    private fun getLayoutStrategy(): LayoutStrategy<*, *> = mLayoutStrategyList.get(childCount, NineGridLayoutStrategy())

    /**
     * 对子 View layout
     */
    private fun layoutChild() {
        var layoutStrategy = getLayoutStrategy()
        repeat(childCount) {
            (layoutStrategy as LayoutStrategy<*, View>).layoutChild(it, getChildAt(it), width, height)
            (layoutStrategy as LayoutStrategy<String, View>).bindChild(getChildAt(it), mDatas[it])
        }
    }

}