package com.ug.clothingsuggester.networking

import android.util.Log
import com.google.gson.Gson
import com.ug.clothingsuggester.models.CurrentWeather
import com.ug.clothingsuggester.models.ForecastResponse
import okhttp3.*
import java.io.IOException

object ApiServices {

    private val client = OkHttpClient()
    private const val latitude = "26.231737"
    private const val longitude = "31.996723"
    private const val timezone = "Africa/Cairo"
    private const val currentWeather = "true"
    fun makeRequest() : CurrentWeather? {

        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.open-meteo.com")
            .addPathSegment("v1")
            .addPathSegment("forecast")
            .addQueryParameter("latitude", latitude)
            .addQueryParameter("longitude", longitude)
            .addQueryParameter("timezone", timezone)
            .addQueryParameter("current_weather", currentWeather)
            .build()

        var result : ForecastResponse? = null
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                response.body?.string()?.let {jsonString ->

                    result = Gson().fromJson(jsonString,ForecastResponse::class.java)
                }
            }

            override fun onFailure(call: Call, e: IOException) {

            }
        })

        return result?.currentWeather
    }
}