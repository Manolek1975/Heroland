package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("role") val role: Int,
    @ColumnInfo("location") val location: Int,
    @ColumnInfo("spells") val spells: Int,
    @ColumnInfo("vp") val vp: Int,
    @ColumnInfo("weapon") val weapon: Int,
    @ColumnInfo("armor") val armor: Int,
    @ColumnInfo("treasures") val treasures: Int
)