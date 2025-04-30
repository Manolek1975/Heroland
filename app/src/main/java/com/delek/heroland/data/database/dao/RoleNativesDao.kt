package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.RoleNativesEntity

@Dao
interface RoleNativesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoleNatives(list: List<RoleNativesEntity>)

    @Query("SELECT * FROM role_natives")
    suspend fun getAllRoleNatives(): List<RoleNativesEntity>

}