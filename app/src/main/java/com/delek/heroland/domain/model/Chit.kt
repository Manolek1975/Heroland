package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.ChitEntity

data class Chit(
    val id: Int,
    val name: String,
    val type: String,
    val speed: Int,
    val effort: String
)

fun ChitEntity.toDomain() = Chit(
    id,
    name,
    type,
    speed,
    effort
)
