package com.delek.heroland.domain.model

import com.delek.heroland.data.database.entities.RoleEntity


class RoleProvider {

    companion object {
        val roles = listOf(
            RoleEntity(
                1, "Amazon", "", "", "", "img_amazon", "",
                "Medium", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                2, "Berserker", "", "", "", "img_berserker", "",
                "Heavy", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                3, "Black Knight", "", "", "", "img_black_knight", "",
                "Medium", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                4, "Captain", "", "", "", "img_captain", "",
                "Medium", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                5, "Druid", "", "", "", "img_druid", "",
                "Light", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                6, "Dwarf", "", "", "", "img_dwarf", "",
                "Heavy", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                7, "Elf", "", "", "", "img_elf", "",
                "Light", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                8, "Magician", "", "", "", "img_magician", "",
                "Light", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                9, "Pilgrim", "", "", "", "img_pilgrim", "",
                "Medium", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                10, "Sorcerer", "", "", "", "img_sorcerer", "",
                "Medium", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                11, "Swordsman", "", "", "", "img_swordsman", "",
                "Light", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                12, "White Knight", "", "", "", "img_white_knight", "",
                "Heavy", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                13, "Witch", "", "", "", "img_witch", "",
                "Light", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                14, "Witch King", "", "", "", "img_witch_king", "",
                "Light", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                15, "Wizard", "", "", "", "img_wizard", "",
                "Medium", 0, 0, 0, 0, 0, ""
            ),
            RoleEntity(
                16, "Woods girl", "", "", "", "img_woods_girl", "",
                "Light", 0, 0, 0, 0, 0, ""
            )
        )
    }

}