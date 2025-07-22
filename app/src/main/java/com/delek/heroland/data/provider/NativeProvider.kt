package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.NativeEntity

class NativeProvider {

    companion object {
        fun loadNatives(context: Context): List<NativeEntity> {
            val natives: MutableList<NativeEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_natives)
            val type = context.resources.getStringArray(R.array.type_natives)
            val group = context.resources.getStringArray(R.array.group_natives)
            val image = context.resources.getStringArray(R.array.image_natives)
            val weight = context.resources.getStringArray(R.array.weight_natives)
            val weapon = context.resources.getStringArray(R.array.weapon_natives)
            val armor = context.resources.getStringArray(R.array.armor_natives)
            val fightA = context.resources.getStringArray(R.array.fight_a_natives)
            val fightB = context.resources.getStringArray(R.array.fight_b_natives)
            val moveA = context.resources.getStringArray(R.array.move_a_natives)
            val moveB = context.resources.getStringArray(R.array.move_b_natives)
            val hire = context.resources.getStringArray(R.array.hire_natives)
            val bounty = context.resources.getStringArray(R.array.bounty_natives)
            for (i in name.indices) {
                val value = NativeEntity(i + 1, name[i], type[i], group[i].toInt(), image[i],
                    weight[i], weapon[i].toInt(), armor[i].toInt(),
                    fightA[i], moveA[i].toInt(),fightB[i],moveB[i].toInt(),
                    hire[i].toInt(), bounty[i].toInt(), 0)
                natives.add(value)
            }
            return natives
        }

    }
}