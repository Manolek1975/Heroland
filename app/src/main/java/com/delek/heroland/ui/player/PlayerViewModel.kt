package com.delek.heroland.ui.player

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val repository: RoleRepository
) : ViewModel() {

    val roles = MutableLiveData<List<Role>>()

    fun getRolesByPlayer() {
        viewModelScope.launch {
            roles.value = repository.getRolesByPlayer()
        }
    }

    fun deletePlayer(id: Int) {
        viewModelScope.launch {
            repository.deletePlayer(id)
        }
    }

}