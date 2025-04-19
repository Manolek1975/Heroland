package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.ArmorEntity

@Dao
interface ArmorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArmor(armor: List<ArmorEntity>)

    @Query("SELECT * FROM armor")
    suspend fun getAllArmor(): List<ArmorEntity>

    @Query("DELETE FROM armor")
    suspend fun deleteAllArmor()

    @Query("SELECT * FROM armor WHERE id = :id")
    suspend fun getArmorById(id: Int): ArmorEntity

}