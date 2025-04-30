package com.delek.heroland.ui.roleselect

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoleSelectViewModel @Inject constructor(private val repository: RoleRepository) :
    ViewModel() {

    val roleEntity = MutableLiveData<List<Role>>()

    init {
        viewModelScope.launch {
            roleEntity.value = repository.getRolesNotInPlayers()
        }
    }

}
