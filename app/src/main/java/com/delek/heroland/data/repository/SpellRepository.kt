package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.SpellDao
import com.delek.heroland.data.database.entities.SpellEntity
import com.delek.heroland.domain.model.Spell
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class SpellRepository @Inject constructor(private val spellDao: SpellDao) {

    suspend fun insertSpells(spell: List<SpellEntity>) {
        spellDao.insertSpells(spell)
    }

    suspend fun getAllSpells(): List<Spell> {
        val response: List<SpellEntity> = spellDao.getAllSpells()
        return response.map { it.toDomain() }
    }
}