package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.provider.RoleNativesProvider
import com.delek.heroland.data.repository.RoleNativesRepository
import com.delek.heroland.domain.model.RoleNatives
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRoleNativesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RoleNativesRepository) {

    suspend operator fun invoke(): List<RoleNatives> {
        val roleNatives = repository.getAllRoleNatives()
        return if (roleNatives.isEmpty()) {
            repository.insertRoleNatives(RoleNativesProvider.loadRoleNatives(context))
            roleNatives
        } else {
            repository.getAllRoleNatives()
        }
    }

}