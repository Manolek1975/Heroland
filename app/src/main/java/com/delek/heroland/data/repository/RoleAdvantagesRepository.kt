package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.RoleAdvantagesDao
import com.delek.heroland.data.database.entities.RoleAdvantagesEntity
import com.delek.heroland.domain.model.RoleAdvantages
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class RoleAdvantagesRepository @Inject constructor(private val roleAdvantagesDao: RoleAdvantagesDao) {

    suspend fun insertRoleAdvantages(advantages: List<RoleAdvantagesEntity>) {
        roleAdvantagesDao.insertRoleAdvantages(advantages)
    }

    suspend fun getAllRoleAdvantages(): List<RoleAdvantages> {
        val response: List<RoleAdvantagesEntity> = roleAdvantagesDao.getAllRoleAdvantages()
        return response.map { it.toDomain() }
    }

    suspend fun getAdvantagesByRole(id: Int): List<RoleAdvantages> {
        val response: List<RoleAdvantagesEntity> = roleAdvantagesDao.getAdvantagesByRole(id)
        return response.map { it.toDomain() }
    }



/*    suspend fun getAdvantageById(id: Int): Advantage {
        val response: AdvantageEntity = advantageDao.getAdvantageById(id)
        return response.toDomain()
    }*/

/*    suspend fun clearRoles() {
        advantageDao.deleteAllAdvantages()
    }*/
}