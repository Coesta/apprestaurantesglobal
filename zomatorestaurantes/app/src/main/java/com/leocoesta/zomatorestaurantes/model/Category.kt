package com.leocoesta.zomatorestaurantes.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryResponse(
    @Json(name = "categories")
    val categories: List<CategoriesResponse>
) : Parcelable

@Parcelize
data class CategoriesResponse(
    @Json(name = "categories")
    val categories: Category
) : Parcelable

@Parcelize
data class Category(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
) : Parcelable

fun CategoryResponse.toListCategory(): List<Category> {
    return categories.map {
        Category(
            id = it.categories.id,
            name = it.categories.name
        )
    }
}