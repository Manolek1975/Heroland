package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.delek.heroland.domain.model.Role


@Entity(tableName = "roles")
data class RoleEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "symbol") val symbol: String,
    @ColumnInfo(name = "icon") val icon: String,
    @ColumnInfo(name = "thumb") val thumb: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "detail") val detail: String,
    @ColumnInfo(name = "weight") val weight: String,
    @ColumnInfo(name = "advantages") val advantages: Int,
    @ColumnInfo(name = "development") val development: Int,
    @ColumnInfo(name = "position") val position: Int,
    @ColumnInfo(name = "spells") val spells: Int,
    @ColumnInfo(name = "relations") val relations: Int,
    @ColumnInfo(name = "difficulty") val difficulty: String
)

fun Role.toDatabase() = RoleEntity(
    id,
    name,
    symbol,
    icon,
    thumb,
    image,
    detail,
    weight,
    advantages,
    development,
    position,
    spells,
    relations,
    difficulty
)


