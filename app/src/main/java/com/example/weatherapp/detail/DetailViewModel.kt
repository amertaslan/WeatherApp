package com.example.weatherapp.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.weathercore.CityForecastResponse
import com.example.weatherapp.weathercore.HomeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(private val homeUseCase: HomeUseCase) : ViewModel() {

    private val forecastData: List<DetailModel> = listOf()

    fun fetchCityForecastWeather(key: String, q: String) : MutableLiveData<CityForecastResponse> {
        val result = MutableLiveData<CityForecastResponse>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                homeUseCase.getCityForecastWeather(key, q).collect { response ->
                    response.let {
                        result.postValue(it.body())
                    }
                }
            }
        }
        return result
    }

    fun getForecastData(response: CityForecastResponse) : List<DetailModel> {
        response.forecast.forecastday.forEach { hourResponse ->
            hourResponse.hour.forEach {
                forecastData.plusElement(DetailModel(it.temp_c, it.time))
            }
        }
        return forecastData
    }

}