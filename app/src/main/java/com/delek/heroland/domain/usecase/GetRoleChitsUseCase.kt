package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.RoleChitProvider
import com.delek.heroland.data.repository.RoleChitRepository
import com.delek.heroland.domain.model.RoleChit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRoleChitsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RoleChitRepository) {

    suspend operator fun invoke(): List<RoleChit> {
        val roleChits = repository.getAllRoleChits()
        return if (roleChits.isEmpty()) {
            repository.insertRoleChits(RoleChitProvider.loadRoleChits(context))
            roleChits
        } else {
            repository.getAllRoleChits()
        }
    }
}