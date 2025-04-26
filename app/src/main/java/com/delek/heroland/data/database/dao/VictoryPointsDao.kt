package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.VictoryPointsEntity

@Dao
interface VictoryPointsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVictoryPoints(victoryPoints: List<VictoryPointsEntity>)

    @Query("UPDATE victory_points SET value = :value WHERE id = :id")
    suspend fun updateVictoryPoints(value: Int, id: Int)

    @Query("SELECT * FROM victory_points")
    suspend fun getAllVictoryPoints(): List<VictoryPointsEntity>

}