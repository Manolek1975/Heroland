package com.delek.heroland.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day_phases")
data class DayPhaseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val day: Int,
    val phase: Int
)