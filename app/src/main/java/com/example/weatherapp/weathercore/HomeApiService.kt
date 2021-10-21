package com.example.weatherapp.weathercore

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiService {
    @GET("search.json?")
    suspend fun getCityList(@Query("key") key: String, @Query("q") q: String): Response<List<CityListResponse>>

    @GET("current.json?")
    suspend fun getCityCurrentWeather(@Query("key") key: String, @Query("q") q: String): Response<CityCurrentResponse>

    @GET("forecast.json?")
    suspend fun getCityForecastWeather(@Query("key") key: String, @Query("q") q: String): Response<CityForecastResponse>
}