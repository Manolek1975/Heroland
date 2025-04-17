package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.ChitEntity

@Dao
interface ChitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChits(chits: List<ChitEntity>)

    @Query("SELECT * FROM chits")
    suspend fun getAllChits(): List<ChitEntity>

    @Query("DELETE FROM chits")
    suspend fun deleteAllChits()

    @Query("SELECT * FROM chits WHERE id = :id")
    suspend fun getChitById(id: Int): ChitEntity
}