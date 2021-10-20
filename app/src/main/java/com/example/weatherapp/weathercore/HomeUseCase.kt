package com.example.weatherapp.weathercore

import kotlinx.coroutines.flow.map
import retrofit2.Response
import kotlinx.coroutines.flow.Flow

class HomeUseCase(private val homeRepository: HomeRepository) {
    suspend fun getCityList(key: String, q: String) : Flow<Response<List<CityListResponse>>> {
        return homeRepository.getCityList(key, q).map { response ->
            response
        }
    }

    suspend fun getCityCurrentWeather(key: String, q: String) : Flow<Response<CityCurrentResponse>> {
        return homeRepository.getCityCurrentWeather(key, q).map { response ->
            response
        }
    }
}