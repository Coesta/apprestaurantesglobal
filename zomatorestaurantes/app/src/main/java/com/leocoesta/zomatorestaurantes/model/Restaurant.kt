package com.leocoesta.zomatorestaurantes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurants(
    var restaurant: Restaurant
) : Parcelable

@Parcelize
data class Restaurant(
    val id: Int,
    val name: String,
    val url: String,
    val location: LocationRestaurant,
    val cuisines: String,
    val timings: String,
    @Json(name = "has_online_delivery")
    val hasOnlineDelivery: Int,
    val thumb: String,
    @Json(name = "featured_image")
    val featuredImage: String
) : Parcelable