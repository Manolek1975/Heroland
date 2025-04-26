package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "vp_role", foreignKeys = [
        ForeignKey(entity = RoleEntity::class, parentColumns = ["id"], childColumns = ["role_id"])
    ]
)
data class VpRoleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "role_id", index = true) val roleId: Int,
    @ColumnInfo(name = "vp_treasure") val vpTreasure: Int,
    @ColumnInfo(name = "vp_spell") val vpSpell: Int,
    @ColumnInfo(name = "vp_fame") val vpFame: Int,
    @ColumnInfo(name = "vp_notoriety") val vpNotoriety: Int,
    @ColumnInfo(name = "vp_gold") val vpGold: Int
)