package com.delek.heroland.ui.dwelling

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.DwellingRepository
import com.delek.heroland.data.repository.GroupRepository
import com.delek.heroland.data.repository.NativeRepository
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Group
import com.delek.heroland.domain.model.Native
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DwellingViewModel @Inject constructor(
    private val dwellingRepo: DwellingRepository,
    private val groupRepo: GroupRepository,
    private val nativeRepo: NativeRepository
) : ViewModel() {

    val dwelling = MutableLiveData<Dwelling>()
    val natives = MutableLiveData<List<Native>>()
    val group = MutableLiveData<List<Group>>()

    fun getDwellingById(id: Int) {
        viewModelScope.launch {
            dwelling.value = dwellingRepo.getDwellingById(id)
        }
    }

    fun getGroupByStart(start: Int) {
        viewModelScope.launch {
            group.value = groupRepo.getGroupByStart(start)
        }
    }

    fun getNatives() {
        viewModelScope.launch {
            natives.value = nativeRepo.getNatives()
        }
    }

    fun getNativesByGroup(groupId: Int) {
        viewModelScope.launch {
            natives.value = nativeRepo.getNativeByGroup(groupId)
        }
    }

}