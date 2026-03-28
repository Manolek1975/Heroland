package com.delek.heroland.core


class Phase(private val id: Int): IPhase {


    override fun getPhase(id: Int, dice:Int): Boolean {
        val result = when (id) {
            1 -> phaseHide(dice)
            else -> false
        }
        return result
    }

    private fun phaseHide(dice: Int): Boolean {
        val result = when (dice) {
            6 -> false
            else -> true
        }
        return result
    }

}