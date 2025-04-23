package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.SpellEntity

data class Spell(
    val id: Int,
    val name: String,
    val type: String,
    val color: String,
    val target: String,
    val duration: String,
    val typeName: String,
    val description: String,
    val shortDescription: String
)

fun SpellEntity.toDomain() = Spell(id, name, type, color, target, duration, description, typeName, shortDescription)