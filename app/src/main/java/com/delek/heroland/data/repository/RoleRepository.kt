package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.RoleDao
import com.delek.heroland.data.database.entities.ArmorEntity
import com.delek.heroland.data.database.entities.ChitEntity
import com.delek.heroland.data.database.entities.DwellingEntity
import com.delek.heroland.data.database.entities.NativesEntity
import com.delek.heroland.data.database.entities.RoleAdvantageEntity
import com.delek.heroland.data.database.entities.RoleEntity
import com.delek.heroland.data.database.entities.StartSpellEntity
import com.delek.heroland.data.database.entities.WeaponEntity
import com.delek.heroland.domain.model.Armor
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Natives
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.RoleAdvantage
import com.delek.heroland.domain.model.StartSpell
import com.delek.heroland.domain.model.Weapon
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class RoleRepository @Inject constructor(private val roleDao: RoleDao) {

    suspend fun insertRoles(roles: List<RoleEntity>) {
        roleDao.insertRoles(roles)
    }

    suspend fun getAllRoles(): List<Role> {
        val response: List<RoleEntity> = roleDao.getAllRoles()
        return response.map { it.toDomain() }
    }

    suspend fun getRoleById(id: Int): Role {
        val response: RoleEntity = roleDao.getRoleById(id)
        return response.toDomain()
    }

    suspend fun getDwellingsByRole(id: Int): List<Dwelling> {
        val response: List<DwellingEntity> = roleDao.getDwellingsByRole(id)
        return response.map { it.toDomain() }
    }

    suspend fun getStartSpellsByRole(roleId: Int): List<StartSpell> {
        val response: List<StartSpellEntity> = roleDao.getStartSpellsByRole(roleId)
        return response.map { it.toDomain() }
    }

    suspend fun countStartSpells(id: Int): Int {
        return roleDao.countStartSpells(id)
    }

    suspend fun getAdvantagesByRole(id: Int): List<RoleAdvantage> {
        val response: List<RoleAdvantageEntity> = roleDao.getAdvantagesByRole(id)
        return response.map { it.toDomain() }
    }

    suspend fun getChitsByRole(id: Int): List<Chit> {
        val response: List<ChitEntity> = roleDao.getChitsByRole(id)
        return response.map { it.toDomain() }
    }

    suspend fun getWeaponsByRole(id: Int): List<Weapon> {
        val response: List<WeaponEntity> = roleDao.getWeaponsByRole(id)
        return response.map { it.toDomain() }
    }

    suspend fun getArmorByRole(id: Int): List<Armor> {
        val response: List<ArmorEntity> = roleDao.getArmorByRole(id)
        return response.map { it.toDomain() }
    }

    suspend fun getAllyNatives(id: Int): List<Natives> {
        val response: List<NativesEntity> = roleDao.getAllyNatives(id)
        return response.map { it.toDomain() }
    }

    suspend fun getFriendlyNatives(id: Int): List<Natives> {
        val response: List<NativesEntity> = roleDao.getFriendlyNatives(id)
        return response.map { it.toDomain() }
    }

    suspend fun getUnfriendNatives(id: Int): List<Natives> {
        val response: List<NativesEntity> = roleDao.getUnfriendlyNatives(id)
        return response.map { it.toDomain() }
    }

    suspend fun getEnemyNatives(id: Int): List<Natives> {
        val response: List<NativesEntity> = roleDao.getEnemyNatives(id)
        return response.map { it.toDomain() }
    }


}