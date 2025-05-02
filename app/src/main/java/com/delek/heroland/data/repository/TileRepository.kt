package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.TileDao
import com.delek.heroland.data.database.entities.TileEntity
import com.delek.heroland.domain.model.Tile
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class TileRepository @Inject constructor(private val tileDao: TileDao) {

    suspend fun insertTiles(tiles: List<TileEntity>) {
        tileDao.insertTiles(tiles)
    }

    suspend fun getAllTiles(): List<Tile> {
        val response: List<TileEntity> = tileDao.getAllTiles()
        return response.map { it.toDomain() }
    }
}