package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.SpellTypeEntity

data class SpellType(
    val id: Int,
    val roleId: Int,
    val spellId: Int,
    val type: String
)

fun SpellTypeEntity.toDomain() = SpellType(id, roleId, spellId, type)