package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.ClearingEntity

class ClearingProvider {

    companion object {
        fun loadClearings(context: Context): List<ClearingEntity> {
            val clearings = mutableListOf<ClearingEntity>()
            val names = context.resources.getStringArray(R.array.clearing_names)
            val tiles = context.resources.getIntArray(R.array.clearing_tiles)
            val con1 = context.resources.getIntArray(R.array.clearing_con1)
            val con2 = context.resources.getIntArray(R.array.clearing_con2)

            for (i in names.indices) {
                val clearing = ClearingEntity(i + 1, names[i], tiles[i], con1[i], con2[i])
                clearings.add(clearing)
            }
            return clearings
        }
    }

}