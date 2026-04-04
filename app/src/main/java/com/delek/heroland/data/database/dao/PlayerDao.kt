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

    @Query("SELECT * FROM players WHERE role = :role")
    suspend fun getPlayerByRole(role: Int): PlayerEntity

    @Query("UPDATE players SET location = :loc WHERE role = :role")
    suspend fun updateLocation(loc: String, role: Int)

    @Query("DELETE FROM players")
    suspend fun deleteAllPlayers()
}