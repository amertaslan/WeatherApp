package com.example.weatherapp.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.weathercore.CityCurrentResponse
import com.example.weatherapp.weathercore.CityListResponse
import com.example.weatherapp.weathercore.HomeUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val homeUseCase: HomeUseCase) : ViewModel() {

    fun fetchCityListResponse(key: String, q: String) : MutableLiveData<List<CityListResponse>> {
        val result = MutableLiveData<List<CityListResponse>>()
        viewModelScope.launch {
            homeUseCase.getCityList(key, q).collect { response ->
                response.let {
                    result.postValue(it.body())
                }
            }
        }
        return result
    }

    fun fetchCityCurrentResponse(key: String, q: String) : MutableLiveData<CityCurrentResponse> {
        val result = MutableLiveData<CityCurrentResponse>()
        viewModelScope.launch {
            homeUseCase.getCityCurrentWeather(key, q).collect { response ->
                response.let {
                    result.postValue(it.body())
                }
            }
        }
        return result
    }
}