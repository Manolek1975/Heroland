package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.VictoryPointsDao
import com.delek.heroland.data.database.entities.VictoryPointsEntity
import com.delek.heroland.domain.model.VictoryPoints
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class VictoryPointsRepository @Inject constructor(private val victoryPointsDao: VictoryPointsDao) {

    suspend fun insertVictoryPoints(victoryPoints: List<VictoryPointsEntity>) {
        return victoryPointsDao.insertVictoryPoints(victoryPoints)
    }

    suspend fun getVictoryPoints(): List<VictoryPoints> {
        val response: List<VictoryPointsEntity> = victoryPointsDao.getAllVictoryPoints()
        return response.map { it.toDomain() }
    }

}