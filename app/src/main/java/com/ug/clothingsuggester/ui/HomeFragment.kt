package com.ug.clothingsuggester.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ug.clothingsuggester.R
import com.ug.clothingsuggester.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    companion object{

        // Weather Codes

        const val CLEAR_SKY = 0
        const val MAINLY_CLEAR = 1
        const val PARTLY_CLOUDY = 2
        const val OVERCAST = 3
        const val FOG = 45
        const val DEPOSITING_RIME_FOG = 48
        const val DRIZZLE_LIGHT = 51
        const val DRIZZLE_MODERATE = 53
        const val DRIZZLE_DENSE_INTENSITY = 55
        const val FREEZING_DRIZZLE_LIGHT = 56
        const val FREEZING_DRIZZLE_DENSE_INTENSITY = 57
        const val RAIN_SLIGHT = 61
        const val RAIN_MODERATE = 63
        const val RAIN_HEAVY_INTENSITY = 65
        const val FREEZING_RAIN_LIGHT = 66
        const val FREEZING_RAIN_HEAVY_INTENSITY = 67
        const val SNOW_FALL_SLIGHT = 71
        const val SNOW_FALL_MODERATE = 73
        const val SNOW_FALL_HEAVY_INTENSITY = 75
        const val SNOW_GRAINS = 77
        const val RAIN_SHOWERS_SLIGHT = 80
        const val RAIN_SHOWERS_MODERATE = 81
        const val RAIN_SHOWERS_VIOLENT = 82
        const val SNOW_SHOWERS_SLIGHT = 85
        const val SNOW_SHOWERS_HEAVY = 86
        const val THUNDER_STORM_SLIGHT_OR_MODERATE = 95
        const val THUNDER_STORM_WITH_SLIGHT = 96
        const val THUNDER_STORM_WITH_HEAVY_HAIL = 99
    }
}