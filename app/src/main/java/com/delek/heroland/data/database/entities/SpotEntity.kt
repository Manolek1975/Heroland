package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spot")
data class SpotEntity(
    @PrimaryKey val id: Int,
    val dice: Int,
    val advice: Int,
    val sound: Int,
    val monster: Int,
    val native: Int
)