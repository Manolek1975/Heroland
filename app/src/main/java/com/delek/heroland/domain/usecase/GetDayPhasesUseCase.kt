package com.delek.heroland.domain.usecase

import com.delek.heroland.data.repository.DayPhaseRepository
import com.delek.heroland.domain.model.DayPhase
import javax.inject.Inject


class GetDayPhasesUseCase @Inject constructor(
    private val repository: DayPhaseRepository
) {

    operator fun invoke(): List<DayPhase> {
        return repository.getAllDayPhases()
    }
}