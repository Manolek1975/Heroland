package com.delek.heroland.domain

import com.delek.heroland.data.repository.RoleAdvantagesRepository
import com.delek.heroland.domain.model.RoleAdvantages
import com.delek.heroland.domain.provider.RoleAdvantagesProvider
import javax.inject.Inject

class GetRoleAdvantagesUseCase @Inject constructor(private val repository: RoleAdvantagesRepository) {

    suspend operator fun invoke(): List<RoleAdvantages> {
        val roleAdvantages = repository.getAllRoleAdvantages()

        return if (roleAdvantages.isEmpty()) {
            repository.insertRoleAdvantages(RoleAdvantagesProvider.roleAdvantages)
            roleAdvantages
        } else {
            repository.getAllRoleAdvantages()
        }
    }

}