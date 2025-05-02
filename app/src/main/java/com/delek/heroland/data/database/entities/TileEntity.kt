package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tiles")
data class TileEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val short: String,
    val image: String,
    val enchant: String,
    val type: String
) {
}