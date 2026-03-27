package com.delek.heroland.core


class Phase(private var phase: Int): IPhase {


    override fun getPhase(id: Int): Boolean {
        if (id == 1) {
            val phase = "HIDE"
        }
        return false
    }

}