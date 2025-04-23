package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "start_spells", foreignKeys = [
        ForeignKey(
            entity = RoleEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("role_id"), onDelete = ForeignKey.CASCADE
        )]
)
data class StartSpellEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("role_id", index = true) val roleId: Int,
    @ColumnInfo("type_id") val typeId: Int,
    @ColumnInfo("spell_type") val spellType: String
)