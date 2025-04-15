package com.delek.heroland.domain

import com.delek.heroland.data.repository.AdvantageRepository
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.domain.provider.AdvantageProvider
import javax.inject.Inject

class GetAdvantagesUseCase @Inject constructor(private val repository: AdvantageRepository) {

    suspend operator fun invoke(): List<Advantage> {
        val advantages = repository.getAllAdvantages()

        return if (advantages.isEmpty()) {
            repository.insertAdvantages(AdvantageProvider.advantage)
            advantages
        } else {
            repository.getAllAdvantages()
        }
    }
}