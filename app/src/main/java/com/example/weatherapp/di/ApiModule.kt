package com.example.weatherapp.di

import com.example.weatherapp.weathercore.WeatherApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideCityListApi(retrofit: Retrofit): WeatherApiService {
        return retrofit.create(WeatherApiService::class.java)
    }
    single { provideCityListApi(get()) }
}
