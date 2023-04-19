package com.ug.clothingsuggester.ui

import android.view.LayoutInflater
import com.ug.clothingsuggester.data.DataSource
import com.ug.clothingsuggester.databinding.FragmentWardrobeBinding
import com.ug.clothingsuggester.ui.adapters.OutfitAdapter
import com.ug.clothingsuggester.ui.base.BaseFragment


class WardrobeFragment : BaseFragment<FragmentWardrobeBinding>() {

    private val dataSource = DataSource()
    private lateinit var outfitAdapter: OutfitAdapter
    override val bindingInflater: (LayoutInflater) -> FragmentWardrobeBinding = FragmentWardrobeBinding::inflate

    override fun callBacks() {

        initializeUI()
    }
    private fun initializeUI(){

        when(DataSource.SELECTED_OUTFITS_CATEGORY){

            DataSource.WINTER_OUTFITS_CATEGORY ->{
                outfitAdapter = OutfitAdapter(dataSource.winterOutfits)
                binding.recyclerOutfits.adapter = outfitAdapter
                binding.textViewOutfitsNumber.text = dataSource.winterOutfits.size.toString()
                binding.textViewCategory.text = DataSource.WINTER_OUTFITS_CATEGORY
            }

            DataSource.SUMMER_OUTFITS_CATEGORY ->{
                outfitAdapter = OutfitAdapter(dataSource.summerOutfits)
                binding.recyclerOutfits.adapter = outfitAdapter
                binding.textViewOutfitsNumber.text = dataSource.summerOutfits.size.toString()
                binding.textViewCategory.text = DataSource.SUMMER_OUTFITS_CATEGORY
            }

            DataSource.ALL_OUTFITS_CATEGORY ->{

                outfitAdapter = OutfitAdapter(dataSource.allOutfits)
                binding.recyclerOutfits.adapter = outfitAdapter
                binding.textViewOutfitsNumber.text = dataSource.allOutfits.size.toString()
                binding.textViewCategory.text = DataSource.ALL_OUTFITS_CATEGORY
            }
        }
    }
}