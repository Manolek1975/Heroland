package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.ArmorDao
import com.delek.heroland.data.database.entities.ArmorEntity
import com.delek.heroland.domain.model.Armor
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class ArmorRepository @Inject constructor(private val armorDao: ArmorDao) {

    suspend fun insertArmor(armor: List<ArmorEntity>) {
        armorDao.insertArmor(armor)
    }

    suspend fun getAllArmor(): List<Armor> {
        val response: List<ArmorEntity> = armorDao.getAllArmor()
        return response.map { it.toDomain() }
    }

    suspend fun getArmorById(id: Int): Armor {
        val response: ArmorEntity = armorDao.getArmorById(id)
        return response.toDomain()
    }

    suspend fun clearArmor() {
        armorDao.deleteAllArmor()
    }

}