package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.NativesDao
import com.delek.heroland.data.database.entities.NativesEntity
import com.delek.heroland.domain.model.Natives
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class NativesRepository @Inject constructor(private val nativesDao: NativesDao) {

    suspend fun insertNatives(natives: List<NativesEntity>) {
        nativesDao.insertNatives(natives)
    }

    suspend fun getNatives(): List<Natives> {
        val response: List<NativesEntity> = nativesDao.getNatives()
        return response.map { it.toDomain() }
    }
}