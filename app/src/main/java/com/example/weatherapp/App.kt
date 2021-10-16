package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                apiModule,
                useCaseModule,
                networkModule,
                remoteDataSourceModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}