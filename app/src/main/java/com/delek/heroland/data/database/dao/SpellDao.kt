package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.SpellEntity

@Dao
interface SpellDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpells(spell: List<SpellEntity>)

    @Query("SELECT * FROM spells")
    suspend fun getAllSpells(): List<SpellEntity>

    @Query("SELECT * FROM spells WHERE id = :id")
    suspend fun getSpellById(id: Int): SpellEntity

}