package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dwellings")
data class DwellingEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val image: String,
    val tile: Int,
    val clearing: Int
)

