package com.diki.idn.hotelapps.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.diki.idn.hotelapps.R
import com.diki.idn.hotelapps.activity.DetailPopularHotelActivity
import com.diki.idn.hotelapps.activity.PopularActivity
import com.diki.idn.hotelapps.adapter.HotelAdapter
import com.diki.idn.hotelapps.adapter.HotelListAdapter
import com.diki.idn.hotelapps.model.Model
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    //    private val hotelList = ArrayList<Model>()
    private lateinit var popularHotelAdapter: HotelAdapter

    companion object {
        fun defaultFragment(): HomeFragment {
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    val imageContentSlider = intArrayOf(
        R.drawable.photo_1,
        R.drawable.photo_2,
        R.drawable.photo_3,
        R.drawable.photo_4,
        R.drawable.photo_5
    )
    val imageContentListener: ImageListener =
        ImageListener { position: Int, imageView: ImageView ->
            imageView.setImageResource(imageContentSlider[position])
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = is_main as CarouselView
        carouselView.setImageListener(imageContentListener)
        carouselView.pageCount = imageContentSlider.count()

        showRecyclerList()
        showSelected()
    }

    private fun showSelected() {
        see_more.setOnClickListener {
            val intent = Intent(context, PopularActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showRecyclerList() {
        popularHotelAdapter = HotelAdapter { showDetail(it) }
        popularHotelAdapter.notifyDataSetChanged()
        popularHotelAdapter.setData(getListHotel())
        rv_popular.setHasFixedSize(true)
        rv_popular.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        val listHotelAdapter = HotelListAdapter(hotelList)
        rv_popular.adapter = popularHotelAdapter
    }

    private fun showDetail(it: Model) {
        val page = Intent(context, DetailPopularHotelActivity::class.java)
        page.putExtra(DetailPopularHotelActivity.KEY_POPULAR_HOTEL, it)
        startActivity(page)
    }

    private fun getListHotel(): ArrayList<Model> {
        val dataName = resources.getStringArray(R.array.title)
        val dataDesc = resources.getStringArray(R.array.desc)
        val dataPlace = resources.getStringArray(R.array.place)
        val dataImage = resources.obtainTypedArray(R.array.image)

        val listHotel = ArrayList<Model>()

        for (position in dataName.indices) {
            val hotel = Model(
                dataName[position],
                dataDesc[position],
                dataPlace[position],
                dataImage.getResourceId(position, -1)
            )
            listHotel.add(hotel)
        }
        return listHotel
    }

//    private fun addIntent() {
//        see_more.setOnClickListener {
//            val list = Intent(context, HotelListActivity::class.java)
//            startActivity(list)
//        }
//    }

}