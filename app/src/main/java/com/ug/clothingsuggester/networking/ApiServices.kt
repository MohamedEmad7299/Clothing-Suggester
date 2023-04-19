package com.ug.clothingsuggester.networking

import com.google.gson.Gson
import com.ug.clothingsuggester.models.ForecastResponse
import okhttp3.*
import java.io.IOException

class ApiServices {


    fun makeRequest(callback: (ForecastResponse?) -> Unit){

        val client = OkHttpClient()

        val url = HttpUrl.Builder()
            .scheme("http")
            .host("api.weatherstack.com")
            .addPathSegment("current")
            .addQueryParameter("access_key", ACCESS_KEY)
            .addQueryParameter("query", QUERY)
            .build()

        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {

            override fun onResponse(call: Call, response: Response) {

                if (response.isSuccessful){

                    response.body?.string()?.let { jsonString ->

                        val forecastResponse = Gson().fromJson(jsonString, ForecastResponse::class.java)
                        callback(forecastResponse)
                    }
                }

                else callback(null)
            }

            override fun onFailure(call: Call, e: IOException) {

                callback(null)
            }
        })
    }

    companion object{

        private const val ACCESS_KEY = "439c1a6175419eb4690b1a58def30447"
        private const val QUERY = "Sohag"
    }
}