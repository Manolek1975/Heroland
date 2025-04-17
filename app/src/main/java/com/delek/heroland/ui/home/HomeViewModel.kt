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
import com.delek.heroland.domain.GetChitsUseCase
import com.delek.heroland.domain.GetRoleAdvantagesUseCase
import com.delek.heroland.domain.GetRoleChitsUseCase
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.RoleAdvantages
import com.delek.heroland.domain.model.RoleChit
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
    private val getRoleChitsUseCase: GetRoleChitsUseCase
) : ViewModel() {

    private val roles = MutableLiveData<Role>()
    private val dwellings = MutableLiveData<Dwelling>()
    private val advantages = MutableLiveData<Advantage>()
    private val roleAdvantages = MutableLiveData<RoleAdvantages>()
    private val chits = MutableLiveData<Chit>()
    private val roleChits = MutableLiveData<RoleChit>()

    fun onCreate() {
        viewModelScope.launch {
            val role = getRolesUseCase()
            if (role.isNotEmpty()) {
                roles.postValue(role[0])
            }
            val dwelling = getDwellingsUseCase()
            if (dwelling.isNotEmpty()) {
                dwellings.postValue(dwelling[0])
            }
            val advantage = getAdvantagesUseCase()
            if (advantage.isNotEmpty()) {
                advantages.postValue(advantage[0])
            }
            val roleAdvantage = getRoleAdvantagesUseCase()
            if (roleAdvantage.isNotEmpty()) {
                roleAdvantages.postValue(roleAdvantage[0])
            }
            val chit = getChitsUseCase()
            if (chit.isNotEmpty()) {
                chits.postValue(chit[0])
            }
            val roleChit = getRoleChitsUseCase()
            if (roleChit.isNotEmpty()) {
                roleChits.postValue(roleChit[0])
            }


        }
    }

}