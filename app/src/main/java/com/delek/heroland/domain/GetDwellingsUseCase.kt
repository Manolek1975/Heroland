package com.delek.heroland.domain

import com.delek.heroland.data.DwellingRepository
import com.delek.heroland.data.database.entities.toDatabase
import com.delek.heroland.domain.model.Dwelling
import javax.inject.Inject

class GetDwellingsUseCase @Inject constructor(private val repository: DwellingRepository) {

    suspend operator fun invoke():List<Dwelling>{
        val dwellings = repository.getAllDwellings()

        return if(dwellings.isNotEmpty()){
            repository.clearDwellings()
            repository.insertDwellings(dwellings.map { it.toDatabase() })
            dwellings
        }else{
            repository.getAllDwellings()
        }
    }
}