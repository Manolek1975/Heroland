package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.TileEntity

@Dao
interface TileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTiles(tiles: List<TileEntity>)

    @Query("SELECT * FROM tiles")
    suspend fun getAllTiles(): List<TileEntity>

    @Query("SELECT * FROM tiles")
    fun getTiles(): List<TileEntity>

    @Query("SELECT * FROM tiles WHERE id = :id")
    suspend fun getTileById(id: Int): TileEntity

    @Query("SELECT * FROM tiles WHERE type = :type")
    suspend fun getTilesByType(type: String): List<TileEntity>

    @Query("SELECT * FROM tiles WHERE advice = :id")
    suspend fun getTileByAdviceId(id: Int): TileEntity

    @Query("UPDATE tiles SET advice = :advice WHERE id = :id")
    suspend fun updateTileAdvice(advice: Int, id: Int)

    @Query("UPDATE tiles SET sound = :sound WHERE id = :id")
    suspend fun updateTileSound(sound: Int, id: Int)

    @Query("UPDATE tiles SET x = :x, y = :y WHERE id = :id")
    suspend fun updateTileCoords(x: Int, y: Int, id: Int)

    @Query("UPDATE tiles SET advice = :advice WHERE type = :type AND id = :id")
    suspend fun updateAdviceChits(advice: String, type: String, id: Int)

    @Query("UPDATE tiles SET sound = :sound WHERE type = :type AND id = :id")
    suspend fun updateSoundChits(sound: String, type: String, id: Int)

    @Query("UPDATE tiles SET dwelling = :dwelling WHERE id = :id")
    suspend fun updateDwelling(dwelling: Int, id: Int)

    @Query("DELETE FROM tiles")
    suspend fun deleteAllTiles()

    @Query("DELETE FROM sqlite_sequence WHERE name = 'tiles'")
    suspend fun deletePrimaryKeyIndex()


}