package com.leocoesta.zomatorestaurantes.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leocoesta.zomatorestaurantes.enum.EntityType
import com.leocoesta.zomatorestaurantes.model.Category
import com.leocoesta.zomatorestaurantes.model.Restaurant
import com.leocoesta.zomatorestaurantes.model.toListCategory
import com.leocoesta.zomatorestaurantes.model.toListRestaurant
import com.leocoesta.zomatorestaurantes.network.ZomatoApi
import com.leocoesta.zomatorestaurantes.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val repository = Repository()

    private var _restaurantes = MutableLiveData<List<Restaurant>>()
    val restaurantes: LiveData<List<Restaurant>>
        get() = _restaurantes

    private var _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>>
        get() = _categories

//    "entity_id": 67,
//    "title": "São Paulo",
//    "latitude": -23.536,
//    "longitude": -46.629,

//    entity_id": 80,
//    "title": "Salvador",
//    "latitude": -12.9747,
//    "longitude": -38.4767,

    init {
        viewModelScope.launch {
            val resultadoBusca = ZomatoApi.zomato.search(67, EntityType.CITY.name, 5, -23.536, -46.629)
            _restaurantes.value = resultadoBusca.toListRestaurant()
            _categories.value = ZomatoApi.zomato.getCategories().toListCategory()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
