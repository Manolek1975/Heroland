package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleAdvantageEntity

data class RoleAdvantage(
    val roleId: Int,
    val advantageId: Int
)

fun RoleAdvantageEntity.toDomain() = RoleAdvantage(
    roleId,
    advantageId
)
