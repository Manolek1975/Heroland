package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.VictoryPointsEntity

data class VictoryPoints(
    val id: Int,
    val name: String,
    val value: Int
)

fun VictoryPointsEntity.toDomain() = VictoryPoints(id, name, value)