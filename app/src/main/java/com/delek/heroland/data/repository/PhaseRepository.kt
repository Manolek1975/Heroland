package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.PhaseDao
import com.delek.heroland.data.database.entities.PhaseEntity
import com.delek.heroland.domain.model.Phase
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class PhaseRepository @Inject constructor(private val phaseDao: PhaseDao) {

    suspend fun insertPhases(phases: List<PhaseEntity>) {
        phaseDao.insertPhase(phases)
    }

    suspend fun getPhases(): List<Phase> {
        val response: List<PhaseEntity> = phaseDao.getPhase()
        return response.map { it.toDomain() }
    }
}