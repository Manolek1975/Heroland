package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.ClearingEntity

@Dao
interface ClearingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClearing(clearing: List<ClearingEntity>)

    @Query("SELECT * FROM clearings")
    suspend fun getAllClearings(): List<ClearingEntity>

    @Query("SELECT * FROM clearings WHERE id = :id")
    suspend fun getClearingById(id: Int): ClearingEntity

    @Query("SELECT * FROM clearings WHERE tile = :tile AND clearing = :clearing")
    suspend fun getClearingByLocation(tile: Int, clearing: Int): ClearingEntity

}