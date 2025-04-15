package com.delek.heroland.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.heroland.data.database.dao.AdvantageDao
import com.delek.heroland.data.database.dao.DwellingDao
import com.delek.heroland.data.database.dao.RoleAdvantagesDao
import com.delek.heroland.data.database.dao.RoleDao
import com.delek.heroland.data.database.entities.AdvantageEntity
import com.delek.heroland.data.database.entities.DwellingEntity
import com.delek.heroland.data.database.entities.RoleAdvantagesEntity
import com.delek.heroland.data.database.entities.RoleEntity

@Database(
    entities = [RoleEntity::class, DwellingEntity::class, AdvantageEntity::class, RoleAdvantagesEntity::class],
    version = 1,
    exportSchema = true
)
abstract class HerolandDatabase : RoomDatabase() {
    abstract fun getRoleDao(): RoleDao
    abstract fun getDwellingDao(): DwellingDao
    abstract fun getAdvantageDao(): AdvantageDao
    abstract fun getRoleAdvantagesDao(): RoleAdvantagesDao
}
