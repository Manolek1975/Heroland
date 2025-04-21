package com.delek.heroland.ui.options

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.RoleDwellingRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OptionsViewModel @Inject constructor(
    private val repoRole: RoleRepository,
    private val repoRoleDwelling: RoleDwellingRepository
) : ViewModel() {

    val role = MutableLiveData<Role>()
    val dwelling = MutableLiveData<List<Dwelling>>()

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

}
