package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.NativeGroupEntity

data class NativeGroup(
    val id: Int,
    val name: String,
    val start: Int
)

fun NativeGroupEntity.toDomain() = NativeGroup(id, name, start)