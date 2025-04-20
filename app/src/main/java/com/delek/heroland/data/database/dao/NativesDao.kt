package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.NativesEntity

@Dao
interface NativesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNatives(natives: List<NativesEntity>)

    @Query("SELECT * FROM natives")
    suspend fun getNatives(): List<NativesEntity>

}