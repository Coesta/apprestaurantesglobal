package com.leocoesta.zomatorestaurantes.repository

import androidx.lifecycle.MutableLiveData
import com.leocoesta.zomatorestaurantes.enum.EntityType
import com.leocoesta.zomatorestaurantes.model.CategoriesResponse
import com.leocoesta.zomatorestaurantes.model.Restaurant
import com.leocoesta.zomatorestaurantes.network.ZomatoApi

class Repository {

//    suspend fun getRestaurants(): MutableLiveData<List<Restaurant>> {
//
//        val restaurants = MutableLiveData<List<Restaurant>>()
//
//        restaurants.value = ZomatoApi.zomato.search(80, EntityType.CITY.name).restaurants
//
//        return restaurants
//    }

    suspend fun getCategories(): MutableLiveData<List<CategoriesResponse>> {

        val categories = MutableLiveData<List<CategoriesResponse>>()

        categories.value = ZomatoApi.zomato.getCategories().categories

        return categories
    }
}