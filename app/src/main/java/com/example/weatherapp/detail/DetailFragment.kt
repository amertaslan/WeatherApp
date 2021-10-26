package com.example.weatherapp.detail

import org.koin.androidx.viewmodel.ext.android.viewModel
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.databinding.FragmentDetailBinding
import com.example.weatherapp.util.Constants
import com.example.weatherapp.util.bindImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private val viewModel by viewModel<DetailViewModel>()
    private lateinit var binding: FragmentDetailBinding
    private var forecastData: ArrayList<DetailModel> = arrayListOf()
    private lateinit var adapter: DetailAdapter

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
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.fetchCityForecastWeather(Constants.API_KEY, cityName).observe(viewLifecycleOwner, { response ->
                binding.detailCityNameTextView.text = response.location.region
                bindImage(binding.detailImage, "https:" + response.current.condition.icon)
                binding.detailDegree.text = response.current.temp_c
                response.forecast.forecastday.forEach { hourResponse ->
                    hourResponse.hour.forEach {
                        forecastData.add(DetailModel(it.temp_c, it.time))
                    }
                }
                binding.forecastList.adapter = DetailAdapter(forecastData)
                Log.e("asasdasd", forecastData[0].hour)
            })
        }
    }
}