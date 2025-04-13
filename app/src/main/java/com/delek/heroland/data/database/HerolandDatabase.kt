package com.delek.heroland.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.heroland.data.database.dao.DwellingDao
import com.delek.heroland.data.database.dao.RoleDao
import com.delek.heroland.data.database.entities.DwellingEntity
import com.delek.heroland.data.database.entities.RoleEntity

@Database(entities = [RoleEntity::class, DwellingEntity::class], version = 1, exportSchema = true)
abstract class HerolandDatabase: RoomDatabase() {
    abstract fun getRoleDao(): RoleDao
    abstract fun getDwellingDao(): DwellingDao
}
