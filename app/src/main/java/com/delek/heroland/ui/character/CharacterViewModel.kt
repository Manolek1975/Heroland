package com.delek.heroland.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.AdvantageRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repoRole: RoleRepository,
    private val repoAdv:  AdvantageRepository
) : ViewModel() {

    val role = MutableLiveData<Role>()
    val advantages = MutableLiveData<Advantage>()
    val chit = MutableLiveData<List<Chit>>()

    fun geRoleById(id: Int) {
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
}