package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.RoleChitDao
import com.delek.heroland.data.database.entities.RoleChitEntity
import com.delek.heroland.domain.model.RoleChit
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class RoleChitRepository @Inject constructor(private val roleChitDao: RoleChitDao) {

    suspend fun insertRoleChits(roleChits: List<RoleChitEntity>) {
        roleChitDao.insertRoleChits(roleChits)
    }

    suspend fun getAllRoleChits(): List<RoleChit> {
        val response: List<RoleChitEntity> = roleChitDao.getAllRoleChits()
        return response.map { it.toDomain() }
    }

}