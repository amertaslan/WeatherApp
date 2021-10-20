package com.example.weatherapp.di

import com.example.weatherapp.weathercore.HomeRemoteDataSource
import com.example.weatherapp.weathercore.HomeApiService
import org.koin.dsl.module

val remoteDataSourceModule = module {

    fun provideRemoteDataSourceModule(homeApiService: HomeApiService): HomeRemoteDataSource {
        return HomeRemoteDataSource(homeApiService)
    }
    single { provideRemoteDataSourceModule(get()) }
}