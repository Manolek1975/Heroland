package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.SpotEntity

@Dao
interface SpotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpot(spotEntity: List<SpotEntity>)

    @Query("SELECT * FROM spot")
    suspend fun getAllSpots(): List<SpotEntity>



}