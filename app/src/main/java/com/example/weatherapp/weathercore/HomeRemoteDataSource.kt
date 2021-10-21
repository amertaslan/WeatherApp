package com.example.weatherapp.weathercore

class HomeRemoteDataSource(private val homeApiService: HomeApiService) {

    suspend fun getCityList(key: String, q: String) = homeApiService.getCityList(key, q)

    suspend fun getCityCurrentWeather(key: String, q: String) = homeApiService.getCityCurrentWeather(key, q)

    suspend fun getCityForecastWeather(key: String, q: String) = homeApiService.getCityForecastWeather(key, q)
}