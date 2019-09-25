package com.leocoesta.zomatorestaurantes.restaurantedetalhe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leocoesta.zomatorestaurantes.model.Restaurant

class RestauranteDetalheViewModelFactory(private val restaurantSelected: Restaurant) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestauranteDetalheViewModel::class.java)) {
            return RestauranteDetalheViewModel(restaurantSelected = restaurantSelected) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}