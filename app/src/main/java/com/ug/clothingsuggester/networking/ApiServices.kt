package com.ug.clothingsuggester.networking

import android.util.Log
import com.google.gson.Gson
import com.ug.clothingsuggester.models.ForecastResponse
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

object ApiServices {

    private val client = OkHttpClient()

    fun makeRequest() : ForecastResponse? {

        val latitude = "26.231737"
        val longitude = "31.996723"
        val timezone = "Africa/Cairo"
        val current_weather = "true"

        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.open-meteo.com")
            .addPathSegment("v1")
            .addPathSegment("forecast")
            .addQueryParameter("latitude", latitude)
            .addQueryParameter("longitude", longitude)
            .addQueryParameter("timezone", timezone)
            .addQueryParameter("current_weather", current_weather)
            .build()

        var result : ForecastResponse? = null
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                response.body?.string()?.let {jsonString ->

                    val jsonObject = Gson().fromJson(jsonString,ForecastResponse::class.java)
                    Log.i("Yoge",jsonString)
                    result = jsonObject
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.i("YOGE", "$e.message")
            }
        })

        return result
    }
}