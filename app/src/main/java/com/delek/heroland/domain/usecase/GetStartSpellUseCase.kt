package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.StartSpellProvider
import com.delek.heroland.data.repository.StartSpellRepository
import com.delek.heroland.domain.model.StartSpell
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetStartSpellUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: StartSpellRepository) {

    suspend operator fun invoke(): List<StartSpell> {
        val startSpell = repository.getAllStartSpells()
        return if (startSpell.isEmpty()) {
            repository.insertStartSpell(StartSpellProvider.loadStartSpells(context))
            startSpell
        } else {
            repository.getAllStartSpells()
        }
    }

}