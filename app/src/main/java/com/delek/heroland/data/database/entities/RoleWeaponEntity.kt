package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "role_weapons",
    foreignKeys = [
        ForeignKey(
            entity = RoleEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("role_id"), onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WeaponEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("weapon_id"), onDelete = ForeignKey.CASCADE
        )
    ]
)
class RoleWeaponEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("role_id", index = true) val roleId: Int,
    @ColumnInfo("weapon_id", index = true) val weaponId: Int
)