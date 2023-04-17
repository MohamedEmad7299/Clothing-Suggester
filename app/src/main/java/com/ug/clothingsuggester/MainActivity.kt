package com.ug.clothingsuggester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ug.clothingsuggester.data.DataManager
import com.ug.clothingsuggester.databinding.ActivityMainBinding
import com.ug.clothingsuggester.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callBacks()
    }

    private fun callBacks() {

        DataManager.initialSharedPreferences(this)
        addFragment(homeFragment)
    }


    private fun addFragment(fragment: Fragment){

        val transaction = supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container,fragment)
            .commit()
    }
}