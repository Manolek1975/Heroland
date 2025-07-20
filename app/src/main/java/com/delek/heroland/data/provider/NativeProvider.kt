package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.NativeEntity

class NativeProvider {

    companion object{
        fun loadNatives(context: Context): List<NativeEntity> {
            val natives: MutableList<NativeEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_natives)
            for (i in name.indices) {
                val value = NativeEntity(i+1, name[i], 0,0,0,false,0,0)
                natives.add(value)
            }
            return natives
        }

    }
}