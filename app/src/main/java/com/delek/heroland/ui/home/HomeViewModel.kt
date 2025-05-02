package com.delek.heroland.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.PlayerRepository
import com.delek.heroland.domain.usecase.GetDwellingsUseCase
import com.delek.heroland.domain.usecase.GetRolesUseCase
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.usecase.GetAdvantagesUseCase
import com.delek.heroland.domain.usecase.GetArmorUseCase
import com.delek.heroland.domain.usecase.GetChitsUseCase
import com.delek.heroland.domain.usecase.GetNativesUseCase
import com.delek.heroland.domain.usecase.GetRoleAdvantagesUseCase
import com.delek.heroland.domain.usecase.GetRoleArmorUseCase
import com.delek.heroland.domain.usecase.GetRoleChitsUseCase
import com.delek.heroland.domain.usecase.GetRoleDwellingsUseCase
import com.delek.heroland.domain.usecase.GetRoleNativesUseCase
import com.delek.heroland.domain.usecase.GetRoleWeaponsUseCase
import com.delek.heroland.domain.usecase.GetSpellUseCase
import com.delek.heroland.domain.usecase.GetStartSpellUseCase
import com.delek.heroland.domain.usecase.GetWeaponsUseCase
import com.delek.heroland.domain.model.Armor
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.Natives
import com.delek.heroland.domain.model.Player
import com.delek.heroland.domain.model.RoleAdvantage
import com.delek.heroland.domain.model.RoleArmor
import com.delek.heroland.domain.model.RoleChit
import com.delek.heroland.domain.model.RoleDwelling
import com.delek.heroland.domain.model.RoleNatives
import com.delek.heroland.domain.model.RoleWeapon
import com.delek.heroland.domain.model.Spell
import com.delek.heroland.domain.model.SpellType
import com.delek.heroland.domain.model.StartSpell
import com.delek.heroland.domain.model.Tile
import com.delek.heroland.domain.model.VictoryPoints
import com.delek.heroland.domain.model.Weapon
import com.delek.heroland.domain.usecase.GetSpellTypeUseCase
import com.delek.heroland.domain.usecase.GetTilesUseCase
import com.delek.heroland.domain.usecase.GetVictoryPointsUseCase
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
    private val getRoleArmorUseCase: GetRoleArmorUseCase,
    private val getStartSpellUseCase: GetStartSpellUseCase,
    private val getNativesUseCase: GetNativesUseCase,
    private val getRoleNativesUseCase: GetRoleNativesUseCase,
    private val getSpellUseCase: GetSpellUseCase,
    private val getSpellTypeUseCase: GetSpellTypeUseCase,
    private val getVictoryPointsUseCase: GetVictoryPointsUseCase,
    private val getTilesUseCase: GetTilesUseCase,
    private val repoPlayer: PlayerRepository
) : ViewModel() {

    //TODO Create class to load all use cases or insert all in single use, no idea atm!
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
    private val startSpellList = MutableLiveData<StartSpell>()
    private val nativesList = MutableLiveData<Natives>()
    private val roleNativesList = MutableLiveData<RoleNatives>()
    private val spellList = MutableLiveData<Spell>()
    private val spellTypeList = MutableLiveData<SpellType>()
    private val vpList = MutableLiveData<List<VictoryPoints>>()
    private val tileList = MutableLiveData<Tile>()
    val playerList = MutableLiveData<List<Player>>()


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
            val startSpell = getStartSpellUseCase()
            if (startSpell.isNotEmpty()) {
                startSpellList.postValue(startSpell[0])
            }
            val natives = getNativesUseCase()
            if (natives.isNotEmpty()) {
                nativesList.postValue(natives[0])
            }
            val roleNatives = getRoleNativesUseCase()
            if (roleNatives.isNotEmpty()) {
                roleNativesList.postValue(roleNatives[0])
            }
            val spell = getSpellUseCase()
            if (spell.isNotEmpty()) {
                spellList.postValue(spell[0])
            }
            val spellType = getSpellTypeUseCase()
            if (spellType.isNotEmpty()) {
                spellTypeList.postValue(spellType[0])
            }
            val vp = getVictoryPointsUseCase()
            if (vp.isNotEmpty()) {
                vpList.postValue(vp)
            }
            val tile = getTilesUseCase()
            if (tile.isNotEmpty()) {
                tileList.postValue(tile[0])
            }
        }
    }

    fun getPlayers() {
        viewModelScope.launch {
            playerList.value = repoPlayer.getAllPlayers()
        }
    }

}