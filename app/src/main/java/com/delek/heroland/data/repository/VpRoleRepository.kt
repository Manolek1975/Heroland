package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.VpRoleDao
import com.delek.heroland.data.database.entities.VpRoleEntity
import com.delek.heroland.domain.model.VpRole
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class VpRoleRepository @Inject constructor(private val vpRoleDao: VpRoleDao) {

    suspend fun insertVpRole(vpRole: VpRoleEntity) {
        vpRoleDao.insertVpRole(vpRole)
    }

    suspend fun updateVpRole(vpRole: VpRoleEntity) {
        vpRoleDao.updateVpRole(vpRole)
    }

    suspend fun getVpRoleByRoleId(roleId: Int): VpRole {
        val response: VpRoleEntity = vpRoleDao.getVpRoleByRoleId(roleId)
        return response.toDomain()
    }

}