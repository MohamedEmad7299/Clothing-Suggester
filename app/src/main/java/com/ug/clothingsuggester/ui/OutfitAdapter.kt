package com.ug.clothingsuggester.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ug.clothingsuggester.R
import com.ug.clothingsuggester.ui.viewHolders.OutfitViewHolder

class OutfitAdapter(private val items : List<Int>) : RecyclerView.Adapter<OutfitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OutfitViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_outfit,parent,false)
        return OutfitViewHolder(view)
    }

    override fun onBindViewHolder(holder: OutfitViewHolder, position: Int) {

    }

    override fun getItemCount() = items.size
}