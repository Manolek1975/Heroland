package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.TileEntity

data class Tile(
    val id: Int,
    val name: String,
    val short: String,
    val image: String,
    val type: String,
    val advice: String,
    val sound: String,
    val enchant: Boolean,
    val x: Int,
    val y: Int
)

fun TileEntity.toDomain() = Tile(id, name, short, image, type, advice, sound, enchant, x, y)