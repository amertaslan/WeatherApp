package com.example.weatherapp.weathercore

data class CityForecastResponse (
    val forecast: ForecastResponse
)

data class ForecastResponse (
    val forecastday: List<ForecastDayResponse>
)

data class ForecastDayResponse (
    val hour: List<HourResponse>
)

data class HourResponse (
    val time: String,
    val temp_c: String
)