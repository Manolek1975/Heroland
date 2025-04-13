package com.delek.heroland.domain.provider

import com.delek.heroland.data.database.entities.DwellingEntity


class DwellingProvider {

    companion object {
        val dwellings = listOf(
            DwellingEntity(
                1, "Inn", "d_inn", 0, 0
            ),
            DwellingEntity(
                2, "House", "d_house", 0, 0
            ),
            DwellingEntity(
                3, "Guard", "d_guard", 0, 0
                ),
            DwellingEntity(
                4, "chapel", "d_chapel", 0, 0
            ),
            DwellingEntity(
                5, "campfire_l", "d_campfire_l", 0, 0
            ),
            DwellingEntity(
                6, "campfire_s", "d_campfire_s", 0, 0
            )
        )
    }
}
