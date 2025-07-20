package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.NativeEntity

class NativeProvider {

    companion object {
        fun loadNatives(context: Context): List<NativeEntity> {
            val natives: MutableList<NativeEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_natives)
            val type = context.resources.getStringArray(R.array.type_natives)
            val group = context.resources.getStringArray(R.array.group_natives)
            for (i in name.indices) {
                val value = NativeEntity(i + 1, name[i], type[0], group[0].toInt(),
                        0, 0, 0, false, 0, 0)
                natives.add(value)
            }
            return natives
        }

    }
}