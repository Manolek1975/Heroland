package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.PlayerEntity

data class Player(
    val id: Int,
    val name: String,
    val role: Int,
    val tile: Int,
    val clearing: Int,
    val spells: Int,
    val vp: Int,
    val weapon: Int,
    val armor: Int,
    val treasures: Int,
    val status: String

)

fun PlayerEntity.toDomain() =
    Player(id, name, role, tile, clearing, spells, vp, weapon, armor, treasures, status)