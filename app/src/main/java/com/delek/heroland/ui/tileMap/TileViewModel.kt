package com.delek.heroland.ui.tileMap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.AdviceChitRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.data.repository.SoundChitRepository
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.AdviceChit
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.SoundChit
import com.delek.heroland.domain.model.Tile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TileViewModel @Inject constructor(
    private val roleRepository: RoleRepository,
    private val tileRepository: TileRepository,
    private val adviceRepository: AdviceChitRepository,
    private val soundRepository: SoundChitRepository
) : ViewModel() {
    val role = MutableLiveData<Role>()
    val tile = MutableLiveData<Tile>()
    val advice = MutableLiveData<AdviceChit>()
    val sound = MutableLiveData<SoundChit>()

    fun getRoleById(id: Int) {
        viewModelScope.launch {
            role.value = roleRepository.getRoleById(id)
        }
    }

    fun getTileById(id: Int) {
        viewModelScope.launch {
            tile.value = tileRepository.getTileById(id)
        }
    }

    fun getAdviceChitById(id: Int) {
        viewModelScope.launch {
            advice.value = adviceRepository.getAdviceChitById(id)
        }
    }

    fun getSoundChitById(id: Int) {
        viewModelScope.launch {
            sound.value = soundRepository.getSoundChitById(id)
        }
    }
}