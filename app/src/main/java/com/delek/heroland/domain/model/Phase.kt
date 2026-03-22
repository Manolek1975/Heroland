package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.PhaseEntity


data class Phase(
    val id: Int,
    val name: String
)

fun PhaseEntity.toDomain() = Phase(id, name)

