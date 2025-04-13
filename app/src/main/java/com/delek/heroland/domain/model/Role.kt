package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleEntity


data class Role(
    val id: Int,
    val name: String,
    val symbol: String,
    val icon: String,
    val thumb: String,
    val image: String,
    val detail: String,
    val weight: String,
    val advantages: Int,
    val development: Int,
    val position: Int,
    val spells: Int,
    val relations: Int,
    val dwellings: Int
)

fun RoleEntity.toDomain() = Role(
    id,
    name,
    symbol,
    icon,
    thumb,
    image,
    detail,
    weight,
    advantages,
    development,
    position,
    spells,
    relations,
    dwellings
)
