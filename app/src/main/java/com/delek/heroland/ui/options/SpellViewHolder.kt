package com.delek.heroland.ui.options

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemSpellBinding
import com.delek.heroland.domain.model.Spell

class SpellViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSpellBinding.bind(view)

    fun render(spell: Spell) {
        binding.name.text = spell.name

    }
}