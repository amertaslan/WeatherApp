package com.example.weatherapp.weathercore

import com.example.weatherapp.database.citylist.CityData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("search.json?")
    suspend fun getCityList(@Query("key") key: String, @Query("q") q: String): Response<List<CityData>>
}