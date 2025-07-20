package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.NativeDao
import com.delek.heroland.data.database.entities.NativeEntity
import com.delek.heroland.domain.model.Native
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class NativeRepository @Inject constructor(private val nativeDao: NativeDao) {

    suspend fun insertNatives(natives: List<NativeEntity>) {
        nativeDao.insertNatives(natives)
    }

    suspend fun getNatives(): List<Native> {
        val response: List<NativeEntity> = nativeDao.getNatives()
        return response.map { it.toDomain() }
    }

}