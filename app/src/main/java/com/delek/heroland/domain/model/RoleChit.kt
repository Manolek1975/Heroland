package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleChitEntity

data class RoleChit(
    val id: Int,
    val roleId: Int,
    val chitId: Int
)

fun RoleChitEntity.toDomain() = RoleChit(id, roleId, chitId)