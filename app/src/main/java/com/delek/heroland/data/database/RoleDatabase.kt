package com.delek.heroland.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.heroland.data.database.dao.RoleDao
import com.delek.heroland.data.database.entities.RoleEntity

@Database(entities = [RoleEntity::class], version = 1, exportSchema = true)
abstract class RoleDatabase: RoomDatabase() {

    abstract fun getRoleDao(): RoleDao

}