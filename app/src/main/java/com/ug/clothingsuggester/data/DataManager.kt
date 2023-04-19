package com.ug.clothingsuggester.data

import android.content.Context
import android.content.SharedPreferences

class DataManager {

    private var sharedPreferences : SharedPreferences? = null

    fun initialSharedPreferences(context: Context){

        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE)
    }

    var winterOutfitIndex : Int?
        get() = sharedPreferences?.getInt(WINTER_OUTFIT_KEY,0)
        set(value) {
            if (value != null) {
                sharedPreferences?.edit()?.putInt(WINTER_OUTFIT_KEY,value)?.apply()
            }
        }

    var summerOutfitIndex : Int?
        get() = sharedPreferences?.getInt(SUMMER_OUTFIT_KEY,8)
        set(value) {
            if (value != null) {
                sharedPreferences?.edit()?.putInt(SUMMER_OUTFIT_KEY,value)?.apply()
            }
        }

    var currentDate : String?
        get() = sharedPreferences?.getString(CURRENT_DATE_KEY,null)
        set(value) {
            sharedPreferences?.edit()?.putString(CURRENT_DATE_KEY,value)?.apply()
        }

    companion object{

        private const val SHARED_PREFERENCES_NAME = "Shared_Preferences"
        private const val WINTER_OUTFIT_KEY = "WinterIsGone"
        private const val SUMMER_OUTFIT_KEY = "WinterIsComing"
        private const val CURRENT_DATE_KEY = "TodayIsAGift"
    }
}