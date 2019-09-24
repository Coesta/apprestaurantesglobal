package com.leocoesta.zomatorestaurantes.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.leocoesta.zomatorestaurantes.R
import com.leocoesta.zomatorestaurantes.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: HomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false
        )

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        binding.viewModel = homeViewModel

        binding.lifecycleOwner = this

        return binding.root
    }

}
