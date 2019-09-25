package com.leocoesta.zomatorestaurantes.restaurantedetalhe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.leocoesta.zomatorestaurantes.model.Restaurant

class RestauranteDetalheViewModel(restaurantSelected: Restaurant) : ViewModel() {

    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant>
        get() = _restaurant

    init {
        _restaurant.value = restaurantSelected
    }

    val name = Transformations.map(restaurant){
        it.name
    }

    val endereco = Transformations.map(restaurant){
        it.location.address
    }

    val cuisines = Transformations.map(restaurant){
        it.cuisines
    }

    val timings = Transformations.map(restaurant){
        it.timings
    }

    val image = Transformations.map(restaurant){
        it.featuredImage
    }
}
