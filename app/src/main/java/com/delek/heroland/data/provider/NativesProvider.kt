package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.NativesEntity

class NativesProvider {

    companion object{
        fun loadNatives(context: Context): List<NativesEntity> {
            val natives: MutableList<NativesEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_natives)
            for (i in name.indices) {
                val value = NativesEntity(i+1, name[i], 0)
                natives.add(value)
            }
            return natives
        }

    }
}