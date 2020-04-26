package com.diki.idn.hotelapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.diki.idn.hotelapps.model.Model
import com.diki.idn.hotelapps.R
import kotlinx.android.synthetic.main.item_row_two.view.*

class HotelAdapter(private val listener: (Model) -> Unit) :
    RecyclerView.Adapter<HotelAdapter.ViewHolder>() {

    private val listHotel = ArrayList<Model>()

    fun setData(items: ArrayList<Model>) {
        listHotel.clear()
        listHotel.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_two, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listHotel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHotel[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hotel: Model, listener: (Model) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hotel.image)
                    .apply(RequestOptions())
                    .override(300)
                    .into(iv_popular)

                tv_title.text = hotel.title
                tv_place.text = hotel.place

                itemView.setOnClickListener { listener(hotel) }
            }
        }
    }
}

//
//    internal var hotels = arrayListOf<Model>()
//    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//        var view = p1
//        if (view == null) {
//            view = LayoutInflater.from(context).inflate(R.layout.item_row, p2, false)
//        }
//        val viewHolder = ViewHolder(view as View)
//        val hotel = getItem(p0) as Model
//        viewHolder.bind(hotel)
//
//        return view
//    }
//
//    override fun getItem(p0: Int): Any {
//        return hotels[p0]
//    }
//
//    override fun getItemId(p0: Int): Long {
//        return p0.toLong()
//    }
//
//    override fun getCount(): Int = hotels.size
//
//    inner class ViewHolder internal constructor(itemView: View) :
//        RecyclerView.ViewHolder(itemView) {
//        private val title: TextView = itemView.findViewById(R.id.hotel_name)
//        private val address: TextView = itemView.findViewById(R.id.desc_hotel)
//        private val image: ImageView = itemView.findViewById(R.id.icon_hotel)
//
//        internal fun bind(hotel: Model) {
//            title.text = hotel.title
//            address.text = hotel.desc
//            Glide.with(context).load(hotel.image).circleCrop().override(100).into(image)
//        }
//    }