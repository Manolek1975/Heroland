package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "role_dwellings",
    foreignKeys = [
        ForeignKey(
            entity = RoleEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("role_id"), onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = DwellingEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("dwelling_id"), onDelete = ForeignKey.CASCADE
        )
    ]
)
class RoleDwellingEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("role_id") val roleId: Int,
    @ColumnInfo("dwelling_id") val dwellingId: Int
)

