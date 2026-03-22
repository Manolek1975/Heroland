package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.PhaseProvider
import com.delek.heroland.data.repository.PhaseRepository
import com.delek.heroland.domain.model.Phase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetPhasesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: PhaseRepository
) {

    suspend operator fun invoke():List<Phase>{
        val phase = repository.getPhases()
        return if(phase.isEmpty()){
            repository.insertPhases(PhaseProvider.loadPhases(context))
            phase
        }else{
            repository.getPhases()
        }
    }
}