package com.delek.heroland.domain.provider

import com.delek.heroland.data.database.entities.AdvantageEntity

class AdvantageProvider {

    companion object{
        val advantage = listOf(
            AdvantageEntity(1, "AIM", "Subtracts one from each die roll whenever " +
                    "she rolls on the Missile Table to attack with a missile weapon."),
            AdvantageEntity(2, "STAMINA", "The Amazon can record and do an extra Move phase\n" +
                    "each turn. She gets this bonus even when she is riding a horse - her\n" +
                    "stamina includes being an excellent horsewoman.")
        )
    }
}