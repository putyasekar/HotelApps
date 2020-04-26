package com.diki.idn.hotelapps.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.diki.idn.hotelapps.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * A simple [Fragment] subclass.
 */
class LocationFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mapView: GoogleMap

    companion object {
        var mapFragment: SupportMapFragment? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_location, container, false)
        mapFragment =
            childFragmentManager.findFragmentById(R.id.fragment_location) as SupportMapFragment

        mapFragment?.getMapAsync(this)

        return view
    }

    override fun onMapReady(p0: GoogleMap?) {
        mapView = p0!!
        val idn = LatLng(-6.174760, 106.827070)

        mapView.addMarker(MarkerOptions().position(idn).title("IDN Akhwat"))
        mapView.moveCamera(CameraUpdateFactory.newLatLng(idn))
    }
}
