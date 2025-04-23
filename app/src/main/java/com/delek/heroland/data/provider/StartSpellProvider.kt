package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.StartSpellEntity

class StartSpellProvider {

    companion object{
        fun loadStartSpells(context: Context): List<StartSpellEntity> {
            val startSpells = mutableListOf<StartSpellEntity>()
            val roleId = context.resources.getStringArray(R.array.role_id_start_spells)
            val typeId = context.resources.getStringArray(R.array.type_id_start_spells)
            val spellType = context.resources.getStringArray(R.array.type_start_spells)
            for (i in spellType.indices) {
                val entity = StartSpellEntity(i + 1, roleId[i].toInt(), typeId[i].toInt(), spellType[i])
                startSpells.add(entity)
            }
            return startSpells
        }
    }
}