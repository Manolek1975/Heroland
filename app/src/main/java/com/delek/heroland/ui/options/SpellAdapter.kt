package com.delek.heroland.ui.options

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.Spell


class SpellAdapter(
    private var spellList: List<Spell> = emptyList(),
    private val onItemSelected: (Spell) -> Unit)
: RecyclerView.Adapter<SpellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        return SpellViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_spell, parent, false)
        )
    }

    override fun getItemCount(): Int = spellList.size

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        holder.render(spellList[position], onItemSelected)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateSpells(spell: List<Spell>){
        spellList = spell
        notifyDataSetChanged()
    }

}