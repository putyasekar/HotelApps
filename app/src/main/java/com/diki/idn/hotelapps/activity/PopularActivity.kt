package com.diki.idn.hotelapps.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.diki.idn.hotelapps.R
import com.diki.idn.hotelapps.adapter.HotelAdapter
import com.diki.idn.hotelapps.adapter.StaggeredAdapter
import com.diki.idn.hotelapps.model.Model
import kotlinx.android.synthetic.main.activity_detail_popular_hotel.*
import kotlinx.android.synthetic.main.activity_popular.*

class PopularActivity : AppCompatActivity() {
    //    private val listHotel = ArrayList<Model>()
    private lateinit var popularHotelAdapter: StaggeredAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular)

//        listHotel.addAll(getListHotel())
        supportActionBar?.hide()
        showRecyclerGrid()

        iv_home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListHotel(): ArrayList<Model> {
        val dataName = resources.getStringArray(R.array.title)
        val dataPlace = resources.getStringArray(R.array.place)
        val dataDesc = resources.getStringArray(R.array.desc)
        val dataImage =
            resources.obtainTypedArray(R.array.image)

        val listHotel = ArrayList<Model>()

        for (position in dataName.indices) {
            val hotel = Model(
                dataName[position],
                dataPlace[position],
                dataDesc[position],
                dataImage.getResourceId(position, -1)
            )
            listHotel.add(hotel)
        }
        return listHotel
    }

    private fun showRecyclerGrid() {
        popularHotelAdapter = StaggeredAdapter { showSelected(it) }
        popularHotelAdapter.notifyDataSetChanged()
        popularHotelAdapter.setData(getListHotel())
        all_popular.setHasFixedSize(true)
        val layoutManagerStaggered =
            StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        all_popular.layoutManager = layoutManagerStaggered
        all_popular.adapter = popularHotelAdapter
    }

    private fun showSelected(it: Model) {
        val page = Intent(this, DetailPopularHotelActivity::class.java)
        page.putExtra(DetailPopularHotelActivity.KEY_POPULAR_HOTEL, it)
        startActivity(page)
    }
}
