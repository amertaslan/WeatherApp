package com.example.weatherapp.di

import com.example.weatherapp.citylist.CityListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        CityListViewModel(get())
    }
}