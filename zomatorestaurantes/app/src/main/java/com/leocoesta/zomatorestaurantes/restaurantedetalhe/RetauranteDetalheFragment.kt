package com.leocoesta.zomatorestaurantes.restaurantedetalhe

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.leocoesta.zomatorestaurantes.R

class RetauranteDetalheFragment : Fragment() {

    companion object {
        fun newInstance() = RetauranteDetalheFragment()
    }

    private lateinit var viewModel: RetauranteDetalheViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.retaurante_detalhe_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RetauranteDetalheViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
