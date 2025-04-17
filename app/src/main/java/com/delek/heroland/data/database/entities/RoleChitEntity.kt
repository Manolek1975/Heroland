package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.delek.heroland.domain.model.RoleChit

@Entity(
    tableName = "role_chits",
    foreignKeys = [
        ForeignKey(
            entity = RoleEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("role_id"), onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ChitEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("chit_id"), onDelete = ForeignKey.CASCADE
        )
    ]
)
class RoleChitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("role_id") val roleId: Int,
    @ColumnInfo("chit_id") val chitId: Int
)

fun RoleChit.toDatabase() = RoleChitEntity(
    id,
    roleId,
    chitId
)

