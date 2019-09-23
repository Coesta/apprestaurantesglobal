package com.leocoesta.zomatorestaurantes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryResponse(
    @Json(name = "categories")
    val categories: List<Category?>
) : Parcelable

@Parcelize
data class Category(
    @Json(name = "categories")
    val categories: Categories?
) : Parcelable

@Parcelize
data class Categories(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
) : Parcelable