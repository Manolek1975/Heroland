package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.RoleNativesDao
import com.delek.heroland.data.database.entities.NativesEntity
import com.delek.heroland.data.database.entities.RoleNativesEntity
import com.delek.heroland.domain.model.Natives
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

    suspend fun getNativesByRoleId(roleId: Int): List<Natives> {
        val response: List<NativesEntity> = roleNativesDao.getNativesByRoleId(roleId)
        return response.map { it.toDomain() }
    }

/*    suspend fun getNativesByRoleRelation(roleId: Int, relation: Int): List<Natives> {
        val response: List<NativesEntity> = roleNativesDao.getNativesByRoleRelation(roleId, relation)
        return response.map { it.toDomain() }
    }*/

    suspend fun getAllyNatives(id: Int): List<Natives> {
        val response: List<NativesEntity> = roleNativesDao.getAllyNatives(id)
        return response.map { it.toDomain() }
    }

    suspend fun getFriendlyNatives(id: Int): List<Natives> {
        val response: List<NativesEntity> = roleNativesDao.getFriendlyNatives(id)
        return response.map { it.toDomain() }
    }

    suspend fun getUnfriendNatives(id: Int): List<Natives> {
        val response: List<NativesEntity> = roleNativesDao.getUnfriendlyNatives(id)
        return response.map { it.toDomain() }
    }

    suspend fun getEnemyNatives(id: Int): List<Natives> {
        val response: List<NativesEntity> = roleNativesDao.getEnemyNatives(id)
        return response.map { it.toDomain() }
    }

}