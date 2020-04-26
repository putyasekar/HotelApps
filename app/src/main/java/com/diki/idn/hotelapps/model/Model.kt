package com.diki.idn.hotelapps.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(
    var title: String,
    var desc: String,
    var place: String,
    var image: Int
) : Parcelable