package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.RoleNativesDao
import com.delek.heroland.data.database.entities.RoleNativesEntity
import com.delek.heroland.domain.model.RoleNatives
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class RoleNativesRepository @Inject constructor(private val roleNativesDao: RoleNativesDao) {

    suspend fun insertRoleNatives(list: List<RoleNativesEntity>) {
        roleNativesDao.insertRoleNatives(list)
    }

    suspend fun getAllRoleNatives(): List<RoleNatives> {
        val response: List<RoleNativesEntity> = roleNativesDao.getAllRoleNatives()
        return response.map { it.toDomain() }
    }

}