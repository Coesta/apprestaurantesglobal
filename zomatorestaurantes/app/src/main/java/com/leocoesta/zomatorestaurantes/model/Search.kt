package com.leocoesta.zomatorestaurantes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Search(
    @Json(name = "results_found")
    val resultsFound: Int,

    @Json(name = "results_start")
    val results_start: Int,

    @Json(name = "results_shown")
    val resultsShown: Int,

    val restaurants: RestaurantResponse
) : Parcelable