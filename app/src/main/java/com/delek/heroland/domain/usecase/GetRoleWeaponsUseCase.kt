package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.RoleWeaponProvider
import com.delek.heroland.data.repository.RoleWeaponRepository
import com.delek.heroland.domain.model.RoleWeapon
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRoleWeaponsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RoleWeaponRepository) {

    suspend operator fun invoke():List<RoleWeapon>{
        val roleWeapons = repository.getAllRoleWeapons()
        return if (roleWeapons.isEmpty()) {
            repository.insertRoleWeapons(RoleWeaponProvider.loadRoleWeapons(context))
            roleWeapons
        } else {
            repository.getAllRoleWeapons()
        }
    }
}