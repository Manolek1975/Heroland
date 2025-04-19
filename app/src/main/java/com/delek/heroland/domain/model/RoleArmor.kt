package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleArmorEntity

data class RoleArmor(
    val id: Int,
    val roleId: Int,
    val armorId: Int,
)

fun RoleArmorEntity.toDomain() = RoleArmor(id, roleId, armorId)