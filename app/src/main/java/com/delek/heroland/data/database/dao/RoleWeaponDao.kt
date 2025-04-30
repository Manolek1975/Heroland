package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.RoleWeaponEntity

@Dao
interface RoleWeaponDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRoleWeapons(roleWeapons: List<RoleWeaponEntity>)

    @Query("SELECT * FROM role_weapons")
    suspend fun getAllRoleWeapons(): List<RoleWeaponEntity>

}