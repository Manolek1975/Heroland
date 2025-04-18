package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.provider.RoleDwellingProvider
import com.delek.heroland.data.repository.RoleDwellingRepository
import com.delek.heroland.domain.model.RoleDwelling
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRoleDwellingsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RoleDwellingRepository
) {

suspend operator fun invoke(): List<RoleDwelling> {
    val roleDwellings = repository.getAllRoleDwellings()
    return if (roleDwellings.isEmpty()) {
        repository.insertRoleDwellings(RoleDwellingProvider.loadRoleDwellings(context))
        roleDwellings
    } else {
        repository.getAllRoleDwellings()
    }
}
}