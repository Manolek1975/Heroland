package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.SpellTypeEntity

class SpellTypeProvider {

    companion object {
        fun loadSpellTypes(context: Context): List<SpellTypeEntity> {
            val spellTypes = mutableListOf<SpellTypeEntity>()
            val type = context.resources.getStringArray(R.array.type_spell_types)
            for (i in type.indices) {
                val value = SpellTypeEntity(i + 1, i + 1, i + 1, type[i])
                spellTypes.add(value)
            }
            return spellTypes
        }
    }
}