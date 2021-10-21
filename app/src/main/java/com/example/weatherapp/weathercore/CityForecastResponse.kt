package com.example.weatherapp.weathercore

data class CityForecastResponse (
    val location: LocationResponse,
    val current: CurrentResponse
)