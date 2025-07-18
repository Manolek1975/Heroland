package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.SoundChitProvider
import com.delek.heroland.data.repository.SoundChitRepository
import com.delek.heroland.domain.model.SoundChit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetSoundChitUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: SoundChitRepository
) {

    suspend operator fun invoke(): List<SoundChit> {
        val soundChits = repository.getAllSoundChits()
        return if (soundChits.isEmpty()) {
            repository.insertSoundChits(SoundChitProvider.loadAdvices(context))
            soundChits
        } else {
            repository.getAllSoundChits()
        }
    }

}