package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.AdvantageDao
import com.delek.heroland.data.database.entities.AdvantageEntity
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class AdvantageRepository @Inject constructor(private val advantageDao: AdvantageDao) {

    suspend fun insertAdvantages(advantages: List<AdvantageEntity>) {
        advantageDao.insertAdvantages(advantages)
    }

    suspend fun getAllAdvantages(): List<Advantage> {
        val response: List<AdvantageEntity> = advantageDao.getAllAdvantages()
        return response.map { it.toDomain() }
    }

    suspend fun getAdvantageById(id: Int): Advantage {
        val response: AdvantageEntity = advantageDao.getAdvantageById(id)
        return response.toDomain()
    }

    suspend fun clearRoles() {
        advantageDao.deleteAllAdvantages()
    }
}