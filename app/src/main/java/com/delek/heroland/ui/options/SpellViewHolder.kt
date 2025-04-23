package com.delek.heroland.ui.options

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.databinding.ItemSpellBinding
import com.delek.heroland.domain.model.Spell

class SpellViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSpellBinding.bind(view)

    fun render(spell: Spell) {
        val context = binding.name.context
        binding.duration.text = spell.duration
        binding.target.text = spell.target
        binding.name.text = spell.name
        binding.description.text = spell.shortDescription

        binding.typeColor.text = context.getString(R.string.type_color, spell.typeName, spell.color)

    }
}