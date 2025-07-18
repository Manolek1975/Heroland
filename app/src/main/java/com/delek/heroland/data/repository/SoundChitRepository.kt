package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.SoundChitDao
import com.delek.heroland.data.database.entities.SoundChitEntity
import com.delek.heroland.domain.model.SoundChit
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class SoundChitRepository @Inject constructor(private val soundChitDao: SoundChitDao) {

    suspend fun insertSoundChits(soundChits: List<SoundChitEntity>) {
        soundChitDao.insertSoundChits(soundChits)
    }

    suspend fun getAllSoundChits(): List<SoundChit> {
        val soundChits = soundChitDao.getAllSoundChits()
        return soundChits.map { it.toDomain() }
    }

    suspend fun getSoundChitById(id: Int): SoundChit {
        val soundChit = soundChitDao.getSoundChitById(id)
        return soundChit.toDomain()
    }




}