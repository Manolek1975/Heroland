package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.NativeEntity

data class Native(

    val id: Int,
    val name: String,
    val type: String,
    val groupId: Int,
    val image: String,
    val weight: String,
    val weapon: Int,
    val armor: Int,
    val fightA: String,
    val moveA: Int,
    val fightB: String,
    val moveB: Int,
    val hire: Int,
    val bounty: Int,
    val horses: Int
)

fun NativeEntity.toDomain() = Native(id, name, type, groupId, image, weight,
    weapon, armor, fightA, moveA, fightB, moveB, hire, bounty, horse)