package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.WeaponEntity

data class Weapon(
    val id: Int,
    val name: String,
    val image: String,
    val alert: String,
    val damage: String,
    val plus: String,
    val plusAlert: String,
    val type: String,
    val length: Int,
    val speed: Int,
    val speedAlert: Int,
    val price: Int
)

fun WeaponEntity.toDomain() = Weapon(
    id,
    name,
    image,
    alert,
    damage,
    plus,
    plusAlert,
    type,
    length,
    speed,
    speedAlert,
    price
)