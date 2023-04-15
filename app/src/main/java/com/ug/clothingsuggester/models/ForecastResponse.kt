package com.ug.clothingsuggester.models

data class ForecastResponse(

    val latitude : Double,
    val longitude : Double,
    val generationTime_ms : Double,
    val utc_offset_seconds : Double,
    val timezone : String,
    val timezone_abbreviation : String,
    val elevation : Double,
    val currentWeather : CurrentWeather)
