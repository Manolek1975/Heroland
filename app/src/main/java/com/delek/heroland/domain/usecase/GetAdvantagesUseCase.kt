package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.repository.AdvantageRepository
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.data.provider.AdvantageProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetAdvantagesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: AdvantageRepository) {

    suspend operator fun invoke(): List<Advantage> {
        val advantages = repository.getAllAdvantages()
        return if (advantages.isEmpty()) {
            repository.insertAdvantages(AdvantageProvider.loadAdvantages(context))
            advantages
        } else {
            repository.getAllAdvantages()
        }
    }
}