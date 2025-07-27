package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.SpotProvider
import com.delek.heroland.data.repository.SpotRepository
import com.delek.heroland.domain.model.Spot
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetSpotUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: SpotRepository
) {

    suspend operator fun invoke(): List<Spot> {
        val spots = repository.getAllSpots()
        return if (spots.isEmpty()) {
            repository.insertSpot(SpotProvider.loadSpot(context))
            spots
        } else {
            repository.getAllSpots()
        }
    }

}