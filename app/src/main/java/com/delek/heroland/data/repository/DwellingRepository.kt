package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.DwellingDao
import com.delek.heroland.data.database.entities.DwellingEntity
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class DwellingRepository @Inject constructor(private val dwellingDao: DwellingDao) {

    suspend fun insertDwellings(dwellings: List<DwellingEntity>) {
        dwellingDao.insertDwellings(dwellings)
    }

    suspend fun getAllDwellings(): List<Dwelling> {
        val response: List<DwellingEntity> = dwellingDao.getAllDwellings()
        return response.map { it.toDomain() }
    }

    suspend fun clearDwellings() {
        dwellingDao.deleteAllDwellings()
    }
}