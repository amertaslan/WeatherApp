package com.example.weatherapp.weathercore

class RemoteDataSource(private val weatherApiService: WeatherApiService) {
    suspend fun getResponse(key: String, q: String) = weatherApiService.getCityList(key, q)
}