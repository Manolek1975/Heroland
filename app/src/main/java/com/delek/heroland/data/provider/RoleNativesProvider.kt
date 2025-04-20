package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.RoleNativesEntity

class RoleNativesProvider {

    companion object {
        fun loadRoleNatives(context: Context): List<RoleNativesEntity> {
            val roleNatives = mutableListOf<RoleNativesEntity>()
            val roleId = context.resources.getStringArray(R.array.role_id_role_natives)
            val nativeId = context.resources.getStringArray(R.array.native_id_role_natives)
            val relationId = context.resources.getStringArray(R.array.relation_id_role_natives)
            for (i in roleId.indices) {
                val entity = RoleNativesEntity(
                    i + 1, roleId[i].toInt(), nativeId[i].toInt(), relationId[i].toInt()
                )
                roleNatives.add(entity)
            }
            return roleNatives
        }
    }
}