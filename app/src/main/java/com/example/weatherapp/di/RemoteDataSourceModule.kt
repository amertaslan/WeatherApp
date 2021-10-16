package com.example.weatherapp.di

import com.example.weatherapp.weathercore.RemoteDataSource
import com.example.weatherapp.weathercore.WeatherApiService
import org.koin.dsl.module

val remoteDataSourceModule = module {

    fun provideRemoteDataSourceModule(weatherApiService: WeatherApiService): RemoteDataSource {
        return RemoteDataSource(weatherApiService)
    }
    single { provideRemoteDataSourceModule(get()) }

}