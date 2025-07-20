package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.NativeGroupEntity

class NativesProvider {

    companion object{
        fun loadNatives(context: Context): List<NativeGroupEntity> {
            val natives: MutableList<NativeGroupEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_natives)
            for (i in name.indices) {
                val value = NativeGroupEntity(i+1, name[i], 0)
                natives.add(value)
            }
            return natives
        }

    }
}