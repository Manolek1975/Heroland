package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.SpotDao
import com.delek.heroland.data.database.entities.SpotEntity
import com.delek.heroland.domain.model.Spot
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class SpotRepository @Inject constructor(
    private val spotDao: SpotDao) {

    suspend fun insertSpot(spot: List<SpotEntity>) {
        spotDao.insertSpot(spot)
    }

    suspend fun getAllSpots(): List<Spot> {
        val response: List<SpotEntity> = spotDao.getAllSpots()
        return response.map { it.toDomain() }
    }

}