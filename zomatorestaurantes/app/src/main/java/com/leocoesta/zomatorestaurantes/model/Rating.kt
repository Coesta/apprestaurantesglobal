package com.leocoesta.zomatorestaurantes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rating(
    @Json(name = "aggregate_rating")
    val aggregateRating : String,

    @Json(name = "rating_text")
    val ratingText : String,

    val votes : String
): Parcelable