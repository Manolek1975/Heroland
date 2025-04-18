package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleDwellingEntity

data class RoleDwelling(
    val id: Int,
    val roleId: Int,
    val dwellingId: Int
)

fun RoleDwellingEntity.toDomain() = RoleDwelling(id, roleId, dwellingId)