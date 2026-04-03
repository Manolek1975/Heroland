package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.PlayerEntity

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: PlayerEntity)

    @Query("SELECT * FROM players")
    suspend fun getAllPlayers(): List<PlayerEntity>

    @Query("SELECT * FROM players WHERE role = :id")
    suspend fun getPlayerById(id: Int): PlayerEntity

    @Query("UPDATE players SET location = :loc WHERE id = :id")
    suspend fun updateLocation(loc: String, id: Int)

    @Query("DELETE FROM players")
    suspend fun deleteAllPlayers()
}