package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.VpRoleEntity

data class VpRole(
    val id: Int,
    val roleId: Int,
    val vpTreasure: Int,
    val vpSpell: Int,
    val vpFame: Int,
    val vpNotoriety: Int,
    val vpGold: Int
)

fun VpRoleEntity.toDomain() = VpRole(id, roleId, vpTreasure, vpSpell, vpFame, vpNotoriety, vpGold)
