package com.delek.heroland.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.AdvantageRepository
import com.delek.heroland.data.repository.RoleAdvantageRepository
import com.delek.heroland.data.repository.RoleArmorRepository
import com.delek.heroland.data.repository.RoleChitRepository
import com.delek.heroland.data.repository.RoleDwellingRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.data.repository.RoleWeaponRepository
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.domain.model.Armor
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.Weapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repoRole: RoleRepository,
    private val repoAdv: AdvantageRepository,
    private val repoAdvRole: RoleAdvantageRepository,
    private val repoChitRole: RoleChitRepository,
    private val repoDwellingRole: RoleDwellingRepository,
    private val repoWeaponRole: RoleWeaponRepository,
    private val repoArmorRole: RoleArmorRepository
) : ViewModel() {

    val role = MutableLiveData<Role>()
    val chit = MutableLiveData<List<Chit>>()
    val dwelling = MutableLiveData<List<Dwelling>>()
    val advantages = MutableLiveData<Advantage>()
    //val chits = MutableLiveData<Chit>()
    val weapon = MutableLiveData<List<Weapon>>()
    val armor = MutableLiveData<List<Armor>>()

    fun getRoles(id: Int) {
        viewModelScope.launch {
            role.value = repoRole.getRoleById(id)
        }
    }

    fun getAdvantages(id: Int) {
        viewModelScope.launch {
            val rolAdv = repoAdvRole.getAdvantagesByRole(id)
            for (i in rolAdv) {
                advantages.value = repoAdv.getAdvantageById(i.advantageId)
            }
        }
    }

    fun getChitsByRole(id: Int) {
        viewModelScope.launch {
            val rolChit = repoChitRole.getChitsByRole(id)
            chit.value = rolChit
        }
    }

    fun getDwellingsByRole(id: Int) {
        viewModelScope.launch {
            val rolDwelling = repoDwellingRole.getDwellingsByRole(id)
            dwelling.value = rolDwelling
        }
    }

    fun getWeapons(id: Int) {
        viewModelScope.launch {
            val rolWeapon = repoWeaponRole.getWeaponsByRole(id)
            weapon.value = rolWeapon
        }
    }

    fun getAmor(id: Int) {
        viewModelScope.launch {
            val rolArmor = repoArmorRole.getArmorByRole(id)
            armor.value = rolArmor
        }

    }
}