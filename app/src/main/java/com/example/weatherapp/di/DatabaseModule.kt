package com.example.weatherapp.di

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
/*
val databaseModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "cities")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideCountriesDao(database: AppDatabase): CityDatabaseDao {
        return database.cityDatabaseDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideCountriesDao(get()) }
}*/