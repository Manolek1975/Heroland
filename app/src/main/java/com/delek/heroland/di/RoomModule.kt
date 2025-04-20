package com.delek.heroland.di

import android.content.Context
import androidx.room.Room
import com.delek.heroland.data.database.HerolandDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "heroland_db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, HerolandDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideRoleDao(db: HerolandDatabase) = db.getRoleDao()

    @Singleton
    @Provides
    fun provideDwellingDao(db: HerolandDatabase) = db.getDwellingDao()

    @Singleton
    @Provides
    fun provideAdvantageDao(db: HerolandDatabase) = db.getAdvantageDao()

    @Singleton
    @Provides
    fun provideRoleAdvantageDao(db: HerolandDatabase) = db.getRoleAdvantageDao()

    @Singleton
    @Provides
    fun provideChitDao(db: HerolandDatabase) = db.getChitDao()

    @Singleton
    @Provides
    fun provideRoleChitDao(db: HerolandDatabase) = db.getRoleChitDao()

    @Singleton
    @Provides
    fun provideRoleDwellingDao(db: HerolandDatabase) = db.getRoleDwellingDao()

    @Singleton
    @Provides
    fun provideWeaponDao(db: HerolandDatabase) = db.getWeaponDao()

    @Singleton
    @Provides
    fun provideRoleWeaponDao(db: HerolandDatabase) = db.getRoleWeaponDao()

    @Singleton
    @Provides
    fun provideArmorDao(db: HerolandDatabase) = db.getArmorDao()

    @Singleton
    @Provides
    fun provideRoleArmorDao(db: HerolandDatabase) = db.getRoleArmorDao()

    @Singleton
    @Provides
    fun provideStartSpellDao(db: HerolandDatabase) = db.getStartSpellDao()

    @Singleton
    @Provides
    fun provideNativesDao(db: HerolandDatabase) = db.getNativesDao()

    @Singleton
    @Provides
    fun provideRoleNativesDao(db: HerolandDatabase) = db.getRoleNativesDao()

}