package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.SpotEntity

data class Spot(
    val id: Int,
    val dice: Int,
    val advice: Int,
    val sound: Int,
    val monster: Int,
    val native: Int

)

fun SpotEntity.toDomain() = Spot(id, dice, advice, sound, monster, native)