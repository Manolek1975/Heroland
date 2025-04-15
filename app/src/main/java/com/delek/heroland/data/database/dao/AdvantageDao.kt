package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.AdvantageEntity

@Dao
interface AdvantageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdvantages(advantages: List<AdvantageEntity>)

    @Query("SELECT * FROM advantages")
    suspend fun getAllAdvantages(): List<AdvantageEntity>

    @Query("DELETE FROM advantages")
    suspend fun deleteAllAdvantages()

    @Query("SELECT * FROM advantages WHERE id = :id")
    suspend fun getAdvantageById(id: Int): AdvantageEntity

}