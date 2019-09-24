package com.leocoesta.zomatorestaurantes.restaurantedetalhe

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.leocoesta.zomatorestaurantes.R
import com.leocoesta.zomatorestaurantes.databinding.RetauranteDetalheFragmentBinding

class RestauranteDetalheFragment : Fragment() {

    companion object {
        fun newInstance() = RestauranteDetalheFragment()
    }

    private lateinit var restauranteDetalheViewModel: RestauranteDetalheViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: RetauranteDetalheFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.retaurante_detalhe_fragment, container, false
        )

        restauranteDetalheViewModel = ViewModelProviders.of(this).get(RestauranteDetalheViewModel::class.java)

        binding.viewModel = restauranteDetalheViewModel

        binding.lifecycleOwner = this

        return binding.root
    }

}
