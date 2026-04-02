package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.ClearingProvider
import com.delek.heroland.data.repository.ClearingRepository
import com.delek.heroland.domain.model.Clearing
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetClearingUseCase @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val repository: ClearingRepository) {

    suspend operator fun invoke(): List<Clearing> {
        val clearings = repository.getAllClearings()
        return if (clearings.isEmpty()) {
            repository.insertClearing(ClearingProvider.loadClearings(context))
            clearings
        } else {
            repository.getAllClearings()
        }
    }
}