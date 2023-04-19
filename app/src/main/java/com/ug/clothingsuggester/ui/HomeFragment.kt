package com.ug.clothingsuggester.ui

import android.icu.util.Calendar
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.ug.clothingsuggester.R
import com.ug.clothingsuggester.data.DataManager
import com.ug.clothingsuggester.data.DataSource
import com.ug.clothingsuggester.databinding.FragmentHomeBinding
import com.ug.clothingsuggester.models.ForecastResponse
import com.ug.clothingsuggester.networking.ApiServices
import com.ug.clothingsuggester.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val apiServices = ApiServices()
    private val dataManager = DataManager()
    private val dataSource = DataSource()
    private val calendar = Calendar.getInstance()
    private val categoriesFragment = CategoriesFragment()
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding
        = FragmentHomeBinding::inflate

    override fun callBacks() {

        dataManager.initialSharedPreferences(requireContext())
        apiServices.makeRequest(::apiCallback)
        pickRandomQuote()
        viewCategories()
    }
    private fun selectSuitableOutfit(temperature : Int) {

        if (temperature <= 20){
            if (dataManager.winterOutfitIndex == dataSource.winterOutfits.size-1) dataManager.winterOutfitIndex = 0
            else dataManager.winterOutfitIndex = dataManager.winterOutfitIndex!! + 1
            val winterOutfitId = dataSource.winterOutfits[dataManager.winterOutfitIndex!!]
            binding.imageViewOutfit.setImageResource(winterOutfitId)
        } else {
            if (dataManager.summerOutfitIndex == dataSource.summerOutfits.size-1) dataManager.summerOutfitIndex = 0
            else  dataManager.summerOutfitIndex = dataManager.summerOutfitIndex!! + 1
            val summerOutfitId = dataSource.summerOutfits[dataManager.summerOutfitIndex!!]
            binding.imageViewOutfit.setImageResource(summerOutfitId)
        }
    }
    private fun changeOutfitDaily(temperature : Int){

        if (calendar.get(Calendar.DAY_OF_MONTH).toString() != dataManager.currentDate){

            dataManager.currentDate = calendar.get(Calendar.DAY_OF_MONTH).toString()
            selectSuitableOutfit(temperature)
        }

        else{

            val winterOutfitId = dataSource.winterOutfits[dataManager.winterOutfitIndex!!]
            val summerOutfitId = dataSource.summerOutfits[dataManager.summerOutfitIndex!!]
            if (temperature <= 20) {
                binding.imageViewOutfit.setImageResource(winterOutfitId)
            } else {
                binding.imageViewOutfit.setImageResource(summerOutfitId)
            }
        }
    }
    private fun pickRandomQuote(){

        binding.textViewQuote.text = dataSource.quotes.random().uppercase()
    }
    private fun pickAnotherOutfit(temperature: Int){

        binding.buttonPickAnother.setOnClickListener {

            selectSuitableOutfit(temperature)
        }
    }
    private fun viewCategories(){

        binding.buttonViewCategories.setOnClickListener {
            addFragment(categoriesFragment)
        }
    }
    private fun apiCallback(forecastResponse: ForecastResponse?){

        if(forecastResponse == null){

            binding.apply {

                textViewTemperature.textSize = TEXT_SIZE_20
                textViewTemperature.text = CHECK_INTERNET_CONNECTION
                textViewCelsius.text = ""
                imageViewOutfit.setImageResource(R.color.gray)
                buttonPickAnother.isClickable = false
            }
        }
        else{

            activity?.runOnUiThread {

                val temperature = forecastResponse.current.temperature.toString()
                changeOutfitDaily(temperature.toInt())
                pickAnotherOutfit(temperature.toInt())
                binding.apply {
                    textViewTemperature.text = temperature
                    textViewWeather.text = forecastResponse.current.weatherDescriptions[0]
                    textViewCity.text = forecastResponse.location.name
                }

                Glide.with(this)
                    .load(forecastResponse.current.weatherIcons[0])
                    .into(binding.imageViewForecast)
            }
        }
    }
    companion object{

        const val TEXT_SIZE_20 = 20.0f
        const val CHECK_INTERNET_CONNECTION = "Check Internet Connection"
    }
}