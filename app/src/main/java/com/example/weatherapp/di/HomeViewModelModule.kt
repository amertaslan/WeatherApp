package com.example.weatherapp.di

import com.example.weatherapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {

    viewModel {
        HomeViewModel(get())
    }
}