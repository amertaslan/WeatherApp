package com.example.weatherapp.detail

import org.koin.androidx.viewmodel.ext.android.viewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.databinding.FragmentDetailBinding
import com.example.weatherapp.util.Constants

class DetailFragment : Fragment() {

    private val viewModel by viewModel<DetailViewModel>()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)

        val cityName = DetailFragmentArgs.fromBundle(requireArguments()).cityName

        getCityForecastWeather(cityName)

        return binding.root
    }

    private fun getCityForecastWeather(cityName: String) {
        viewModel.fetchCityForecastWeather(Constants.API_KEY, cityName).observe(viewLifecycleOwner, {
            binding.forecastList.adapter = DetailAdapter(viewModel.getForecastData(it!!))
        })
    }
}