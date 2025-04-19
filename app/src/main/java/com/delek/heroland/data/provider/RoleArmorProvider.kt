package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.RoleArmorEntity

class RoleArmorProvider {

    companion object{
        fun loadRoleArmor(context: Context): List<RoleArmorEntity> {
            val roleArmor = mutableListOf<RoleArmorEntity>()
            val roleId = context.resources.getStringArray(R.array.role_id_amor)
            val armorId = context.resources.getStringArray(R.array.armor_id_armor)
            for (i in roleId.indices) {
                val entity = RoleArmorEntity(i+1, roleId[i].toInt(), armorId[i].toInt())
                roleArmor.add(entity)
            }
            return roleArmor
        }
    }
}