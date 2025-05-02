package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "roles")
data class RoleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val symbol: String,
    val icon: String,
    val thumb: String,
    val image: String,
    val weight: String,
    val spells: Int,
    val relations: Int,
)



