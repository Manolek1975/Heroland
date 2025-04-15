package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.RoleAdvantagesEntity


@Dao
interface RoleAdvantagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoleAdvantages(advantages: List<RoleAdvantagesEntity>)

    @Query("SELECT * FROM role_advantages")
    suspend fun getAllRoleAdvantages(): List<RoleAdvantagesEntity>

    @Query("SELECT * FROM advantages INNER JOIN role_advantages " +
            "ON advantages.id = role_advantages.advantage_id " +
            "WHERE role_advantages.role_id = :id")
    suspend fun getAdvantagesByRole(id: Int): List<RoleAdvantagesEntity>
}