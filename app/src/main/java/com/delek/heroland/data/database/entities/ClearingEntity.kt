package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clearings")
data class ClearingEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val idTile: Int,
    val con1: Int,
    val con2: Int
)