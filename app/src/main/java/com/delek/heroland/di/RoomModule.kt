package com.delek.heroland.di

import android.content.Context
import androidx.room.Room
import com.delek.heroland.data.database.RoleDatabase
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
        Room.databaseBuilder(context, RoleDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideRoleDao(db: RoleDatabase) = db.getRoleDao()

}