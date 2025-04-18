package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.provider.WeaponProvider
import com.delek.heroland.data.repository.WeaponRepository
import com.delek.heroland.domain.model.Weapon
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetWeaponsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: WeaponRepository
) {

    suspend operator fun invoke():List<Weapon>{
        val weapons = repository.getAllWeapons()
        return if(weapons.isEmpty()){
            repository.insertWeapons(WeaponProvider.loadWeapons(context))
            weapons
        }else{
            repository.getAllWeapons()
        }
    }
}