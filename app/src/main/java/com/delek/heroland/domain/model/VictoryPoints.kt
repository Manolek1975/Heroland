package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.VictoryPointsEntity

data class VictoryPoints(
    val id: Int,
    val playerId: Int,
    val name: String,
    val treasures: Int,
    val spells: Int,
    val fame: Int,
    val notoriety: Int,
    val gold: Int
)

fun VictoryPointsEntity.toDomain() = VictoryPoints(id, playerId, name, treasures, spells, fame, notoriety, gold)