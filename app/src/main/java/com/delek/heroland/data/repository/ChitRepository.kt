package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.ChitDao
import com.delek.heroland.data.database.entities.ChitEntity
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class ChitRepository @Inject constructor(private val chitDao: ChitDao) {

    suspend fun insertChits(chits: List<ChitEntity>) {
        chitDao.insertChits(chits)
    }

    suspend fun getAllChits(): List<Chit> {
        val response: List<ChitEntity> = chitDao.getAllChits()
        return response.map { it.toDomain() }
    }

    suspend fun clearChits() {
        chitDao.deleteAllChits()
    }

}