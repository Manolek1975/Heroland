package com.delek.heroland.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.domain.GetDwellingsUseCase
import com.delek.heroland.domain.GetRolesUseCase
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.GetAdvantagesUseCase
import com.delek.heroland.domain.GetArmorUseCase
import com.delek.heroland.domain.GetChitsUseCase
import com.delek.heroland.domain.GetRoleAdvantagesUseCase
import com.delek.heroland.domain.GetRoleArmorUseCase
import com.delek.heroland.domain.GetRoleChitsUseCase
import com.delek.heroland.domain.GetRoleDwellingsUseCase
import com.delek.heroland.domain.GetRoleWeaponsUseCase
import com.delek.heroland.domain.GetWeaponsUseCase
import com.delek.heroland.domain.model.Armor
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.RoleAdvantage
import com.delek.heroland.domain.model.RoleArmor
import com.delek.heroland.domain.model.RoleChit
import com.delek.heroland.domain.model.RoleDwelling
import com.delek.heroland.domain.model.RoleWeapon
import com.delek.heroland.domain.model.Weapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRolesUseCase: GetRolesUseCase,
    private val getDwellingsUseCase: GetDwellingsUseCase,
    private val getAdvantagesUseCase: GetAdvantagesUseCase,
    private val getRoleAdvantagesUseCase: GetRoleAdvantagesUseCase,
    private val getChitsUseCase: GetChitsUseCase,
    private val getRoleChitsUseCase: GetRoleChitsUseCase,
    private val getRoleDwellingsUseCase: GetRoleDwellingsUseCase,
    private val getWeaponsUseCase: GetWeaponsUseCase,
    private val getRoleWeaponsUseCase: GetRoleWeaponsUseCase,
    private val getArmorUseCase: GetArmorUseCase,
    private val getRoleArmorUseCase: GetRoleArmorUseCase
) : ViewModel() {

    private val roleList = MutableLiveData<Role>()
    private val dwellingList = MutableLiveData<Dwelling>()
    private val advantageList = MutableLiveData<Advantage>()
    private val chitList = MutableLiveData<Chit>()
    private val weaponList = MutableLiveData<Weapon>()
    private val armorList = MutableLiveData<Armor>()
    private val roleAdvantageList = MutableLiveData<RoleAdvantage>()
    private val roleChitList = MutableLiveData<RoleChit>()
    private val roleDwellingList = MutableLiveData<RoleDwelling>()
    private val roleWeaponList = MutableLiveData<RoleWeapon>()
    private val roleArmorList = MutableLiveData<RoleArmor>()


    fun onCreate() {
        viewModelScope.launch {
            val role = getRolesUseCase()
            if (role.isNotEmpty()) {
                roleList.postValue(role[0])
            }
            val dwelling = getDwellingsUseCase()
            if (dwelling.isNotEmpty()) {
                dwellingList.postValue(dwelling[0])
            }
            val advantage = getAdvantagesUseCase()
            if (advantage.isNotEmpty()) {
                advantageList.postValue(advantage[0])
            }
            val roleAdvantage = getRoleAdvantagesUseCase()
            if (roleAdvantage.isNotEmpty()) {
                roleAdvantageList.postValue(roleAdvantage[0])
            }
            val chit = getChitsUseCase()
            if (chit.isNotEmpty()) {
                chitList.postValue(chit[0])
            }
            val roleChit = getRoleChitsUseCase()
            if (roleChit.isNotEmpty()) {
                roleChitList.postValue(roleChit[0])
            }
            val roleDwelling = getRoleDwellingsUseCase()
            if (roleDwelling.isNotEmpty()) {
                roleDwellingList.postValue(roleDwelling[0])
            }
            val weapon = getWeaponsUseCase()
            if (weapon.isNotEmpty()) {
                weaponList.postValue(weapon[0])
            }
            val roleWeapon = getRoleWeaponsUseCase()
            if (roleWeapon.isNotEmpty()) {
                roleWeaponList.postValue(roleWeapon[0])
            }
            val armor = getArmorUseCase()
            if (armor.isNotEmpty()) {
                armorList.postValue(armor[0])
            }
            val roleArmor = getRoleArmorUseCase()
            if (roleArmor.isNotEmpty()) {
                roleArmorList.postValue(roleArmor[0])
            }


        }
    }

}