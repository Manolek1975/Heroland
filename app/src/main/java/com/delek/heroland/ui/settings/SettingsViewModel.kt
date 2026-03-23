package com.delek.heroland.ui.settings


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.DayPhaseRepository
import com.delek.heroland.data.repository.PlayerRepository
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repoPlayers: PlayerRepository,
    private val repoTiles: TileRepository,
    private val repoDayPhase: DayPhaseRepository
) : ViewModel() {

    val roles = MutableLiveData<List<Role>>()

    fun deletePlayers() {
        viewModelScope.launch {
            repoPlayers.deleteAllPlayers()
        }
    }

    fun deleteTiles() {
        viewModelScope.launch {
            repoTiles.deleteAllTiles()
        }
    }

    fun deletePrimaryKeyIndex() {
        viewModelScope.launch {
            repoTiles.deletePrimaryKeyIndex()
        }
    }

    fun deleteDayPhases() {
        viewModelScope.launch {
            repoDayPhase.deleteDayPhases()
        }
    }
}


