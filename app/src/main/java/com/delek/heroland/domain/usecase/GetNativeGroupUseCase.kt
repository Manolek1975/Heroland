package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.NativesProvider
import com.delek.heroland.data.repository.NativesGroupRepository
import com.delek.heroland.domain.model.NativeGroup
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetNativeGroupUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: NativesGroupRepository) {

    suspend operator fun invoke():List<NativeGroup>{
        val natives = repository.getNatives()
        return if(natives.isEmpty()){
            repository.insertNatives(NativesProvider.loadNatives(context))
            natives
        }else{
            repository.getNatives()
        }
    }
}

