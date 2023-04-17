package com.ug.clothingsuggester.models

import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("name") val name : String,
    @SerializedName("country") val country : String,
    @SerializedName("region") val region : String,
    @SerializedName("lat") val lat : String,
    @SerializedName("lon") val lon : String,
    @SerializedName("timezone_id") val timezoneId : String,
    @SerializedName("localtime") val localTime : String,
    @SerializedName("localtime_epoch") val localTimeEpoch : Int,
    @SerializedName("utc_offset") val UtcOffset : String
)
