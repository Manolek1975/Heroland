package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.StartSpellDao
import com.delek.heroland.data.database.entities.StartSpellEntity
import com.delek.heroland.domain.model.StartSpell
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class StartSpellRepository @Inject constructor(private val startSpellDao: StartSpellDao) {

    suspend fun insertStartSpell(startSpell: List<StartSpellEntity>) {
        startSpellDao.insertStartSpells(startSpell)

    }
    suspend fun getAllStartSpells(): List<StartSpell> {
        val response: List<StartSpellEntity> = startSpellDao.getAllStartSpells()
        return response.map { it.toDomain() }
    }

}