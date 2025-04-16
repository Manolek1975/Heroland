package com.delek.heroland.domain.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.AdvantageEntity

class AdvantageProvider {

    companion object {
        fun createAdvantages(context: Context): List<AdvantageEntity> {
            val advantages: MutableList<AdvantageEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.advantages_name)
            val description = context.resources.getStringArray(R.array.advantages_description)
            for (i in name.indices) {
                val adv = AdvantageEntity(i + 1, name[i], description[i])
                advantages.add(adv)
            }
            return advantages
        }
    }
}



