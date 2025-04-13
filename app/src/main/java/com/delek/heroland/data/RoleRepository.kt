package com.delek.heroland.data

import com.delek.heroland.data.database.dao.RoleDao
import com.delek.heroland.data.database.entities.RoleEntity
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class RoleRepository @Inject constructor(private val roleDao: RoleDao) {

    suspend fun insertRoles(roles: List<RoleEntity>) {
        roleDao.insertRoles(roles)
    }

/*    suspend fun insertDwellings(dwellings: List<DwellingEntity>) {
        roleDao.insertDwellings(dwellings)
    }*/

    suspend fun getAllRoles(): List<Role> {
        val response: List<RoleEntity> = roleDao.getAllRoles()
        return response.map { it.toDomain() }
    }

    suspend fun clearRoles() {
        roleDao.deleteAllRoles()
    }

}