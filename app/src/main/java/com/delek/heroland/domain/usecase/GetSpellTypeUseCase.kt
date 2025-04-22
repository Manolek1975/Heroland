package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.SpellTypeProvider
import com.delek.heroland.data.repository.SpellTypeRepository
import com.delek.heroland.domain.model.SpellType
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetSpellTypeUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: SpellTypeRepository) {

    suspend operator fun invoke(): List<SpellType> {
        val spellType = repository.getAllSpellTypes()
        return if (spellType.isEmpty()) {
            repository.insertSpellTypes(SpellTypeProvider.loadSpellTypes(context))
            spellType
        } else {
            repository.getAllSpellTypes()
        }
    }


}