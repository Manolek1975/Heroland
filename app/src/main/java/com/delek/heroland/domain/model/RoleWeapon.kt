package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleWeaponEntity

data class RoleWeapon(
    val id: Int,
    val roleId: Int,
    val weaponId: Int
)

fun RoleWeaponEntity.toDomain() = RoleWeapon(
    id,
    roleId,
    weaponId
)
