package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.ArmorEntity

class ArmorProvider {

    companion object{
        fun loadArmor(context: Context): List<ArmorEntity> {
            val armor = mutableListOf<ArmorEntity>()
            val name = context.resources.getStringArray(R.array.armor_names)
            val image = context.resources.getStringArray(R.array.armor_images)
            val defense = context.resources.getStringArray(R.array.armor_defense)
            val price = context.resources.getStringArray(R.array.armor_prices)
            val priceDamaged = context.resources.getStringArray(R.array.armor_prices_damaged)
            for (i in name.indices) {
                val armorEntity = ArmorEntity(i+1, name[i], image[i], defense[i], price[i].toInt(), priceDamaged[i].toInt())
                armor.add(armorEntity)
            }
            return armor
        }
    }
}