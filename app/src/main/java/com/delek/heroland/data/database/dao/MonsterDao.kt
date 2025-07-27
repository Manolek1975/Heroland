package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.MonsterEntity

@Dao
interface MonsterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(monsters: List<MonsterEntity>)

    @Query("SELECT * FROM monsters")
    suspend fun getAllMonsters(): List<MonsterEntity>

    @Query("SELECT * FROM monsters WHERE id = :id")
    suspend fun getMonsterById(id: Int): MonsterEntity


}