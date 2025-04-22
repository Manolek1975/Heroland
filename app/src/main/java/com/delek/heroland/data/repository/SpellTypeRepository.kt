package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.SpellTypeDao
import com.delek.heroland.data.database.entities.SpellTypeEntity
import com.delek.heroland.domain.model.SpellType
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class SpellTypeRepository @Inject constructor(private val spellTypeDao: SpellTypeDao) {

    suspend fun insertSpellTypes(spellTypes: List<SpellTypeEntity>) {
        spellTypeDao.insertSpellType(spellTypes)
    }

    suspend fun getAllSpellTypes(): List<SpellType> {
        val response: List<SpellTypeEntity> = spellTypeDao.getAllSpellTypes()
        return response.map { it.toDomain() }
    }


}