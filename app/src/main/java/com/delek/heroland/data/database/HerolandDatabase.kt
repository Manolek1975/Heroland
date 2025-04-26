package com.delek.heroland.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.heroland.data.database.dao.AdvantageDao
import com.delek.heroland.data.database.dao.ArmorDao
import com.delek.heroland.data.database.dao.ChitDao
import com.delek.heroland.data.database.dao.DwellingDao
import com.delek.heroland.data.database.dao.NativesDao
import com.delek.heroland.data.database.dao.PlayerDao
import com.delek.heroland.data.database.dao.RoleAdvantageDao
import com.delek.heroland.data.database.dao.RoleArmorDao
import com.delek.heroland.data.database.dao.RoleChitDao
import com.delek.heroland.data.database.dao.RoleDao
import com.delek.heroland.data.database.dao.RoleDwellingDao
import com.delek.heroland.data.database.dao.RoleNativesDao
import com.delek.heroland.data.database.dao.RoleWeaponDao
import com.delek.heroland.data.database.dao.SpellDao
import com.delek.heroland.data.database.dao.SpellTypeDao
import com.delek.heroland.data.database.dao.StartSpellDao
import com.delek.heroland.data.database.dao.VictoryPointsDao
import com.delek.heroland.data.database.dao.WeaponDao
import com.delek.heroland.data.database.dao.VpRoleDao
import com.delek.heroland.data.database.entities.AdvantageEntity
import com.delek.heroland.data.database.entities.ArmorEntity
import com.delek.heroland.data.database.entities.ChitEntity
import com.delek.heroland.data.database.entities.DwellingEntity
import com.delek.heroland.data.database.entities.NativesEntity
import com.delek.heroland.data.database.entities.PlayerEntity
import com.delek.heroland.data.database.entities.RoleAdvantageEntity
import com.delek.heroland.data.database.entities.RoleArmorEntity
import com.delek.heroland.data.database.entities.RoleChitEntity
import com.delek.heroland.data.database.entities.RoleDwellingEntity
import com.delek.heroland.data.database.entities.RoleEntity
import com.delek.heroland.data.database.entities.RoleNativesEntity
import com.delek.heroland.data.database.entities.RoleWeaponEntity
import com.delek.heroland.data.database.entities.SpellEntity
import com.delek.heroland.data.database.entities.SpellTypeEntity
import com.delek.heroland.data.database.entities.StartSpellEntity
import com.delek.heroland.data.database.entities.VictoryPointsEntity
import com.delek.heroland.data.database.entities.VpRoleEntity
import com.delek.heroland.data.database.entities.WeaponEntity

@Database(
    entities = [
        RoleEntity::class,
        AdvantageEntity::class,
        ChitEntity::class,
        DwellingEntity::class,
        WeaponEntity::class,
        ArmorEntity::class,
        RoleAdvantageEntity::class,
        RoleChitEntity::class,
        RoleDwellingEntity::class,
        RoleWeaponEntity::class,
        RoleArmorEntity::class,
        StartSpellEntity::class,
        NativesEntity::class,
        RoleNativesEntity::class,
        SpellEntity::class,
        SpellTypeEntity::class,
        VictoryPointsEntity::class,
        PlayerEntity::class,
        VpRoleEntity::class],
    version = 1,
    exportSchema = true
)
abstract class HerolandDatabase : RoomDatabase() {
    abstract fun getRoleDao(): RoleDao
    abstract fun getDwellingDao(): DwellingDao
    abstract fun getAdvantageDao(): AdvantageDao
    abstract fun getRoleAdvantageDao(): RoleAdvantageDao
    abstract fun getChitDao(): ChitDao
    abstract fun getRoleChitDao(): RoleChitDao
    abstract fun getRoleDwellingDao(): RoleDwellingDao
    abstract fun getWeaponDao(): WeaponDao
    abstract fun getRoleWeaponDao(): RoleWeaponDao
    abstract fun getArmorDao(): ArmorDao
    abstract fun getRoleArmorDao(): RoleArmorDao
    abstract fun getStartSpellDao(): StartSpellDao
    abstract fun getNativesDao(): NativesDao
    abstract fun getRoleNativesDao(): RoleNativesDao
    abstract fun getSpellDao(): SpellDao
    abstract fun getSpellTypeDao(): SpellTypeDao
    abstract fun getVictoryPointsDao(): VictoryPointsDao
    abstract fun getPlayerDao(): PlayerDao
    abstract fun getVpRoleDao(): VpRoleDao
}
