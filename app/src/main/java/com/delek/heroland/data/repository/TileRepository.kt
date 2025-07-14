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

    fun getTiles(): List<Tile> {
        val response: List<TileEntity> = tileDao.getTiles()
        return response.map { it.toDomain() }
    }

    suspend fun updateTileCoords(x: Int, y: Int, id: Int) {
        tileDao.updateTileCoords(x, y, id)
    }

    suspend fun updateAdviceChits(advice: String, type: String, id: Int) {
        tileDao.updateAdviceChits(advice, type, id)
    }

    suspend fun updateSoundChits(sound: String, type: String, id: Int) {
        tileDao.updateSoundChits(sound, type, id)
    }

    suspend fun updateDwelling(dwelling: Int, id: Int) {
        tileDao.updateDwelling(dwelling, id)
    }

    suspend fun deleteAllTiles() {
        tileDao.deleteAllTiles()
    }

    suspend fun deletePrimaryKeyIndex() {
        tileDao.deletePrimaryKeyIndex()
    }

}