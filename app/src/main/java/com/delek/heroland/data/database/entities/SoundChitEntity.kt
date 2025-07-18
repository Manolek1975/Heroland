package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sound_chits")
data class SoundChitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: String,
    val num: Int,
    val treasure: Int,
    val monster: Int
)