package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.SpellProvider
import com.delek.heroland.data.repository.SpellRepository
import com.delek.heroland.domain.model.Spell
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetSpellUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: SpellRepository) {

    suspend operator fun invoke(): List<Spell> {
        val spells = repository.getAllSpells()
        return if(spells.isEmpty()) {
            repository.insertSpells(SpellProvider.loadSpells(context))
            spells
        } else {
            repository.getAllSpells()
        }
    }
}