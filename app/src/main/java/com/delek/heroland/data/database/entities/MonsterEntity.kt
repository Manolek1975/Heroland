package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "monsters")
data class MonsterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: String,
    val image: String,
    val weight: String,
    val armor: Int,
    val fightA: String,
    val moveA: Int,
    val fightB: String,
    val moveB: Int,
    val bounty: Int,
    val dice: Int
)