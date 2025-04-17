package com.delek.heroland.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.AdvantageRepository
import com.delek.heroland.data.repository.RoleAdvantagesRepository
import com.delek.heroland.data.repository.RoleChitRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Advantage
import com.delek.heroland.domain.model.Chit
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: RoleRepository,
    private val repoAdv: AdvantageRepository,
    private val repoAdvRole: RoleAdvantagesRepository,
    private val repoChitRole: RoleChitRepository
) : ViewModel() {

    val roleEntity = MutableLiveData<Role>()
    val chitEntity = MutableLiveData<List<Chit>>()
    val advantages = MutableLiveData<Advantage>()
    val chits = MutableLiveData<Chit>()

    fun onCreate(id: Int) {
        viewModelScope.launch {
            roleEntity.value = repository.getRoleById(id)
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
            chitEntity.value = rolChit
        }
    }

}