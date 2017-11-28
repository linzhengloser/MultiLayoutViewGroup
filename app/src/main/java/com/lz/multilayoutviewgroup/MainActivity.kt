package com.lz.multilayoutviewgroup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = RecyclerViewAdapter()
    }

    //RecyclerView Adapter

    class RecyclerViewAdapter : RecyclerView.Adapter<ViewHolder>() {

        val imageUrl1 = "http://ofdvg4c5w.bkt.clouddn.com/%E7%BA%B1%E9%9B%BE.jpg"

        val imageUrl2 = "http://ofdvg4c5w.bkt.clouddn.com/%E5%B9%BD%E7%81%B5%E8%A1%8C%E5%8A%A8.jpg"

        val imageUrl3 = "http://ofdvg4c5w.bkt.clouddn.com/%E7%8B%82%E4%B8%89.jpg"

        val imageUrl4 = "http://ofdvg4c5w.bkt.clouddn.com/%E7%90%B4%E9%87%8C%E5%92%8C%E5%9B%9B%E7%B3%B8%E4%B9%83.jpg"

        val imageUrl5 = "http://ofdvg4c5w.bkt.clouddn.com/%E7%A9%B9%E5%A6%B9.jpg"

        override fun getItemCount(): Int = 100

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            when {
                position % 2 == 0 -> holder.itemView.ml_layout.setData(mutableListOf(
                        imageUrl1, imageUrl2, imageUrl3, imageUrl4, imageUrl5, imageUrl1, imageUrl2, imageUrl3, imageUrl4
                ))
                position % 3 == 0 -> holder.itemView.ml_layout.setData(mutableListOf(imageUrl1, imageUrl2, imageUrl3))
                position % 5 == 0 -> holder.itemView.ml_layout.setData(mutableListOf(imageUrl1))
                else -> holder.itemView.ml_layout.setData(mutableListOf(imageUrl1, imageUrl2))
            }
            holder.itemView.tv_title.text = "position = $position "
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
                = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
