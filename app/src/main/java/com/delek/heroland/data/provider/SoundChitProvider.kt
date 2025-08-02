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
            val dice = context.resources.getStringArray(R.array.dice_sound_chits)
            val num = context.resources.getStringArray(R.array.num_sound_chits)
            val treasure = context.resources.getStringArray(R.array.treasure_sound_chits)
            val monster = context.resources.getStringArray(R.array.monster_sound_chits)
            for (i in name.indices) {
                val s = SoundChitEntity(i + 1, name[i], type[i], dice[i].toInt(),
                    num[i].toInt(), treasure[i].toInt(), monster[i].toInt())
                sound.add(s)
            }
            return sound
        }
    }
}



