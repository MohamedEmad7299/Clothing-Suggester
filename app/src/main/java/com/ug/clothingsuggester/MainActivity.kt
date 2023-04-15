package com.ug.clothingsuggester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ug.clothingsuggester.networking.ApiServices

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        ApiServices.makeRequest()
    }
}