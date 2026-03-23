package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.delek.heroland.data.database.entities.DayPhaseEntity

@Dao
interface DayPhaseDao {

    @Query("INSERT INTO day_phases (day, phase) VALUES (:day, :phase)")
    fun insertDayPhase(day: Int, phase: Int)

    @Query("SELECT * FROM day_phases")
    fun getAllDayPhases(): List<DayPhaseEntity>

    @Query("SELECT * FROM day_phases WHERE day = :day")
    fun getDayPhasesByDay(day: Int): List<DayPhaseEntity>



}