package com.delek.heroland.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.RoleRepository
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: RoleRepository): ViewModel() {

    val roleEntity = MutableLiveData<Role>()

    fun onCreate(id: Int) {
        viewModelScope.launch {
            roleEntity.value = repository.getRoleById(id)
        }



    }
}