package com.delek.heroland.ui.options

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OptionsViewModel @Inject constructor(private val repo: RoleRepository) : ViewModel() {

    val role = MutableLiveData<Role>()

    fun getRole(id: Int){
        viewModelScope.launch {
            role.value = repo.getRoleById(id)
        }
    }

}
