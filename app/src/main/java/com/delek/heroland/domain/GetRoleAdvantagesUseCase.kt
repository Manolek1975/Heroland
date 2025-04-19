package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.provider.RoleAdvantageProvider
import com.delek.heroland.data.repository.RoleAdvantageRepository
import com.delek.heroland.domain.model.RoleAdvantage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRoleAdvantagesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RoleAdvantageRepository
) {

    suspend operator fun invoke(): List<RoleAdvantage> {
        val roleAdvantages = repository.getAllRoleAdvantages()
        return if (roleAdvantages.isEmpty()) {
            repository.insertRoleAdvantages(RoleAdvantageProvider.loadRoleAdvantages(context))
            roleAdvantages
        } else {
            repository.getAllRoleAdvantages()
        }
    }

}