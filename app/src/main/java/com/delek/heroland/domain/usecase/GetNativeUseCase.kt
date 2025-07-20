package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.NativeProvider
import com.delek.heroland.data.repository.NativeRepository
import com.delek.heroland.domain.model.Native
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetNativeUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: NativeRepository
) {

    suspend operator fun invoke():List<Native>{
        val natives = repository.getNatives()
        return if(natives.isEmpty()){
            repository.insertNatives(NativeProvider.loadNatives(context))
            natives
        }else{
            repository.getNatives()
        }
    }
}