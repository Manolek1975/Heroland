package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.PhaseEntity

class PhaseProvider {

    companion object {
        fun loadPhases(context: Context): List<PhaseEntity> {
            val phases: MutableList<PhaseEntity> = mutableListOf()
            val names = context.resources.getStringArray(R.array.phase_names)

            for (i in names.indices) {
                val value = PhaseEntity(i + 1, names[i])
                phases.add(value)
            }
            return phases
        }
    }

}
