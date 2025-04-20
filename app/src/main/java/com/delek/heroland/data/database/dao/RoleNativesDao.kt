package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.NativesEntity
import com.delek.heroland.data.database.entities.RoleNativesEntity

@Dao
interface RoleNativesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoleNatives(list: List<RoleNativesEntity>)

    @Query("SELECT * FROM role_natives")
    suspend fun getAllRoleNatives(): List<RoleNativesEntity>

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id")
    suspend fun getNativesByRoleId(id: Int): List<NativesEntity>

/*    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = :relation")
    suspend fun getNativesByRoleRelation(id: Int, relation: Int): List<NativesEntity>*/

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = '1'")
    suspend fun getAllyNatives(id: Int): List<NativesEntity>

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = '2'")
    suspend fun getFriendlyNatives(id: Int): List<NativesEntity>

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = '4'")
    suspend fun getUnfriendlyNatives(id: Int): List<NativesEntity>

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = '5'")
    suspend fun getEnemyNatives(id: Int): List<NativesEntity>

}