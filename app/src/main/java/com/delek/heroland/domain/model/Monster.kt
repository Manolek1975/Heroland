package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.MonsterEntity

data class Monster(
    val id: Int,
    val name: String,
    val type: String,
    val image: String,
    val weight: String,
    val armor: Int,
    val fightA: String,
    val moveA: Int,
    val fightB: String,
    val moveB: Int,
    val bounty: Int,
    val dice: Int,
    val color: String
)

fun MonsterEntity.toDomain() = Monster(id, name, type, image, weight, armor, fightA, moveA, fightB, moveB, bounty, dice, color)