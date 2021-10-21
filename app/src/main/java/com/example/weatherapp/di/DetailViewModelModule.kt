package com.example.weatherapp.di

import com.example.weatherapp.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailViewModelModule = module {

    viewModel {
        DetailViewModel(get())
    }
}