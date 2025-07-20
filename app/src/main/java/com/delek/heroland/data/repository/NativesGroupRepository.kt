package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.NativeGroupDao
import com.delek.heroland.data.database.entities.NativeGroupEntity
import com.delek.heroland.domain.model.NativeGroup
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class NativesGroupRepository @Inject constructor(private val nativeGroupDao: NativeGroupDao) {

    suspend fun insertNatives(natives: List<NativeGroupEntity>) {
        nativeGroupDao.insertNatives(natives)
    }

    suspend fun getNatives(): List<NativeGroup> {
        val response: List<NativeGroupEntity> = nativeGroupDao.getNatives()
        return response.map { it.toDomain() }
    }
}