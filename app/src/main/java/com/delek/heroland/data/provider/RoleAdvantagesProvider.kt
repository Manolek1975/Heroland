package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.RoleAdvantagesEntity

class RoleAdvantagesProvider {

    companion object {
        fun loadRoleAdvantages(context: Context): List<RoleAdvantagesEntity> {
            val roleAdvantages: MutableList<RoleAdvantagesEntity> = mutableListOf()
            val rolId = context.resources.getStringArray(R.array.role_id_advantages)
            val advId = context.resources.getStringArray(R.array.adv_id_advantages)
            for (i in rolId.indices) {
                val adv = RoleAdvantagesEntity(rolId[i].toInt(), advId[i].toInt())
                roleAdvantages.add(adv)
            }
            return roleAdvantages
        }
    }
}
