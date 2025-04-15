package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.delek.heroland.domain.model.Role


@Entity(tableName = "roles")
data class RoleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("symbol") val symbol: String,
    @ColumnInfo("icon") val icon: String,
    @ColumnInfo("thumb") val thumb: String,
    @ColumnInfo("image") val image: String,
    @ColumnInfo("weight") val weight: String,
    @ColumnInfo("advantages") val advantages: Int,
    @ColumnInfo("development") val development: Int,
    @ColumnInfo("dwellings") val dwellings: Int,
    @ColumnInfo("spells") val spells: Int,
    @ColumnInfo("relations") val relations: Int,
)

fun Role.toDatabase() = RoleEntity(
    id,
    name,
    symbol,
    icon,
    thumb,
    image,
    weight,
    advantages,
    development,
    dwellings,
    spells,
    relations
)


