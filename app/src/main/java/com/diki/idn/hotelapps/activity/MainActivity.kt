package com.diki.idn.hotelapps.activity

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.diki.idn.hotelapps.model.Model
import com.diki.idn.hotelapps.R
import com.diki.idn.hotelapps.adapter.HotelAdapter
import com.diki.idn.hotelapps.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private lateinit var hotelAdapter: HotelAdapter
//    private var models = arrayListOf<Model>()
//    private lateinit var title: Array<String>
//    private lateinit var desc: Array<String>
//    private lateinit var image: TypedArray

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val homeFragment = HomeFragment()
                    addFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_booking -> {
                    val bookingFragment = MyBookingFragment()
                    addFragment(bookingFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_inbox -> {
                    val inboxFragment = LocationFragment()
                    addFragment(inboxFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_history -> {
                    val historyFragment = HistoryFragment()
                    addFragment(historyFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_profile -> {
                    val profileFragment = ProfileFragment()
                    addFragment(profileFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment, fragment::class.java.simpleName)
            .addToBackStack(null).commit()
    }

    val defaultMainView = HomeFragment.defaultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        addFragment(defaultMainView)

//        hotelAdapter = HotelAdapter(this)
//        list_view.adapter = hotelAdapter
//        attachData()
//        loadData()
//    }
//
//    private fun loadData() {
//        for (p0 in title.indices) {
//            val model = Model(
//                title[p0],
//                desc[p0],
//                image.getResourceId(p0, -1)
//            )
//            models.add(model)
//        }
//        hotelAdapter.hotels = models
//    }
//
//    private fun attachData() {
//        title = resources.getStringArray(R.array.title)
//        desc = resources.getStringArray(R.array.desc)
//        image = resources.obtainTypedArray(R.array.image)
    }
}
