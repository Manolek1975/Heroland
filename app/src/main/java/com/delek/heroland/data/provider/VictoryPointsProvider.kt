package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.VictoryPointsEntity

class VictoryPointsProvider {

    companion object{
        fun loadVictoryPoints(context: Context): List<VictoryPointsEntity>{
            val vpEntity = mutableListOf<VictoryPointsEntity>()
            val names = context.resources.getStringArray(R.array.vp_names)
            for (i in names.indices){
                val entity =VictoryPointsEntity(i+1,names[i],0)
                vpEntity.add(entity)
            }
            return vpEntity
        }
    }
}