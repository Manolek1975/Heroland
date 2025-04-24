package com.delek.heroland.ui.options

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.RoleDwellingRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.data.repository.SpellRepository
import com.delek.heroland.data.repository.StartSpellRepository
import com.delek.heroland.data.repository.VictoryPointsRepository
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.Spell
import com.delek.heroland.domain.model.StartSpell
import com.delek.heroland.domain.model.VictoryPoints
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OptionsViewModel @Inject constructor(
    private val repoRole: RoleRepository,
    private val repoRoleDwelling: RoleDwellingRepository,
    private val repoStarSpell: StartSpellRepository,
    private val repoSpell: SpellRepository,
    private val repoVictoryPoints: VictoryPointsRepository
) : ViewModel() {

    val role = MutableLiveData<Role>()
    val dwelling = MutableLiveData<List<Dwelling>>()
    val spellType = MutableLiveData<List<StartSpell>>()
    val spell = MutableLiveData<List<Spell>>()
    val vp = MutableLiveData<List<VictoryPoints>>()

    fun getRole(id: Int) {
        viewModelScope.launch {
            role.value = repoRole.getRoleById(id)
        }
    }

    fun getDwellingsByRole(id: Int) {
        viewModelScope.launch {
            dwelling.value = repoRoleDwelling.getDwellingsByRole(id)
        }
    }

    fun  getStartSpellTypes(id: Int) {
        viewModelScope.launch {
            spellType.value = repoStarSpell.getStartSpellsByRole(id)
        }
    }

    fun getSpellsByType(type: Int) {
        viewModelScope.launch {
            spell.value = repoSpell.getSpellsByType(type)
        }
    }

    fun getVictoryPoints() {
        viewModelScope.launch {
            vp.value = repoVictoryPoints.getVictoryPoints()
        }
    }



}
