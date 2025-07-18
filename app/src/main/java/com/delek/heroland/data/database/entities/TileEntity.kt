package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tiles")
data class TileEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val short: String,
    val image: String,
    val type: String,
    val advice: Int,
    val sound: Int,
    val dwelling: Int,
    val enchant: Boolean,
    val x: Int,
    val y: Int
)