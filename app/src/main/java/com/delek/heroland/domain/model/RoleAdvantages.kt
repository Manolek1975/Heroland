package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleAdvantagesEntity

data class RoleAdvantages(
    val roleId: Int,
    val advantageId: Int
)

fun RoleAdvantagesEntity.toDomain() = RoleAdvantages(
    roleId,
    advantageId
)
