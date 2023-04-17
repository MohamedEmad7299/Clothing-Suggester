package com.ug.clothingsuggester.models

import com.google.gson.annotations.SerializedName

data class ForecastResponse(

    @SerializedName("request") val request : Request,
    @SerializedName("location") val location : Location,
    @SerializedName("current") val current : Current,
    )
