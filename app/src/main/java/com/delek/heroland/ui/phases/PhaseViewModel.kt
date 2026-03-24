package com.delek.heroland.ui.phases

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.DayPhaseRepository
import com.delek.heroland.domain.model.DayPhase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhaseViewModel @Inject constructor(
    private val dayPhaseRepository: DayPhaseRepository
): ViewModel() {

    val dayPhases = MutableLiveData<List<DayPhase>>()

    fun getPhasesByDay(day: Int) {
        viewModelScope.launch {
            dayPhases.value = dayPhaseRepository.getPhasesByDay(day)
        }
    }
}