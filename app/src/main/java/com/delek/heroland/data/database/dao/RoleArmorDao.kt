package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.ArmorEntity
import com.delek.heroland.data.database.entities.RoleArmorEntity

@Dao
interface RoleArmorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRoleArmor(roleArmor: List<RoleArmorEntity>)

    @Query("SELECT * FROM role_armor")
    suspend fun getAllRoleArmor(): List<RoleArmorEntity>

    @Query("SELECT * FROM armor INNER JOIN role_armor " +
            "ON armor.id = role_armor.armor_id " +
            "WHERE role_armor.role_id = :id")
    suspend fun getArmorByRole(id: Int): List<ArmorEntity>



}