package com.leocoesta.zomatorestaurantes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationResponse(
    @Json(name = "location_suggestions")
    val locationSuggestions: List<Location>,
    val status: String,
    @Json(name = "has_more")
    val hasMore: Int,
    @Json(name = "has_total")
    val hasTotal: Int
) : Parcelable

@Parcelize
data class LocationSuggestion(
    @Json(name = "location_suggestions")
    val locationSuggestion: Location
) : Parcelable

@Parcelize
data class Location(
    @Json(name = "entity_type")
    val entityType: String,

    @Json(name = "entity_id")
    val entityId: Int,

    val title: String,
    val latitude: String,
    val longitude: String,

    @Json(name = "city_id")
    val cityId: Int,

    @Json(name = "city_name")
    val cityName: String,

    @Json(name = "country_id")
    val countryId: Int,

    @Json(name = "country_name")
    val countryName: String
) : Parcelable