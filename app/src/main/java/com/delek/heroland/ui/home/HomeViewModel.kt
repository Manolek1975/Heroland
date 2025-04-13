package com.delek.heroland.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.RoleRepository
import com.delek.heroland.domain.provider.DwellingProvider
import com.delek.heroland.domain.provider.RoleProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: RoleRepository) : ViewModel() {

    fun insertAll() = viewModelScope.launch {
        repository.insertRoles(RoleProvider.roles)
        repository.insertDwellings(DwellingProvider.dwellings)
    }

}