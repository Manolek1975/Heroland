package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.ClearingEntity

data class Clearing(
    val id: Int,
    val name: String,
    val idTile: Int,
    val con1: Int,
    val con2: Int
)

fun ClearingEntity.toDomain() = Clearing(id, name, idTile, con1, con2)

