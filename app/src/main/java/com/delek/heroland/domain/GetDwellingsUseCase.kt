package com.delek.heroland.domain

import com.delek.heroland.data.repository.DwellingRepository
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.provider.DwellingProvider
import javax.inject.Inject

class GetDwellingsUseCase @Inject constructor(private val repository: DwellingRepository) {

    suspend operator fun invoke():List<Dwelling>{
        val dwellings = repository.getAllDwellings()

        return if(dwellings.isEmpty()){
            repository.insertDwellings(DwellingProvider.dwellings)
            dwellings
        }else{
            repository.getAllDwellings()
        }
    }
}