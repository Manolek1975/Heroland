package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.GroupEntity

@Dao
interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(natives: List<GroupEntity>)

    @Query("SELECT * FROM groups")
    suspend fun getGroup(): List<GroupEntity>

    @Query("SELECT * FROM groups WHERE id = :id")
    suspend fun getGroupById(id: Int): GroupEntity

    @Query("SELECT * FROM groups WHERE start = :start")
    suspend fun getGroupByStart(start: Int): List<GroupEntity>


}