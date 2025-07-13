package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.AdviceChitEntity

@Dao
interface AdviceChitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdviceChit(advices: List<AdviceChitEntity>)

    @Query("SELECT * FROM advice_chits")
    suspend fun getAllAdviceChits(): List<AdviceChitEntity>
}