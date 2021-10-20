package com.example.weatherapp.di

import com.example.weatherapp.weathercore.HomeRemoteDataSource
import com.example.weatherapp.weathercore.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {

    fun provideRepository(homeRemoteDataSource: HomeRemoteDataSource): HomeRepository {
        return HomeRepository(homeRemoteDataSource)
    }
    single { provideRepository(get()) }
}