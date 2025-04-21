package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spells")
data class SpellEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("type") val type: String,
    @ColumnInfo("color") val color: String,
    @ColumnInfo("target") val target: String,
    @ColumnInfo("duration") val duration: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("short_description") val shortDescription: String
)