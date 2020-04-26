package com.diki.idn.hotelapps.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.diki.idn.hotelapps.R
import com.diki.idn.hotelapps.model.Model
import kotlinx.android.synthetic.main.activity_detail_popular_hotel.*

class DetailPopularHotelActivity : AppCompatActivity() {

    companion object {
        const val KEY_POPULAR_HOTEL = "key_popular_hotel"
    }

    private var hotel: Model? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_popular_hotel)

        iv_backstage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        hotel = intent.getParcelableExtra(KEY_POPULAR_HOTEL)

        tv_name_detail_in_populer.text = hotel?.title
        tv_place_detail.text = hotel?.place
        tv_desc_detail.text = hotel?.desc
        Glide.with(this).load(hotel?.image).apply(RequestOptions().override(600))
            .into(iv_image_detail)
    }
}
