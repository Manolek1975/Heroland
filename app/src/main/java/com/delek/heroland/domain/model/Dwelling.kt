package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.DwellingEntity

data class Dwelling(
    val id: Int,
    val name: String,
    val image: String,
    val tile: Int,
    val clearing: Int
)

fun DwellingEntity.toDomain() = Dwelling(
    id,
    name,
    image,
    tile,
    clearing
)