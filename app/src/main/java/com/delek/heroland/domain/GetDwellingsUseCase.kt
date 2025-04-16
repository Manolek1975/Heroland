package com.delek.heroland.domain

import android.content.Context
import com.delek.heroland.data.repository.DwellingRepository
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.data.provider.DwellingProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetDwellingsUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: DwellingRepository) {

    suspend operator fun invoke():List<Dwelling>{
        val dwellings = repository.getAllDwellings()

        return if(dwellings.isEmpty()){
            repository.insertDwellings(DwellingProvider.loadDwellings(context))
            dwellings
        }else{
            repository.getAllDwellings()
        }
    }
}