package com.delek.heroland.ui.settings


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.PlayerRepository
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repoPlayers: PlayerRepository,
    private val repoTiles: TileRepository
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
}