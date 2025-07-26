package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.MonsterProvider
import com.delek.heroland.data.repository.MonsterRepository
import com.delek.heroland.domain.model.Monster
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetMonsterUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: MonsterRepository) {

    suspend operator fun invoke(): List<Monster> {
        val monster = repository.getAllMonsters()
        return if (monster.isEmpty()) {
            repository.insertMonsters(MonsterProvider.loadMonsters(context))
            monster
        } else {
            repository.getAllMonsters()
        }
    }
}