package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.DwellingEntity


class DwellingProvider {

    companion object {
        fun loadDwellings(context: Context): List<DwellingEntity> {
            val dwellings: MutableList<DwellingEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_dwellings)
            val image = context.resources.getStringArray(R.array.image_dwellings)
            for (i in name.indices) {
                val dwe = DwellingEntity(i + 1, name[i], image[i], 0, 0)
                dwellings.add(dwe)
            }
            return dwellings
        }
    }
}
