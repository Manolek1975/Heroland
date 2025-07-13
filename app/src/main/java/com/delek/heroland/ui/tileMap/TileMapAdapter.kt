package com.delek.heroland.ui.tileMap

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.Role

class TileMapAdapter(private var boxList: List<View> = emptyList(),
                     private val onItemSelected: (View) -> Unit) :
    RecyclerView.Adapter<TileMapViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TileMapViewHolder {
        return TileMapViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_box, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TileMapViewHolder, position: Int) {
        holder.render(boxList[position], onItemSelected)
    }

    override fun getItemCount() = boxList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<View>){
        boxList = list
        notifyDataSetChanged()
    }
}