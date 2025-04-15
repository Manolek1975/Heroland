package com.delek.heroland.domain.provider

import com.delek.heroland.data.database.entities.AdvantageEntity

class AdvantageProvider {

    companion object {
        val advantage = listOf(
            AdvantageEntity(
                1, "AIM", "Subtracts one from each die roll whenever " +
                        "she rolls on the Missile Table to attack with a missile weapon."
            ),
            AdvantageEntity(
                2, "STAMINA", "The Amazon can record and do an extra Move phase " +
                        "each turn. She gets this bonus even when she is riding a horse - her " +
                        "stamina includes being an excellent horsewoman."
            ),
            AdvantageEntity(
                3, "ROBUST", "The Berserker can record and do an extra Rest phase " +
                        "each day."
            ),
            AdvantageEntity(
                4, "BERSERK", "The Berserker can play his Berserk chit to increase " +
                        "his vulnerability to Tremendous for the rest of the day. Once he plays " +
                        "it, it takes Tremendous harm to kill him. At Midnight he reverts to " +
                        "normal."
            ),
            AdvantageEntity(
                5, "FEAR", "Whenever the Black Knight rolls on the Meeting Table he " +
                        "rolls one die instead of two. His deadly reputation makes it easier for " +
                        "him to trade and hire natives, and it makes his enemies think twice " +
                        "before blocking or battling him."
            ),
            AdvantageEntity(
                6, "REPUTATION", "The Captain can record and do an extra phase " +
                        "each day he is at a Dwelling (including a campfire). He must be at the " +
                        "Dwelling when he starts to do the phase, not when he records it. He " +
                        "can use the extra phase to do any normal activity."
            ),
            AdvantageEntity(
                7, "CONCEALMENT", "The Druid rolls one die instead of two each " +
                        "time he makes a Hide die roll."
            ),
            AdvantageEntity(
                8, "PEACE WITH NATURE", "When the Druid ends his turn, the " +
                        "Warning and Sound chits in his tile do not summon monsters. " +
                        "Individuals following the Druid will summon monsters normally."
            ),
            AdvantageEntity(
                9, "SHORT LEGS", "TThe Dwarf can never use sunlight phases, you rest an extra " +
                        "effort asterisk per rest phase, and you can play the DUCK chit to Duck."
            ),
            AdvantageEntity(
                10, "CAVE KNOWLEDGE", "The Dwarf rolls one die instead of two " +
                        "whenever he uses the Hide table, the Meeting Table, or any Search " +
                        "table when he is in a cave clearing. This gives him some powerful " +
                        "advantages in the caves, somewhat offsetting his short legs. " +
                        "Obviously, the Dwarf prefers to spend as much time as possible in " +
                        "the caves."
            ),
            AdvantageEntity(
                11, "ELUSIVENESS", "The Elf can record and do an extra Hide phase " +
                        "each day."
            ),
            AdvantageEntity(
                12, "ARCHER", "Rolls one die Instead of two whenever he rolls " +
                        "on the Missile Table to make an attack with a bow or crossbow."
            ),
            AdvantageEntity(
                13, "MAGICAL PARAPHERNALIA", "The Magician can record and do " +
                        "an extra Alert phase each day. This reflects the effects of the magical " +
                        "implements he is carrying; the phase is best used to alert Magic chits."
            ),
            AdvantageEntity(
                14, "KNOWLEDGE", "Subtracts one from each die he " +
                        "rolls when he uses the Reading Runes table."
            ),
            AdvantageEntity(
                15, "HEAVENLY PROTECTION", "The Demon, Winged Demon and Imp " +
                        "cannot block the Pilgrim and they cannot be assigned to attack him: " +
                        "he cannot lure them into attacking, and they cannot be assigned to " +
                        "him randomly. He can block and attack them normally. His hirelings " +
                        "are not protected and can lure and be assigned Demons and Imps."
            ),
            AdvantageEntity(
                16, "LEARNING", "The Pilgrim rolls one die instead of two each time he " +
                        "uses the Reading Runes table."
            ),
            AdvantageEntity(
                17,
                "LORE",
                "Rolls one die instead of two each time he rolls on the Reading Runes table."
            ),
            AdvantageEntity(
                18, "AURA OF POWER", "Can record and do an extra Enchant phase each turn."
            ),
            AdvantageEntity(
                19, "BARTER", "The Swordsman rolls one die instead of two whenever " +
                        "he uses the Meeting Table during a Trade activity. Note: He gets this " +
                        "advantage only during the Trade activity. He does not get it during the " +
                        "Hire activity or when he rolls for battling natives."
            ),
            AdvantageEntity(
                20, "CLEVER", "Instead of taking his turn when his Attention chit is " +
                        "picked, the Swordsman chooses when he will take his turn."
            ),
            AdvantageEntity(
                21, "HEALTH", "The White Knight can record and do an extra Rest " +
                        "phase each day."
            ),
            AdvantageEntity(
                22, "HONOR", "The White Knight subtracts one from each die he rolls " +
                        "whenever he rolls on the Meeting Table; this includes all rolls he " +
                        "makes during trading, hiring and rolling to see if the natives will battle " +
                        "him. His noble accomplishments and reputation make even his " +
                        "enemies less likely to attack him, and all of the native groups are " +
                        "likely to give him a little price break when he deals with them."
            ),
            AdvantageEntity(
                23, "FAMILIAR", "The Witch has an invisible companion that can move " +
                        "around the map separately and discover things for her."
            ),
            AdvantageEntity(
                24, "DISEMBODIED", "The Witch King must use Magic Sight."
            ),
            AdvantageEntity(
                25, "EXPERIENCE", "The Wizard knows the location of every hidden " +
                        "path and secret passage in the Magic Realm. At the start of the game " +
                        "he crosses all of the hidden paths and secret passages off of his " +
                        "Discoveries list. He can use them all."
            ),
            AdvantageEntity(
                26, "TRACKING SKILLS", "The Woods Girl rolls one die instead of two " +
                        "whenever she uses the Hide table, the Meeting table or any Search " +
                        "table while she is in one of the six tiles labeled “Woods” (specifically, " +
                        "the Deep Woods, Linden Woods, Maple Woods, Nut Woods, Oak " +
                        "Woods and Pine Woods). She does not get this advantage in other " +
                        "tiles, even when she is in woods clearings in those tiles."
            ),
        )
    }
}