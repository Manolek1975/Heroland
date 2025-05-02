package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.TileEntity

data class Tile(
    val id: Int,
    val name: String,
    val short: String,
    val image: String,
    val enchant: String,
    val type: String
)

fun TileEntity.toDomain() = Tile(id, name, short, image, enchant, type)