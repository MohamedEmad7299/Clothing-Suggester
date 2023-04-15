package com.ug.clothingsuggester.models

data class CurrentWeather(


    val temperature: Double,
    val windSpeed: Double,
    val windDirection: Double,
    val weatherCode: Int,
    val isDay: Int,
    val time: String
)
