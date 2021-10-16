package com.example.weatherapp.di

import com.example.weatherapp.weathercore.RemoteDataSource
import com.example.weatherapp.weathercore.Repository
import org.koin.dsl.module

val repositoryModule = module {

    fun provideRepository(remoteDataSource: RemoteDataSource): Repository {
        return Repository(remoteDataSource)
    }
    single { provideRepository(get()) }
}