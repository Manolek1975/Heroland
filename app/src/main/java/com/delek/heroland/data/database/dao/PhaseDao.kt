package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.PhaseEntity

@Dao
interface PhaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhase(phase: List<PhaseEntity>)

    @Query("SELECT * FROM phases")
    suspend fun getPhase(): List<PhaseEntity>


}