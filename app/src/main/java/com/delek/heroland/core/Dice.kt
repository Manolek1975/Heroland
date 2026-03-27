package com.delek.heroland.core

import com.delek.heroland.R.drawable

class Dice() {

    val wDice = (1..6).random()
    val rDice = (1..6).random()

    fun rollDice(): Int {
        val result = maxOf(wDice, rDice)
        return result
    }

    fun rollImages(): Pair<Int, Int> {
        val idW = getWhiteDice(wDice)
        val idR = getRedDice(rDice)
        return idW to idR
    }

    fun getWhiteDice(wDie: Int): Int {
        val idW = when (wDie) {
            1 -> drawable.dice_1w
            2 -> drawable.dice_2w
            3 -> drawable.dice_3w
            4 -> drawable.dice_4w
            5 -> drawable.dice_5w
            else -> drawable.dice_6w
        }
        return idW
    }

    fun getRedDice(rDie: Int): Int {
        val idR = when (rDie) {
            1 -> drawable.dice_1r
            2 -> drawable.dice_2r
            3 -> drawable.dice_3r
            4 -> drawable.dice_4r
            5 -> drawable.dice_5r
            else -> drawable.dice_6r
        }
        return idR
    }
}