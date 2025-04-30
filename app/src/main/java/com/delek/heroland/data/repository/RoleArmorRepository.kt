package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.RoleArmorDao
import com.delek.heroland.data.database.entities.RoleArmorEntity
import com.delek.heroland.domain.model.RoleArmor
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class RoleArmorRepository @Inject constructor(private val roleArmorDao: RoleArmorDao) {

    suspend fun insertRoleArmor(roleArmor: List<RoleArmorEntity>) {
        roleArmorDao.insertRoleArmor(roleArmor)
    }

    suspend fun getAllRoleArmor(): List<RoleArmor> {
        val response: List<RoleArmorEntity> = roleArmorDao.getAllRoleArmor()
        return response.map { it.toDomain() }
    }

}