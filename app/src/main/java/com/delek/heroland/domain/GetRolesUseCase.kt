package com.delek.heroland.domain

import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.provider.RoleProvider
import javax.inject.Inject

class GetRolesUseCase @Inject constructor(private val repository: RoleRepository) {

    suspend operator fun invoke():List<Role>{
        val roles = repository.getAllRoles()

        return if(roles.isEmpty()){
            repository.insertRoles(RoleProvider.roles)
            roles
        }else{
            repository.getAllRoles()
        }
    }

}