package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.ArmorEntity

data class Armor(
    val id: Int,
    val name: String,
    val image: String,
    val defense: String,
    val price: Int,
    val priceDamaged: Int
)

fun ArmorEntity.toDomain() = Armor(id, name, image, defense, price, priceDamaged)