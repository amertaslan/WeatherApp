package com.example.weatherapp.database.citylist

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CityData(
    val id: Int,
    val name: String
)