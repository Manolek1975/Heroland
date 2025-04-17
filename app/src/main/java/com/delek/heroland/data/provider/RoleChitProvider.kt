package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.RoleChitEntity

class RoleChitProvider {

    companion object{
        fun loadRoleChits(context: Context): List<RoleChitEntity> {
            val roleChits: MutableList<RoleChitEntity> = mutableListOf()
            val role = context.resources.getStringArray(R.array.role_id_rolechits)
            val chit = context.resources.getStringArray(R.array.chits_id_rolechits)
            for (i in role.indices) {
                val value = RoleChitEntity(i+1, role[i].toInt(), chit[i].toInt())
                roleChits.add(value)
            }
            return roleChits
        }
    }
}