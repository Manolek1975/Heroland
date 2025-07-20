package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.NativeEntity

data class Native(

    val id: Int,
    val name: String,
    val weight: Int,
    val vulnerability: Int,
    val weapon: Int,
    val armor: Boolean,
    val hire: Int,
    val bounty: Int

)

fun NativeEntity.toDomain() = Native(id, name, weight, vulnerability, weapon, armor, hire, bounty)