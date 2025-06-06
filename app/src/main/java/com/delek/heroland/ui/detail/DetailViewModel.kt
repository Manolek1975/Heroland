package com.delek.heroland.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.AdvantageRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.domain.model.Armor
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Natives
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.StartSpell
import com.delek.heroland.domain.model.Weapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repoRole: RoleRepository,
    private val repoAdv: AdvantageRepository,
) : ViewModel() {

    val role = MutableLiveData<Role>()
    val chit = MutableLiveData<List<Chit>>()
    val dwelling = MutableLiveData<List<Dwelling>>()
    val advantages = MutableLiveData<Advantage>()
    val weapon = MutableLiveData<List<Weapon>>()
    val armor = MutableLiveData<List<Armor>>()
    val startSpell = MutableLiveData<List<StartSpell>>()
    val allyNatives = MutableLiveData<List<Natives>>()
    val friendlyNatives = MutableLiveData<List<Natives>>()
    val unfriendlyNatives = MutableLiveData<List<Natives>>()
    val enemyNatives = MutableLiveData<List<Natives>>()

    fun getRoles(id: Int) {
        viewModelScope.launch {
            role.value = repoRole.getRoleById(id)
        }
    }

    fun getAdvantages(id: Int) {
        viewModelScope.launch {
            val rolAdv = repoRole.getAdvantagesByRole(id)
            for (i in rolAdv) {
                advantages.value = repoAdv.getAdvantageById(i.advantageId)
            }
        }
    }

    fun getChitsByRole(id: Int) {
        viewModelScope.launch {
            val roleChit = repoRole.getChitsByRole(id)
            chit.value = roleChit
        }
    }

    fun getDwellingsByRole(id: Int) {
        viewModelScope.launch {
            val rolDwelling = repoRole.getDwellingsByRole(id)
            dwelling.value = rolDwelling
        }
    }

    fun getWeapons(id: Int) {
        viewModelScope.launch {
            val rolWeapon = repoRole.getWeaponsByRole(id)
            weapon.value = rolWeapon
        }
    }

    fun getAmor(id: Int) {
        viewModelScope.launch {
            val rolArmor = repoRole.getArmorByRole(id)
            armor.value = rolArmor
        }
    }

    suspend fun countStartSpells(id: Int): Int {
        val count = repoRole.countStartSpells(id)
        return count
    }

    fun getSpells(id: Int) {
        viewModelScope.launch {
            val spell = repoRole.getStartSpellsByRole(id)
            startSpell.value = spell
        }
    }

    fun getAllyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = repoRole.getAllyNatives(id)
            allyNatives.value = rolNatives
        }
    }

    fun getFriendlyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = repoRole.getFriendlyNatives(id)
            friendlyNatives.value = rolNatives
        }
    }

    fun getUnfriendlyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = repoRole.getUnfriendNatives(id)
            unfriendlyNatives.value = rolNatives
        }
    }

    fun getEnemyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = repoRole.getEnemyNatives(id)
            enemyNatives.value = rolNatives
        }
    }
}