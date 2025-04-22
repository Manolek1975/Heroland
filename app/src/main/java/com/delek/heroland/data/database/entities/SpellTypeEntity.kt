package com.delek.heroland.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "spell_types", foreignKeys = [
        ForeignKey(
            entity = SpellEntity::class, parentColumns = arrayOf("id"),
            childColumns = arrayOf("spell_id"), onDelete = ForeignKey.CASCADE
        ),
    ]
)
class SpellTypeEntity (
    @PrimaryKey(autoGenerate = true)val id: Int,
    @ColumnInfo("role_id", index = true) val roleId: Int,
    @ColumnInfo("spell_id", index = true) val spellId: Int,
    @ColumnInfo("type") val type: String
)