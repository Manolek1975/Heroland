package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.NativeGroupEntity

@Dao
interface NativeGroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNativeGroup(natives: List<NativeGroupEntity>)

    @Query("SELECT * FROM native_group")
    suspend fun getNativeGroup(): List<NativeGroupEntity>

}