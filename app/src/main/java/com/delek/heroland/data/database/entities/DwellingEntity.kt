package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.delek.heroland.domain.model.Dwelling

/*@Entity(
    tableName = "dwellings", foreignKeys = [
        ForeignKey(entity = RoleEntity::class, parentColumns = ["id"], childColumns = ["role_id"])
    ]
)*/
@Entity(tableName = "dwellings")
data class DwellingEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "tile") val tile: Int,
    @ColumnInfo(name = "clearing") val clearing: Int
)

fun Dwelling.toDatabase() = DwellingEntity(
    id,
    name,
    image,
    tile,
    clearing
)
