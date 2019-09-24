package com.leocoesta.zomatorestaurantes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.leocoesta.zomatorestaurantes.model.Restaurant
import com.leocoesta.zomatorestaurantes.network.ZomatoApi

class Repository {

    suspend fun getRestaurants(): LiveData<List<Restaurant>> {

        val restaurants = MutableLiveData<List<Restaurant>>()

        restaurants.value = ZomatoApi.zomato.search().restaurantes

        return restaurants
    }
}