package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.AdviceChitEntity

@Dao
interface AdviceChitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdviceChit(advices: List<AdviceChitEntity>)

    @Query("SELECT * FROM advice_chits")
    suspend fun getAllAdviceChits(): List<AdviceChitEntity>

    @Query("SELECT * FROM advice_chits WHERE type = 'A'")
    suspend fun getAdviceChitByType(): List<AdviceChitEntity>

    @Query("SELECT * FROM advice_chits WHERE type == 'S' OR type == 'T'")
    suspend fun getSoundChitsByType(): List<AdviceChitEntity>

    @Query("SELECT * FROM advice_chits WHERE id == :id")
    suspend fun getAdviceChitById(id: Int): AdviceChitEntity
}