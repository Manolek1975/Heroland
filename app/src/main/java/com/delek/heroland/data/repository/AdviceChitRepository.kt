package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.AdviceChitDao
import com.delek.heroland.data.database.entities.AdviceChitEntity
import com.delek.heroland.domain.model.AdviceChit
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class AdviceChitRepository @Inject constructor(private val adviceChitDao: AdviceChitDao) {

    suspend fun insertAdviceChits(advices: List<AdviceChitEntity>) {
        adviceChitDao.insertAdviceChit(advices)
    }

    suspend fun getAllAdviceChits(): List<AdviceChit> {
        val response: List<AdviceChitEntity> = adviceChitDao.getAllAdviceChits()
        return response.map { it.toDomain() }
    }

    suspend fun getAdviceChitsByType(type: String): List<AdviceChit> {
        val response: List<AdviceChitEntity> = adviceChitDao.getAdviceChitByType(type)
        return response.map { it.toDomain() }
    }

}