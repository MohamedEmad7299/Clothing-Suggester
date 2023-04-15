package com.ug.clothingsuggester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ug.clothingsuggester.databinding.ActivityMainBinding
import com.ug.clothingsuggester.networking.ApiServices
import com.ug.clothingsuggester.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    val homeFragment = HomeFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(homeFragment)
    }

    private fun addFragment(fragment: Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }
}