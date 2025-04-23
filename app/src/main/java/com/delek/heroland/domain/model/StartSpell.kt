package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.StartSpellEntity

data class StartSpell(
    val id: Int,
    val roleId: Int,
    val typeId: Int,
    val spellType: String,
)

fun StartSpellEntity.toDomain() = StartSpell(id, roleId, typeId, spellType)