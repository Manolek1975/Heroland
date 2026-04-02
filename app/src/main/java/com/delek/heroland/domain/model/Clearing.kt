package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.ClearingEntity

data class Clearing(
    val id: Int,
    val idTile: Int,
    val name: String,
    val con1: String,
    val con2: String
)

fun ClearingEntity.toDomain() = Clearing(id, idTile, name, con1, con2)

