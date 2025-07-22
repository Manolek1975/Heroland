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
    @ColumnInfo(name = "weight") val weight: String,
    @ColumnInfo(name = "weapon") val weapon: Int,
    @ColumnInfo(name = "armor") val armor: Int,
    @ColumnInfo(name = "fight_a") val fightA: String,
    @ColumnInfo(name = "move_a") val moveA: Int,
    @ColumnInfo(name = "fight_b") val fightB: String,
    @ColumnInfo(name = "move_b") val moveB: Int,
    @ColumnInfo(name = "hire") val hire: Int,
    @ColumnInfo(name = "bounty") val bounty: Int,
    @ColumnInfo(name = "horse") val horse: Int

)