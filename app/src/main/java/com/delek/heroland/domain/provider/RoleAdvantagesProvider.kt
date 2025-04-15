package com.delek.heroland.domain.provider

import com.delek.heroland.data.database.entities.RoleAdvantagesEntity


class RoleAdvantagesProvider {

    companion object{
        val roleAdvantages = listOf(
            RoleAdvantagesEntity(1, 1),
            RoleAdvantagesEntity(1, 2)
        )

    }
}