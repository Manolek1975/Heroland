package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advice_chits")
data class AdviceChitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: String,
    val num: Int,
    val image: String,
    val dwelling: Int,
    val monster: Int
)