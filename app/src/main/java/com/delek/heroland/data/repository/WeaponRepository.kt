package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.WeaponDao
import com.delek.heroland.data.database.entities.WeaponEntity
import com.delek.heroland.domain.model.Weapon
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class WeaponRepository @Inject constructor(private val weaponDao: WeaponDao) {

    suspend fun insertWeapons(weapons: List<WeaponEntity>) {
        return weaponDao.insertAll(weapons)
    }

    suspend fun getAllWeapons(): List<Weapon> {
        val response: List<WeaponEntity> = weaponDao.getAllWeapons()
        return response.map { it.toDomain() }
    }

    suspend fun getWeaponById(id: Int): Weapon {
        val response: WeaponEntity = weaponDao.getWeaponById(id)
        return response.toDomain()
    }

    suspend fun clearWeapons() {
        return weaponDao.deleteAllWeapons()
    }
}

