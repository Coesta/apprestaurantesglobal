package com.leocoesta.zomatorestaurantes.network

import com.leocoesta.zomatorestaurantes.util.Util.Companion.API_KEY
import com.leocoesta.zomatorestaurantes.util.Util.Companion.BASE_URL
import com.leocoesta.zomatorestaurantes.model.CategoryResponse
import com.leocoesta.zomatorestaurantes.model.LocationResponse
import com.leocoesta.zomatorestaurantes.model.SearchResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ZomatoApiService {
    @Headers("user-key: $API_KEY")
    @GET(value = "categories")
    suspend fun getCategories(): CategoryResponse


    @Headers("user-key: $API_KEY")
    @GET(value = "locations")
    suspend fun getLocations(
        @Query(value = "q") query: String,
        @Query(value = "lat") latitude: Double?,
        @Query(value = "lon") longitude: Double?,
        @Query(value = "count") maxResultsToFetch: Int?
    ): LocationResponse

    @Headers("user-key: $API_KEY")
    @GET(value = "search")
    suspend fun search(
        @Query(value = "entity_id") entityId: Int,
        @Query(value ="entity_type") entityType: String
    ): SearchResponse
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

