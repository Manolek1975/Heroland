package com.delek.heroland.ui.options

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.SpellType


class SpellAdapter(private var typesList: List<SpellType> = emptyList()) : RecyclerView.Adapter<SpellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        return SpellViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        )
    }

    override fun getItemCount(): Int = typesList.size

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        holder.render(typesList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<SpellType>){
        typesList = list
        notifyDataSetChanged()
    }
}