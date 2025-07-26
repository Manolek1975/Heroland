package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.MonsterDao
import com.delek.heroland.data.database.entities.MonsterEntity
import com.delek.heroland.domain.model.Monster
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class MonsterRepository @Inject constructor(private val monsterDao: MonsterDao) {

    suspend fun insertMonsters(monsters: List<MonsterEntity>) {
        monsterDao.insertAll(monsters)
    }

    suspend fun getAllMonsters(): List<Monster> {
        val response: List<MonsterEntity> = monsterDao.getAllMonsters()
        return response.map { it.toDomain() }
    }

}