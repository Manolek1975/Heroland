package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.GroupEntity

data class Group(
    val id: Int,
    val name: String,
    val start: Int
)

fun GroupEntity.toDomain() = Group(id, name, start)