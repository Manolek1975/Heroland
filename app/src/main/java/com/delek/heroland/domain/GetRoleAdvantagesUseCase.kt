package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.repository.RoleAdvantagesRepository
import com.delek.heroland.domain.model.RoleAdvantages
import com.delek.heroland.data.provider.RoleAdvantagesProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRoleAdvantagesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RoleAdvantagesRepository) {

    suspend operator fun invoke(): List<RoleAdvantages> {
        val roleAdvantages = repository.getAllRoleAdvantages()

        return if (roleAdvantages.isEmpty()) {
            repository.insertRoleAdvantages(RoleAdvantagesProvider.loadRoleAdvantages(context))
            roleAdvantages
        } else {
            repository.getAllRoleAdvantages()
        }
    }

}