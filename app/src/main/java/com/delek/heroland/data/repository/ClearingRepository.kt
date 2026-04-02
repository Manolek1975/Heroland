package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.ClearingDao
import com.delek.heroland.data.database.entities.ClearingEntity
import com.delek.heroland.domain.model.Clearing
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class ClearingRepository @Inject constructor(private val clearingDao: ClearingDao) {

    suspend fun insertClearing(clearings: List<ClearingEntity>) {
        clearingDao.insertClearing(clearings)
    }

    suspend fun getAllClearings(): List<Clearing> {
        val response: List<ClearingEntity> = clearingDao.getAllClearings()
        return response.map { it.toDomain() }
    }

    suspend fun getClearingById(id: Int): Clearing {
        val response: ClearingEntity = clearingDao.getClearingById(id)
        return response.toDomain()
    }

}