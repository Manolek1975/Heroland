package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clearings")
data class ClearingEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tile: Int,
    val clearing: Int,
    val name: String,
    val con1: String,
    val con2: String
)