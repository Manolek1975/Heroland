package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Role
import com.delek.heroland.data.provider.RoleProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRolesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RoleRepository) {

    suspend operator fun invoke():List<Role>{
        val roles = repository.getAllRoles()
        return if(roles.isEmpty()){
            repository.insertRoles(RoleProvider.loadRoles(context))
            roles
        }else{
            repository.getAllRoles()
        }
    }

}