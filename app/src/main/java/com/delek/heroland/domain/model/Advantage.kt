package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.AdvantageEntity

data class Advantage(
    val id: Int,
    val name: String,
    val description: String
)

fun AdvantageEntity.toDomain() = Advantage(
    id,
    name,
    description
)