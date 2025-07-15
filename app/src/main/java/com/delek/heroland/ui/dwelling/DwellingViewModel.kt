package com.delek.heroland.ui.dwelling

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.DwellingRepository
import com.delek.heroland.domain.model.Dwelling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DwellingViewModel @Inject constructor(
    private val repository: DwellingRepository
) : ViewModel() {

    val dwelling = MutableLiveData<Dwelling>()

    fun getDwellingById(id: Int) {
        viewModelScope.launch {
            dwelling.value = repository.getDwellingById(id)
        }
    }
}