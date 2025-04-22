package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.SpellTypeEntity

@Dao
interface SpellTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpellType(spellType: List<SpellTypeEntity>)

    @Query("SELECT * FROM spell_types")
    suspend fun getAllSpellTypes(): List<SpellTypeEntity>




}