package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.AdviceChitEntity

data class AdviceChit(
    val id: Int,
    val name: String,
    val type: String,
    val dice: Int,
    val dwelling: Int,
    val monster: Int,
    val native: Int
)

fun AdviceChitEntity.toDomain() = AdviceChit(id, name, type, dice, dwelling, monster, native)
