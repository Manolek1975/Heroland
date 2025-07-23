package com.delek.heroland.ui.nativeDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.NativeRepository
import com.delek.heroland.domain.model.Native
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NativeDetailViewModel @Inject constructor(private var repoNative: NativeRepository) : ViewModel() {

    val native = MutableLiveData<Native>()

    fun getNativeById(id: Int){
        viewModelScope.launch {
            native.value = repoNative.getNativeById(id)
        }
    }

}