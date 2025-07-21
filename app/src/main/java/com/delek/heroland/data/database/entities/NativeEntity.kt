package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "natives")
data class NativeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "group_id") val groupId: Int,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "vulnerability") val vulnerability: Int,
    @ColumnInfo(name = "weapon") val weapon: Int,
    @ColumnInfo(name = "armor") val armor: Boolean,
    @ColumnInfo(name = "hire") val hire: Int,
    @ColumnInfo(name = "bounty") val bounty: Int

)