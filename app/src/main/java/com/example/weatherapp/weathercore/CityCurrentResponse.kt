package com.example.weatherapp.weathercore

data class CityCurrentResponse (
    val location: LocationResponse,
    val current: CurrentResponse
)

data class LocationResponse (
    val region: String
)

data class CurrentResponse (
    val temp_c: String,
    val condition: ConditionResponse
)

data class ConditionResponse (
    val text: String
)