package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.VictoryPointsProvider
import com.delek.heroland.data.repository.VictoryPointsRepository
import com.delek.heroland.domain.model.VictoryPoints
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetVictoryPointsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: VictoryPointsRepository
) {

    suspend operator fun invoke(): List<VictoryPoints> {
        val vp = repository.getVictoryPoints()
        return if (vp.isEmpty()) {
            repository.insertVictoryPoints(VictoryPointsProvider.loadVictoryPoints(context))
            vp
        } else {
            repository.getVictoryPoints()
        }
    }
}