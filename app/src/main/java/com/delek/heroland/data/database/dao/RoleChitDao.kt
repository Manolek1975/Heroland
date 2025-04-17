package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.ChitEntity
import com.delek.heroland.data.database.entities.RoleChitEntity

@Dao
interface RoleChitDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRoleChits(roleChits: List<RoleChitEntity>)

    @Query("SELECT * FROM role_chits")
    suspend fun getAllRoleChits(): List<RoleChitEntity>

    @Query("SELECT * FROM chits INNER JOIN role_chits " +
            "ON chits.id = role_chits.chit_id " +
            "WHERE role_chits.role_id = :id")
    suspend fun getChitsByRole(id: Int): List<ChitEntity>

}