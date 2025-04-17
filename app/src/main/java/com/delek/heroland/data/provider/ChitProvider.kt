package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.ChitEntity

class ChitProvider {

    companion object{

        fun loadChits(context: Context): List<ChitEntity> {
            val chits: MutableList<ChitEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.chit_names)
            val type = context.resources.getStringArray(R.array.chit_types)
            val speed = context.resources.getStringArray(R.array.chit_speed)
            val effort = context.resources.getStringArray(R.array.chit_effort)
            for (i in name.indices) {
                val chit = ChitEntity(i + 1, name[i], type[i], speed[i].toInt(), effort[i])
                chits.add(chit)

            }
            return chits
        }
    }
}