package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advice_chits")
data class AdviceChitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: String,
    val dice: Int,
    val dwelling: Int,
    val monster: Int,
    val native: Int
)