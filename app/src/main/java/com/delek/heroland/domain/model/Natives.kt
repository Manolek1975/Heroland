package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.NativesEntity

data class Natives(
    val id: Int,
    val name: String,
    val start: Int
)

fun NativesEntity.toDomain() = Natives(id, name, start)