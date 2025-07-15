package com.delek.heroland.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val roleRepository: RoleRepository
) : ViewModel() {

    val role = MutableLiveData<Role>()

    fun geRoleById(id: Int) {
        viewModelScope.launch {
            role.value = roleRepository.getRoleById(id)
        }
    }
}