package com.leocoesta.zomatorestaurantes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResponse(
    @Json(name = "results_found")
    val resultsFound: Int,

    @Json(name = "results_start")
    val results_start: Int,

    @Json(name = "results_shown")
    val resultsShown: Int,

    val restaurants: List<Restaurants>
) : Parcelable

fun SearchResponse.toListRestaurant(): List<Restaurant> {
    return restaurants.map {
        Restaurant(
            id = it.restaurant.id,
            name = it.restaurant.name,
            url = it.restaurant.url,
            location = it.restaurant.location,
            cuisines = it.restaurant.cuisines,
            timings = it.restaurant.timings,
            hasOnlineDelivery = it.restaurant.hasOnlineDelivery
        )
    }
}