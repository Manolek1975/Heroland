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
            val num = context.resources.getStringArray(R.array.num_advice_chits)
            val image = context.resources.getStringArray(R.array.image_advice_chits)
            for (i in name.indices) {
                val advice = AdviceChitEntity(i + 1, name[i], type[i], num[i].toInt(), image[i], 0, 0)
                advices.add(advice)
            }
            return advices
        }
    }
}



