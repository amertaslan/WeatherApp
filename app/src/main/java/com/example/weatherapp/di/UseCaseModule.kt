package com.example.weatherapp.di

import com.example.weatherapp.weathercore.HomeRepository
import com.example.weatherapp.weathercore.HomeUseCase
import org.koin.dsl.module

val useCaseModule = module {

    fun provideUseCase(homeRepository: HomeRepository): HomeUseCase {
        return HomeUseCase(homeRepository)
    }
    single { provideUseCase(get()) }
}