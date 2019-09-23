package com.leocoesta.zomatorestaurantes.network

import com.leocoesta.zomatorestaurantes.Util.Companion.BASE_URL
import com.leocoesta.zomatorestaurantes.model.CategoryResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

//user-key: dc0b52faed0ea45b0f7bd744330deb38

interface ZomatoApiService {
    @Headers("user-key: dc0b52faed0ea45b0f7bd744330deb38")
    @GET(value = "categories")
    suspend fun getCategories(): CategoryResponse
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object ZomatoApi {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val zomato = retrofit.create(ZomatoApiService::class.java)
}

