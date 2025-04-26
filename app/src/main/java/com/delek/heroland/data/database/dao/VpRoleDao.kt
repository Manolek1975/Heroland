package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.delek.heroland.data.database.entities.VpRoleEntity

@Dao
interface VpRoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVpRole(vpRole: VpRoleEntity)

    @Update
    suspend fun updateVpRole(vpRole: VpRoleEntity)

    @Query("SELECT * FROM vp_role WHERE role_id = :roleId")
    suspend fun getVpRoleByRoleId(roleId: Int): VpRoleEntity

}