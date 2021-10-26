package com.example.weatherapp.home

data class ViewPagerItemModel (
    var layoutId: Int,
    var cityName: String,
    val tempC: String,
    val tempF: String,
    val feelsLikeC: String,
    val feelsLikeF: String,
    val degreeText: String,
    val icon: String
)