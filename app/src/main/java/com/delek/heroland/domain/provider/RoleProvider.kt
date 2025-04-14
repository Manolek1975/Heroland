package com.delek.heroland.domain.provider

import com.delek.heroland.data.database.entities.RoleEntity


class RoleProvider {

    companion object {
        val roles = listOf(
            RoleEntity(
                1, "Amazon", "SWORD AND SHIELD", "icon_amazon", "", "img_amazon", "",
                "MEDIUM", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                2, "Berserker", "LETOPHORO: Death and Destruction", "icon_berserker", "", "img_berserker", "",
                "HEAVY", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                3, "Black Knight", "MARS: God of War", "icon_black_knight", "", "img_black_knight", "",
                "MEDIUM", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                4, "Captain", "CHEVRON: Military Leadership", "icon_captain", "", "img_captain", "",
                "MEDIUM", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                5, "Druid", "WOOD", "icon_druid", "", "img_druid", "",
                "LIGHT", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                6, "Dwarf", "OPPOSITION", "icon_dwarf", "", "img_dwarf", "",
                "HEAVY", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                7, "Elf", "SEXTILE: Half Human", "icon_elf", "", "img_elf", "",
                "LIGHT", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                8, "Magician", "GINNER: Divine and Demonic", "icon_magician", "", "img_magician", "",
                "LIGHT", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                9, "Pilgrim", "CROZIER: Shepperd Staff", "icon_pilgrim", "", "img_pilgrim", "",
                "MEDIUM", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                10, "Sorcerer", "CONTROLED INTELLECT", "icon_sorcerer", "", "img_sorcerer", "",
                "MEDIUM", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                11, "Swordsman", "WOLF HOOK", "icon_swordsman", "", "img_swordsman", "",
                "LIGHT", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                12, "White Knight", "CROSS POMMEE: Potent Cross", "icon_white_knight", "", "img_white_knight", "",
                "HEAVY", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                13, "Witch", "VITRIOLE: Poison", "icon_witch", "", "img_witch", "",
                "LIGHT", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                14, "Witch King", "CHAOTIC INTELLECT", "icon_witch_king", "", "img_witch_king", "",
                "LIGHT", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                15, "Wizard", "CELESTIAL POWER", "icon_wizard", "", "img_wizard", "",
                "MEDIUM", 0, 0, 0, 0, 0, 1
            ),
            RoleEntity(
                16, "Woods girl", "EROSIA: Love and Earth", "icon_woods_girl", "", "img_woods_girl", "",
                "LIGHT", 0, 0, 0, 0, 0, 1
            )
        )
    }

}