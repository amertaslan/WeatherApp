package com.example.weatherapp.di

import com.example.weatherapp.weathercore.RemoteDataSource
import com.example.weatherapp.weathercore.Repository
import com.example.weatherapp.weathercore.UseCase
import org.koin.dsl.module

val useCaseModule = module {

    fun provideUseCase(repository: Repository): UseCase {
        return UseCase(repository)
    }
    single { provideUseCase(get()) }
}