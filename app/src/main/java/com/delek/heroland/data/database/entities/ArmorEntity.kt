package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "armor")
data class ArmorEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("name")val name: String,
    @ColumnInfo("image")val image: String,
    @ColumnInfo("defense")val defense: String,
    @ColumnInfo("price")val price: Int,
    @ColumnInfo("price_damaged")val priceDamaged: Int

)