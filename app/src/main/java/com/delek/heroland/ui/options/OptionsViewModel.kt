package com.delek.heroland.ui.options

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.database.entities.PlayerEntity
import com.delek.heroland.data.database.entities.VpRoleEntity
import com.delek.heroland.data.repository.PlayerRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.data.repository.SpellRepository
import com.delek.heroland.data.repository.VictoryPointsRepository
import com.delek.heroland.data.repository.VpRoleRepository
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Player
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.Spell
import com.delek.heroland.domain.model.StartSpell
import com.delek.heroland.domain.model.VictoryPoints
import com.delek.heroland.domain.model.VpRole
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OptionsViewModel @Inject constructor(
    private val repoRole: RoleRepository,
    private val repoSpell: SpellRepository,
    private val repoVictoryPoints: VictoryPointsRepository,
    private val repoPlayer: PlayerRepository,
    private val repoVpRole: VpRoleRepository
) : ViewModel() {

    val role = MutableLiveData<Role>()
    val dwelling = MutableLiveData<List<Dwelling>>()
    val spellType = MutableLiveData<List<StartSpell>>()
    val spell = MutableLiveData<List<Spell>>()
    val vp = MutableLiveData<List<VictoryPoints>>()
    val player = MutableLiveData<List<Player>>()
    val vpRole = MutableLiveData<List<VpRole>>()

    fun getRole(id: Int) {
        viewModelScope.launch {
            role.value = repoRole.getRoleById(id)
        }
    }

    fun getDwellingsByRole(id: Int) {
        viewModelScope.launch {
            dwelling.value = repoRole.getDwellingsByRole(id)
        }
    }

    fun  getStartSpellTypes(id: Int) {
        viewModelScope.launch {
            spellType.value = repoRole.getStartSpellsByRole(id)
        }
    }

    fun getSpellsByType(type: Int) {
        viewModelScope.launch {
            spell.value = repoSpell.getSpellsByType(type)
        }
    }

    fun insertVictoryPoints(vpList: VpRoleEntity) {
        viewModelScope.launch {
            repoVpRole.insertVpRole(vpList)
        }
    }

    fun updateVictoryPoints(value: Int, id: Int) {
        viewModelScope.launch {
            repoVictoryPoints.updateVictoryPoints(value, id)
        }
    }

    fun getAllVictoryPoints() {
        viewModelScope.launch {
            vp.value = repoVictoryPoints.getAllVictoryPoints()
        }
    }

    fun insertPlayer(player: PlayerEntity) {
        viewModelScope.launch {
            repoPlayer.insertPlayer(player)
        }
    }

    fun getAllPlayers() {
        viewModelScope.launch {
            player.value = repoPlayer.getAllPlayers()
        }
    }
}
