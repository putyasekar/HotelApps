package com.diki.idn.hotelapps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.diki.idn.hotelapps.R
import com.diki.idn.hotelapps.model.Model
import kotlinx.android.synthetic.main.item_row_two.view.*

class HotelListAdapter internal constructor(private val context: Context) : BaseAdapter(){

    internal var hotel = arrayListOf<Model>()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_row, p2, false)
        }
        val viewHolder = ViewHolder(view as View)
        val dataHotel = getItem(p0) as Model
        viewHolder.bind(dataHotel)
        return view

    }

    override fun getItem(p0: Int): Any {
        return hotel[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int = hotel.size

    private inner class ViewHolder internal constructor(view: View){
        private val tvTitle : TextView = view.findViewById(R.id.hotel_name)
        private val tvDesc : TextView = view.findViewById(R.id.desc_hotel)
        private val ivImage : ImageView = view.findViewById(R.id.iv_home)

        internal fun bind(model: Model){
            tvTitle.text = model.title
            tvDesc.text = model.desc
            Glide.with(context).load(model.image).circleCrop().into(ivImage)
        }
    }

}