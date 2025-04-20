package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.provider.NativesProvider
import com.delek.heroland.data.repository.NativesRepository
import com.delek.heroland.domain.model.Natives
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetNativesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: NativesRepository) {

    suspend operator fun invoke():List<Natives>{
        val natives = repository.getNatives()
        return if(natives.isEmpty()){
            repository.insertNatives(NativesProvider.loadNatives(context))
            natives
        }else{
            repository.getNatives()
        }
    }
}

