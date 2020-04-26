package com.diki.idn.hotelapps.adapter

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.diki.idn.hotelapps.R
import com.diki.idn.hotelapps.model.Model
import kotlinx.android.synthetic.main.item_staggered.view.*

class StaggeredAdapter(private val listener: (Model) -> Unit) :
    RecyclerView.Adapter<StaggeredAdapter.HotelViewHolder>() {
    private val listStaggered = ArrayList<Model>()

    fun setData(items: ArrayList<Model>) {
        listStaggered.clear()
        listStaggered.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_staggered, parent, false)
        return HotelViewHolder(view)
    }

    override fun getItemCount(): Int = listStaggered.size

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bind(listStaggered[position], listener)
    }

    class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hotel: Model, listener: (Model) -> Unit) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hotel.image)
                    .apply(RequestOptions().override(600))
                    .into(iv_staggered)

                title_staggered.text = hotel.title
                tv_address_title.text = hotel.place
                tv_desc_title.text = hotel.desc

                itemView.setOnClickListener { listener(hotel) }
            }
        }
    }
}