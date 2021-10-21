package com.example.weatherapp.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.weathercore.CityForecastResponse
import com.example.weatherapp.weathercore.HomeUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailViewModel(private val homeUseCase: HomeUseCase) : ViewModel() {
    fun fetchCityForecastWeather(key: String, q: String) : MutableLiveData<CityForecastResponse> {
        val result = MutableLiveData<CityForecastResponse>()
        viewModelScope.launch {
            homeUseCase.getCityForecastWeather(key, q).collect { response ->
                response.let {
                    result.postValue(it.body())
                }
            }
        }
        return result
    }
}