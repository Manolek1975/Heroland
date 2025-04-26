package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "role_advantages", primaryKeys = ["role_id", "advantage_id"],
    foreignKeys = [
        ForeignKey(
            entity = RoleEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("role_id"), onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AdvantageEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("advantage_id"), onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RoleAdvantageEntity(
    @ColumnInfo(name = "role_id", index = true) val roleId: Int,
    @ColumnInfo(name = "advantage_id", index = true) val advantageId: Int
)

