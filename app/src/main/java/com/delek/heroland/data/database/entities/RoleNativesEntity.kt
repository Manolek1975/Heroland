package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "role_natives", foreignKeys = [
    ForeignKey(
        entity = RoleEntity::class, parentColumns = arrayOf("id"),
        childColumns = arrayOf("role_id"), onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
        entity = NativesEntity::class, parentColumns = arrayOf("id"),
        childColumns = arrayOf("native_id"), onDelete = ForeignKey.CASCADE
    )
]
)
data class RoleNativesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("role_id", index = true) val roleId: Int,
    @ColumnInfo("native_id", index = true) val nativeId: Int,
    @ColumnInfo("relation") val relation: Int
)