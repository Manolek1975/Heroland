package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.AdviceChitEntity

data class AdviceChit(
    val id: Int,
    val name: String,
    val type: String,
    val num: Int,
    val image: String
)

fun AdviceChitEntity.toDomain() = AdviceChit(id, name, type, num, image)
