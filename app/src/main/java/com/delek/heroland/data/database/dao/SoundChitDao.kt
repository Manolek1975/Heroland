package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.SoundChitEntity

@Dao
interface SoundChitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSoundChits(sounds: List<SoundChitEntity>)

    @Query("SELECT * FROM sound_chits")
    suspend fun getAllSoundChits(): List<SoundChitEntity>

    @Query("SELECT * FROM sound_chits WHERE id == :id")
    suspend fun getSoundChitById(id: Int): SoundChitEntity

}