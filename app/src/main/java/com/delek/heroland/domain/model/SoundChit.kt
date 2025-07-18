package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.SoundChitEntity

data class SoundChit(
    val id: Int,
    val name: String,
    val type: String,
    val num: Int,
    val treasure: Int,
    val monster: Int
)

fun SoundChitEntity.toDomain() = SoundChit(id, name, type, num, treasure, monster)
