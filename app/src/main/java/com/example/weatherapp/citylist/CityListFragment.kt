package com.example.weatherapp.citylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.databinding.FragmentCityListBinding
import com.example.weatherapp.util.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityListFragment : Fragment() {

    private val viewModel by viewModel<CityListViewModel>()
    private lateinit var binding: FragmentCityListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityListBinding.inflate(inflater)

        viewModel.fetchCityListResponse(Constants.API_KEY, "London").observe(viewLifecycleOwner, {
            binding.deneme.text = it.name
        })

        return binding.root
    }
}