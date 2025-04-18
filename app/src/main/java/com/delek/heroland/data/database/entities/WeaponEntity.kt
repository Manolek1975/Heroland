package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weapons")
data class WeaponEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("image") val image: String,
    @ColumnInfo("alert") val alert: String,
    @ColumnInfo("damage") val damage: String,
    @ColumnInfo("plus") val plus: String,
    @ColumnInfo("plus_alert") val plusAlert: String,
    @ColumnInfo("type") val type: String,
    @ColumnInfo("length") val length: Int,
    @ColumnInfo("speed") val speed: Int,
    @ColumnInfo("speed_alert") val speedAlert: Int,
    @ColumnInfo("price") val price: Int
)