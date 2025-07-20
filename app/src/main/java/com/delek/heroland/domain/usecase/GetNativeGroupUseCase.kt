package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.NativeGroupProvider
import com.delek.heroland.data.repository.NativeGroupRepository
import com.delek.heroland.domain.model.NativeGroup
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetNativeGroupUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: NativeGroupRepository) {

    suspend operator fun invoke():List<NativeGroup>{
        val natives = repository.getNatives()
        return if(natives.isEmpty()){
            repository.insertNatives(NativeGroupProvider.loadNativeGroup(context))
            natives
        }else{
            repository.getNatives()
        }
    }
}

