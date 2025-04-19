package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.RoleWeaponEntity

class RoleWeaponProvider {

    companion object{

        fun loadRoleWeapons(context: Context): List<RoleWeaponEntity> {
            val roleWeapons = mutableListOf<RoleWeaponEntity>()
            val weapons = context.resources.getStringArray(R.array.weapon_id_role_weapons)
            for (i in weapons.indices) {
                val value = RoleWeaponEntity(i+1, i+1, weapons[i].toInt())
                roleWeapons.add(value)
            }
            return roleWeapons
        }
    }
}