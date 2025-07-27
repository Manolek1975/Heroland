package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.SpotEntity

class SpotProvider {

    companion object {
        fun loadSpot(context: Context): List<SpotEntity> {
            val spotList = mutableListOf<SpotEntity>()
            val dice = context.resources.getIntArray(R.array.dice_spot)

            for (i in dice.indices) {
                val spot = SpotEntity(i + 1, dice[i], 0, 0, 0, 0)
                spotList.add(spot)
            }
            return spotList
        }
    }
}