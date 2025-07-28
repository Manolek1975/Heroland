package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.MonsterEntity

class MonsterProvider {

    companion object {
        fun loadMonsters(context: Context): List<MonsterEntity> {
            val monsters = mutableListOf<MonsterEntity>()
            val name = context.resources.getStringArray(R.array.name_monsters)
            val image = context.resources.getStringArray(R.array.image_monsters)
            val weight = context.resources.getStringArray(R.array.weight_monsters)
            val armor = context.resources.getStringArray(R.array.armor_monsters)
            val fightA = context.resources.getStringArray(R.array.fight_a_monsters)
            val moveA = context.resources.getStringArray(R.array.move_a_monsters)
            val fightB = context.resources.getStringArray(R.array.fight_b_monsters)
            val moveB = context.resources.getStringArray(R.array.move_b_monsters)
            val bounty = context.resources.getStringArray(R.array.bounty_monsters)
            val dice = context.resources.getStringArray(R.array.dice_monsters)
            val color = context.resources.getStringArray(R.array.color_monsters)

            for (i in name.indices) {
                val value =(MonsterEntity(i+1, name[i], "", image[i], weight[i], armor[i].toInt(),
                    fightA[i], moveA[i].toInt(), fightB[i], moveB[i].toInt(),
                    bounty[i].toInt(), dice[i].toInt(), color[i]))
                monsters.add(value)
            }
            return monsters
        }
    }
}