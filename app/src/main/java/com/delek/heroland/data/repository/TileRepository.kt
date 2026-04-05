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

    suspend fun getTileById(id: Int): Tile {
        val response: TileEntity = tileDao.getTileById(id)
        return response.toDomain()
    }

    suspend fun getTileByShort(short: String) : Tile {
        val response: TileEntity = tileDao.getTileByShort(short)
        return response.toDomain()
    }

    suspend fun getTileByAdviceId(id: Int): Tile {
        val response: TileEntity = tileDao.getTileByAdviceId(id)
        return response.toDomain()
    }

    fun getTiles(): List<Tile> {
        val response: List<TileEntity> = tileDao.getTiles()
        return response.map { it.toDomain() }
    }

    suspend fun updateTileAdvice(advice: Int, id: Int) {
        tileDao.updateTileAdvice(advice, id)
    }

    suspend fun updateTileSound(sound: Int, id: Int) {
        tileDao.updateTileSound(sound, id)
    }

    suspend fun deleteAllTiles() {
        tileDao.deleteAllTiles()
    }

    suspend fun deletePrimaryKeyIndex() {
        tileDao.deletePrimaryKeyIndex()
    }

}