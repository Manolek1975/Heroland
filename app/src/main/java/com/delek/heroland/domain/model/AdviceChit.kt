package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.AdviceChitEntity

data class AdviceChit(
    val id: Int,
    val name: String,
    val type: String,
    val dwelling: Int,
    val monster: Int
)

fun AdviceChitEntity.toDomain() = AdviceChit(id, name, type, dwelling, monster)
