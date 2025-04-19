package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.RoleEntity


class RoleProvider {

    companion object {
        fun loadRoles(context: Context): List<RoleEntity> {
            val roles: MutableList<RoleEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.roles_name)
            val symbol = context.resources.getStringArray(R.array.roles_symbol)
            val icon = context.resources.getStringArray(R.array.roles_icon)
            val thumb = context.resources.getStringArray(R.array.roles_thumb)
            val image = context.resources.getStringArray(R.array.roles_image)
            val weight = context.resources.getStringArray(R.array.roles_weight)
            val spell = context.resources.getStringArray(R.array.role_spells)

            for (i in name.indices) {
                val rol = RoleEntity(
                    i + 1, name[i], symbol[i], icon[i], thumb[i], image[i],
                    weight[i], spell[i].toInt(), 0)
                roles.add(rol)
            }
            return roles

        }
    }
}


