package com.leocoesta.zomatorestaurantes.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.leocoesta.zomatorestaurantes.R
import com.leocoesta.zomatorestaurantes.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: HomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        binding.viewModel = homeViewModel

        binding.lifecycleOwner = this

        homeViewModel.restaurantes.observe(viewLifecycleOwner, Observer {
            it?.let { restaurantes ->
                resultado.text = restaurantes.toString()
            }
        })

//        homeViewModel.restaurantesEncontrados.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                resultado.text = it.toString()
//            }
//        })

//        homeViewModel.categories.observe(viewLifecycleOwner, Observer {
//            resultado.text = it.toString()
//        })

        return binding.root
    }

}
