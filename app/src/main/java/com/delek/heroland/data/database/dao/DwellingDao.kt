package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.DwellingEntity

@Dao
interface DwellingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDwellings(dwellings: List<DwellingEntity>)

    @Query("SELECT * FROM dwellings")
    suspend fun getAllDwellings(): List<DwellingEntity>

    @Query("SELECT * FROM dwellings WHERE id = :id")
    suspend fun getDwellingById(id: Int): DwellingEntity

    @Query("DELETE FROM dwellings")
    suspend fun deleteAllDwellings()
}