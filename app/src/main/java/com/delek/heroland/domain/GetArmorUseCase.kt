package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.provider.ArmorProvider
import com.delek.heroland.data.repository.ArmorRepository
import com.delek.heroland.domain.model.Armor
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetArmorUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: ArmorRepository) {

    suspend operator fun invoke(): List<Armor> {
        val armor = repository.getAllArmor()
        return if (armor.isEmpty()) {
            repository.insertArmor(ArmorProvider.loadArmor(context))
            armor
        } else {
            repository.getAllArmor()
        }
    }

}