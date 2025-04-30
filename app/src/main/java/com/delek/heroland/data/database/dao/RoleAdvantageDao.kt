package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.RoleAdvantageEntity


@Dao
interface RoleAdvantageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoleAdvantages(advantages: List<RoleAdvantageEntity>)

    @Query("SELECT * FROM role_advantages")
    suspend fun getAllRoleAdvantages(): List<RoleAdvantageEntity>

}