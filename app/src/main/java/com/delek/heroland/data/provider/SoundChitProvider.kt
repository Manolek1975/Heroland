package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.SoundChitEntity

class SoundChitProvider {

    companion object {
        fun loadAdvices(context: Context): List<SoundChitEntity> {
            val sound: MutableList<SoundChitEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_sound_chits)
            val type = context.resources.getStringArray(R.array.type_sound_chits)
            val num = context.resources.getStringArray(R.array.num_sound_chits)
            for (i in name.indices) {
                val s = SoundChitEntity(i + 1, name[i], type[i], num[i].toInt(), 0, 0)
                sound.add(s)
            }
            return sound
        }
    }
}



