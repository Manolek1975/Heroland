package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "victory_points")
data class VictoryPointsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("player_id") val playerId: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("treasures") val treasures: Int,
    @ColumnInfo("spells") val spells: Int,
    @ColumnInfo("fame") val fame: Int,
    @ColumnInfo("notoriety") val notoriety: Int,
    @ColumnInfo("gold") val gold: Int
)