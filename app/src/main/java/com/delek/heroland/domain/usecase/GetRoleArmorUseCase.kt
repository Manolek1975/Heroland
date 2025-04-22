package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.RoleArmorProvider
import com.delek.heroland.data.repository.RoleArmorRepository
import com.delek.heroland.domain.model.RoleArmor
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetRoleArmorUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: RoleArmorRepository) {

    suspend operator fun invoke(): List<RoleArmor> {
        val roleArmor = repository.getAllRoleArmor()
        return if (roleArmor.isEmpty()) {
            repository.insertRoleArmor(RoleArmorProvider.loadRoleArmor(context))
            roleArmor
        } else {
            repository.getAllRoleArmor()
        }

    }


}