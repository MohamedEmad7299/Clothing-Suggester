package com.ug.clothingsuggester.ui

import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ug.clothingsuggester.R
import com.ug.clothingsuggester.databinding.FragmentCategoriesBinding
import com.ug.clothingsuggester.databinding.FragmentHomeBinding
import com.ug.clothingsuggester.models.CurrentWeather
import com.ug.clothingsuggester.networking.ApiServices


class HomeFragment : Fragment() {

    val calendar = Calendar.getInstance()
    lateinit var binding: FragmentCategoriesBinding
    lateinit var currentWeather: CurrentWeather
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

//    private fun checkResponse(){
//
//        if (ApiServices.apiResponse == null) Toast.makeText(requireContext(), "الحمدلله", Toast.LENGTH_SHORT).show()
//    }

//    fun changeForecastImage(){
//
//        when(currentWeather.weatherCode){
//
//            in CLEAR_WEATHER_CODES -> setImageResourceForForecastImage(R.drawable.sun_icon)
//            PARTLY_CLOUDY_CODE -> setImageResourceForForecastImage(R.drawable.partly_cloud)
//            OVERCAST_CODE -> setImageResourceForForecastImage(R.drawable.cloud_icon)
//            in FOGGY_WEATHER_CODES -> setImageResourceForForecastImage(R.drawable.foggy_icon)
//            in RAINY_WEATHER_CODES -> setImageResourceForForecastImage(R.drawable.rainy_icon)
//            in THUNDER_WEATHER_CODES -> setImageResourceForForecastImage(R.drawable.thunder_icon)
//            in SNOW_WEATHER_CODES -> setImageResourceForForecastImage(R.drawable.snow_icon)
//        }
//    }
//    private fun setImageResourceForForecastImage(imageID : Int){
//
//        binding.imageViewForecast.setImageResource(imageID)
//    }

    companion object{

        val FOGGY_WEATHER_CODES = listOf(45,48)
        val CLEAR_WEATHER_CODES = listOf(0,1)
        val RAINY_WEATHER_CODES = listOf(51,53,55,56,57,61,63,65,66,67,80,81,82)
        val THUNDER_WEATHER_CODES = listOf(95,96,99)
        val SNOW_WEATHER_CODES = listOf(71,73,75,77,85,86)
        const val PARTLY_CLOUDY_CODE = 2
        const val OVERCAST_CODE = 3

        const val FOGGY_WEATHER_TEXT = "Foggy Day"
        const val CLEAR_WEATHER_TEXT = "Clear Sky"
        const val RAINY_WEATHER_TEXT = "Rainy Day"
        const val SNOW_WEATHER_TEXT = "Snowy Day"
        const val THUNDER_WEATHER_TEXT = "Thunder Storm"
        const val OVERCAST_WEATHER_TEXT = "Overcast"
        const val PARTLY_CLOUDY_WEATHER_TEXT = "Partly Cloudy"
    }
}