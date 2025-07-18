package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.AdviceChitEntity

class AdviceChitProvider {

    companion object {
        fun loadAdvices(context: Context): List<AdviceChitEntity> {
            val advices: MutableList<AdviceChitEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_advice_chits)
            val type = context.resources.getStringArray(R.array.type_advice_chits)
            val dwelling = context.resources.getStringArray(R.array.dwelling_advice_chits)
            val monster = context.resources.getStringArray(R.array.monster_advice_chits)
            for (i in name.indices) {
                val advice = AdviceChitEntity(i + 1, name[i], type[i], dwelling[i].toInt(), monster[i].toInt())
                advices.add(advice)
            }
            return advices
        }
    }
}



