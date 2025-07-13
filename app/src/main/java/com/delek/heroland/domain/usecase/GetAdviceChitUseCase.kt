package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.AdviceChitProvider
import com.delek.heroland.data.repository.AdviceChitRepository
import com.delek.heroland.domain.model.AdviceChit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetAdviceChitUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: AdviceChitRepository) {

    suspend operator fun invoke(): List<AdviceChit> {
        val adviceChits = repository.getAllAdviceChits()
        return if (adviceChits.isEmpty()) {
            repository.insertAdviceChits(AdviceChitProvider.loadAdvices(context))
            adviceChits
        } else {
            repository.getAllAdviceChits()
        }
    }

}