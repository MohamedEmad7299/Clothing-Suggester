package com.ug.clothingsuggester.ui

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import com.ug.clothingsuggester.R
import com.ug.clothingsuggester.data.DataSource
import com.ug.clothingsuggester.databinding.FragmentCategoriesBinding
import com.ug.clothingsuggester.ui.base.BaseFragment


class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>() {

    private val wardrobeFragment = WardrobeFragment()
    private val dataSource = DataSource()
    override val bindingInflater: (LayoutInflater) -> FragmentCategoriesBinding = FragmentCategoriesBinding::inflate

    override fun callBacks() {

        pickRandomImagesForCategoriesCards()
        selectCategory()
    }


    private fun pickRandomImagesForCategoriesCards(){

        binding.imageViewAllOutfit.setImageResource(dataSource.allOutfits.random())
        binding.imageViewSummerOutfit.setImageResource(dataSource.summerOutfits.random())
        binding.imageViewWinterOutfit.setImageResource(dataSource.winterOutfits.random())
    }

    private fun replaceFragment(fragment: Fragment){

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun selectCategory(){

        binding.cardViewWinterOutfits.setOnClickListener {
            DataSource.SELECTED_OUTFITS_CATEGORY = DataSource.WINTER_OUTFITS_CATEGORY
            replaceFragment(wardrobeFragment)
        }

        binding.cardViewSummerOutfits.setOnClickListener {
            DataSource.SELECTED_OUTFITS_CATEGORY = DataSource.SUMMER_OUTFITS_CATEGORY
            replaceFragment(wardrobeFragment)
        }

        binding.cardViewAllOutfits.setOnClickListener {
            DataSource.SELECTED_OUTFITS_CATEGORY = DataSource.ALL_OUTFITS_CATEGORY
            replaceFragment(wardrobeFragment)
        }
    }
}