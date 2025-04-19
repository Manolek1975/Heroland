package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.RoleAdvantageEntity

class RoleAdvantageProvider {

    companion object {
        fun loadRoleAdvantages(context: Context): List<RoleAdvantageEntity> {
            val roleAdvantages: MutableList<RoleAdvantageEntity> = mutableListOf()
            val rolId = context.resources.getStringArray(R.array.role_id_advantages)
            val advId = context.resources.getStringArray(R.array.adv_id_advantages)
            for (i in rolId.indices) {
                val adv = RoleAdvantageEntity(rolId[i].toInt(), advId[i].toInt())
                roleAdvantages.add(adv)
            }
            return roleAdvantages
        }
    }
}
