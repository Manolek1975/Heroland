package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.MonsterEntity

class MonsterProvider {

    companion object {
        fun loadMonsters(context: Context): List<MonsterEntity> {
            val monsters = mutableListOf<MonsterEntity>()
            val name = context.resources.getStringArray(R.array.name_monsters)

            for (i in name.indices) {
                val value =(MonsterEntity(i, name[i], "", "", "", 0,
                    "", 0, "", 0, 0, 0))
                monsters.add(value)
            }
            return monsters
        }
    }
}