package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.StartSpellEntity

@Dao
interface StartSpellDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStartSpells(startSpells: List<StartSpellEntity>)

    @Query("SELECT * FROM start_spells")
    suspend fun getAllStartSpells(): List<StartSpellEntity>

    @Query("SELECT * FROM start_spells WHERE role_id = :roleId")
    suspend fun getStartSpellsByRole(roleId: Int): List<StartSpellEntity>

}