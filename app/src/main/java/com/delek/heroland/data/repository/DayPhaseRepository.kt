package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.DayPhaseDao
import com.delek.heroland.data.database.entities.DayPhaseEntity
import com.delek.heroland.domain.model.DayPhase
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class DayPhaseRepository @Inject constructor(
    private val dayPhaseDao: DayPhaseDao
) {
    suspend fun insertDayPhase(day: Int, phase: String) {
        dayPhaseDao.insertDayPhase(day, phase)
    }

    suspend fun getAllDayPhases(): List<DayPhase> {
        val response: List<DayPhaseEntity> = dayPhaseDao.getAllDayPhases()
        return response.map { it.toDomain() }
    }

    suspend fun getPhasesByDay(day: Int): List<DayPhase> {
        val response: List<DayPhaseEntity> = dayPhaseDao.getDayPhasesByDay(day)
        return response.map { it.toDomain() }
    }

    suspend fun deleteDayPhases() {
        dayPhaseDao.deleteDayPhases()
    }
}


