package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.RoleAdvantageDao
import com.delek.heroland.data.database.entities.RoleAdvantageEntity
import com.delek.heroland.domain.model.RoleAdvantage
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class RoleAdvantageRepository @Inject constructor(private val roleAdvantageDao: RoleAdvantageDao) {

    suspend fun insertRoleAdvantages(advantages: List<RoleAdvantageEntity>) {
        roleAdvantageDao.insertRoleAdvantages(advantages)
    }

    suspend fun getAllRoleAdvantages(): List<RoleAdvantage> {
        val response: List<RoleAdvantageEntity> = roleAdvantageDao.getAllRoleAdvantages()
        return response.map { it.toDomain() }
    }

    suspend fun getAdvantagesByRole(id: Int): List<RoleAdvantage> {
        val response: List<RoleAdvantageEntity> = roleAdvantageDao.getAdvantagesByRole(id)
        return response.map { it.toDomain() }
    }

}