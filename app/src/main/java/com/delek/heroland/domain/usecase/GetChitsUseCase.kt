package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.ChitProvider
import com.delek.heroland.data.repository.ChitRepository
import com.delek.heroland.domain.model.Chit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetChitsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: ChitRepository) {

    suspend operator fun invoke(): List<Chit> {
        val chits = repository.getAllChits()
        return if (chits.isEmpty()) {
            repository.insertChits(ChitProvider.loadChits(context))
            chits
        } else {
            repository.getAllChits()
        }
    }
}