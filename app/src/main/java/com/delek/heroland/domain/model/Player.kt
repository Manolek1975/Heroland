package com.delek.heroland.domain.model

data class Player(
    val id: Int,
    val name: String,
    val role: String,
    val location: Int,
    val spells: Int,
    val vp: Int,
    val weapon: Int,
    val armor: Int,
    val inventory: List<Int>

)