package com.delek.heroland.ui.tileMap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.AdviceChitRepository
import com.delek.heroland.data.repository.DwellingRepository
import com.delek.heroland.data.repository.MonsterRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.data.repository.SoundChitRepository
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.AdviceChit
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Monster
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.SoundChit
import com.delek.heroland.domain.model.Tile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TileMapViewModel @Inject constructor(
    private val roleRepository: RoleRepository,
    private val tileRepository: TileRepository,
    private val dwellingRepository: DwellingRepository,
    private val adviceRepository: AdviceChitRepository,
    private val soundRepository: SoundChitRepository,
    private val monsterRepository: MonsterRepository
): ViewModel() {

    val role = MutableLiveData<Role>()
    val tile = MutableLiveData<Tile>()
    val dwelling = MutableLiveData<Dwelling>()
    val advice = MutableLiveData<AdviceChit>()
    val sound = MutableLiveData<SoundChit>()
    val monster = MutableLiveData<Monster>()

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

    fun getDwellingById(id: Int) {
        viewModelScope.launch {
            dwelling.value = dwellingRepository.getDwellingById(id)
        }

    }

    fun getMonsterById(id: Int) {
        viewModelScope.launch {
            monster.value = monsterRepository.getMonsterById(id)
        }
    }




}