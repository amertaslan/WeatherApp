package com.example.weatherapp.di

import com.example.weatherapp.weathercore.HomeApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideCityListApi(retrofit: Retrofit): HomeApiService {
        return retrofit.create(HomeApiService::class.java)
    }
    single { provideCityListApi(get()) }
}
