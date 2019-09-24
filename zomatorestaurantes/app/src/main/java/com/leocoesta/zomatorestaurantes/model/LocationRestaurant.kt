package com.leocoesta.zomatorestaurantes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationRestaurant(

    val address: String,
    val locality: String,
    val city: String,
    val latitude: String,
    val longitude: String,
    val zipcode: String,
    @Json(name = "country_id")
    val countryId: String

): Parcelable