package com.delek.heroland.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.heroland.data.database.dao.AdvantageDao
import com.delek.heroland.data.database.dao.ChitDao
import com.delek.heroland.data.database.dao.DwellingDao
import com.delek.heroland.data.database.dao.RoleAdvantagesDao
import com.delek.heroland.data.database.dao.RoleChitDao
import com.delek.heroland.data.database.dao.RoleDao
import com.delek.heroland.data.database.dao.RoleDwellingDao
import com.delek.heroland.data.database.entities.AdvantageEntity
import com.delek.heroland.data.database.entities.ChitEntity
import com.delek.heroland.data.database.entities.DwellingEntity
import com.delek.heroland.data.database.entities.RoleAdvantagesEntity
import com.delek.heroland.data.database.entities.RoleChitEntity
import com.delek.heroland.data.database.entities.RoleDwellingEntity
import com.delek.heroland.data.database.entities.RoleEntity

@Database(
    entities = [
        RoleEntity::class,
        AdvantageEntity::class,
        ChitEntity::class,
        DwellingEntity::class,
        RoleAdvantagesEntity::class,
        RoleChitEntity::class,
        RoleDwellingEntity::class],
    version = 1,
    exportSchema = true
)
abstract class HerolandDatabase : RoomDatabase() {
    abstract fun getRoleDao(): RoleDao
    abstract fun getDwellingDao(): DwellingDao
    abstract fun getAdvantageDao(): AdvantageDao
    abstract fun getRoleAdvantagesDao(): RoleAdvantagesDao
    abstract fun getChitDao(): ChitDao
    abstract fun getRoleChitDao(): RoleChitDao
    abstract fun getRoleDwellingDao(): RoleDwellingDao
}
