package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.delek.heroland.data.database.entities.RoleEntity

@Dao
interface RoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(roles: List<RoleEntity>)

    @Query("SELECT * FROM roles")
    suspend fun getAllRoles(): List<RoleEntity>

    @Query("DELETE FROM roles")
    suspend fun deleteAllRoles()

}