package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.WeaponEntity

class WeaponProvider {

    companion object{
        fun loadWeapons(context: Context): List<WeaponEntity>{
            val weapons = mutableListOf<WeaponEntity>()
            val name = context.resources.getStringArray(R.array.weapon_names)
            val image = context.resources.getStringArray(R.array.weapon_images)
            val alert = context.resources.getStringArray(R.array.weapon_alert)
            val damage = context.resources.getStringArray(R.array.weapon_damage)
            val plus = context.resources.getStringArray(R.array.weapon_plus)
            val plusAlert = context.resources.getStringArray(R.array.weapon_plus_alert)
            val type = context.resources.getStringArray(R.array.weapon_types)
            val length = context.resources.getStringArray(R.array.weapons_length)
            val speed = context.resources.getStringArray(R.array.weapon_speed)
            val speedAlert = context.resources.getStringArray(R.array.weapon_speed_alert)
            val price = context.resources.getStringArray(R.array.weapon_prices)
            for (i in name.indices) {
                val weapon = WeaponEntity(
                    i + 1,
                    name[i],
                    image[i],
                    alert[i],
                    damage[i],
                    plus[i],
                    plusAlert[i],
                    type[i],
                    length[i].toInt(),
                    speed[i].toInt(),
                    speedAlert[i].toInt(),
                    price[i].toInt()
                )
                weapons.add(weapon)
            }
            return weapons
        }
    }
}