package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.RoleDwellingEntity

class RoleDwellingProvider {

    companion object{
        fun loadRoleDwellings(context: Context): List<RoleDwellingEntity> {
            val roleDwellings: MutableList<RoleDwellingEntity> = mutableListOf()
            val role = context.resources.getStringArray(R.array.role_id_role_dwellings)
            val dwelling = context.resources.getStringArray(R.array.dwelling_id_role_dwellings)
            for (i in role.indices) {
                val value = RoleDwellingEntity(i+1, role[i].toInt(), dwelling[i].toInt())
                roleDwellings.add(value)
            }
            return roleDwellings
        }
    }
}