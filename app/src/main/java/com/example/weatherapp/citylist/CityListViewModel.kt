package com.example.weatherapp.citylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.database.citylist.CityData
import com.example.weatherapp.weathercore.Repository
import com.example.weatherapp.weathercore.UseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CityListViewModel(private val useCase: UseCase) : ViewModel() {

    fun fetchCityListResponse(key: String, q: String) : MutableLiveData<List<CityData>> {
        val result = MutableLiveData<List<CityData>>()
        viewModelScope.launch {
            useCase.getCityList(key, q).collect { response ->
                response.let {
                    result.postValue(it.body())
                }
            }
        }
        return result
    }
}