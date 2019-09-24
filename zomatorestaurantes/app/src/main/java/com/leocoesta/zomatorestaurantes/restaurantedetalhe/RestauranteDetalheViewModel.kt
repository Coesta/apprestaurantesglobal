package com.leocoesta.zomatorestaurantes.restaurantedetalhe

import androidx.lifecycle.ViewModel;
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class RestauranteDetalheViewModel : ViewModel() {
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
