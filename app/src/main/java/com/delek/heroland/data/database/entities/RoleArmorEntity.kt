package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "role_armor")
data class RoleArmorEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("role_id") val roleId: Int,
    @ColumnInfo("armor_id") val armorId: Int,
)