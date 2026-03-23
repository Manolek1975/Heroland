package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.DayPhaseDao
import com.delek.heroland.data.database.entities.DayPhaseEntity
import com.delek.heroland.domain.model.DayPhase
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class DayPhaseRepository @Inject constructor(
    private val dayPhaseDao: DayPhaseDao
) {
    fun insertDayPhase(day: Int, phase: Int) {
        dayPhaseDao.insertDayPhase(day, phase)
    }

    fun getAllDayPhases(): List<DayPhase> {
        val response: List<DayPhaseEntity> = dayPhaseDao.getAllDayPhases()
        return response.map { it.toDomain() }
    }

    fun getDayPhasesByDay(day: Int): List<DayPhase> {
        val response: List<DayPhaseEntity> = dayPhaseDao.getDayPhasesByDay(day)
        return response.map { it.toDomain() }
    }
}


