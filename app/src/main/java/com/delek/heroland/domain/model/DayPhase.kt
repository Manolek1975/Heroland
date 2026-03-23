package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.DayPhaseEntity

data class DayPhase(
    val id: Int,
    val day: Int,
    val phase: Int
)

fun DayPhaseEntity.toDomain() = DayPhase(id, day, phase)
