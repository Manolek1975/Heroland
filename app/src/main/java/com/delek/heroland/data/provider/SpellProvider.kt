package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.SpellEntity

class SpellProvider {

    companion object{
        fun loadSpells(context: Context): List<SpellEntity> {
            val spells = mutableListOf<SpellEntity>()
            val name = context.resources.getStringArray(R.array.spell_name)
            val type = context.resources.getStringArray(R.array.spell_type)
            val color = context.resources.getStringArray(R.array.spell_color)
            val target = context.resources.getStringArray(R.array.spell_target)
            val duration = context.resources.getStringArray(R.array.spell_duration)
            val typeName = context.resources.getStringArray(R.array.spell_type_name)
            val description = context.resources.getStringArray(R.array.spell_description)
            val shortDescription = context.resources.getStringArray(R.array.spell_short_description)
            for (i in name.indices) {
                val value = SpellEntity(i+1, name[i], type[i], color[i], target[i],
                    duration[i], description[i], typeName[i], shortDescription[i])
                spells.add(value)
            }
            return spells


        }
    }
}