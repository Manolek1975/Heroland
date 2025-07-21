package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.NativeEntity


@Dao
interface NativeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNatives(natives: List<NativeEntity>)

    @Query("SELECT * FROM natives")
    suspend fun getNatives(): List<NativeEntity>

    @Query("SELECT * FROM natives WHERE id = :id")
    suspend fun getNativeById(id: Int): List<NativeEntity>

    @Query("SELECT * FROM natives WHERE group_id = :groupId")
    suspend fun getNativeByGroup(groupId: Int): List<NativeEntity>
}