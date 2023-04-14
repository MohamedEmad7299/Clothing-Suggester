package com.ug.clothingsuggester.networking

import android.util.Log
import okhttp3.*
import java.io.IOException

object ApiServices {

    private val client = OkHttpClient()

    fun makeRequest(){

        val latitude = "26.231737"
        val longitude = "31.996723"
        val timezone = "Africa/Cairo"
        val current_weather = "true"

        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.open-meteo.com")
            .addPathSegment("v1")
            .addPathSegment("forecast")
            .addQueryParameter("latitude",latitude)
            .addQueryParameter("longitude",longitude)
            .addQueryParameter("timezone",timezone)
            .addQueryParameter("current_weather",current_weather)
            .build()

        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {
                Log.i("YOGE", response.body?.string().toString())
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.i("YOGE","$e.message")
            }
        })
    }
}