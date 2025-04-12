package com.delek.heroland.domain

import com.delek.heroland.data.RoleRepository
import com.delek.heroland.data.database.entities.toDatabase
import com.delek.heroland.domain.model.Role
import javax.inject.Inject

class GetRolesUseCase @Inject constructor(private val repository: RoleRepository) {

    suspend operator fun invoke():List<Role>{
        val roles = repository.getAllRoles()

        return if(roles.isNotEmpty()){
            repository.clearRoles()
            repository.insertRoles(roles.map { it.toDatabase() })
            roles
        }else{
            repository.getAllRoles()
        }
    }

}