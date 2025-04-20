package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleNativesEntity

data class RoleNatives(
    val id: Int,
    val roleId: Int,
    val nativeId: Int,
    val relation: Int
)

fun RoleNativesEntity.toDomain() = RoleNatives(id, roleId, nativeId, relation)