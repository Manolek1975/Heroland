package com.delek.heroland.ui.options

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemTypeBinding
import com.delek.heroland.domain.model.SpellType

class SpellViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val binding = ItemTypeBinding.bind(view)

    fun render(type: SpellType) {
        binding.tvType.text = type.type
    }
}