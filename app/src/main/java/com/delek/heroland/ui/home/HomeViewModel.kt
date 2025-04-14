package com.delek.heroland.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.domain.GetDwellingsUseCase
import com.delek.heroland.domain.GetRolesUseCase
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRolesUseCase: GetRolesUseCase,
    private val getDwellingsUseCase: GetDwellingsUseCase
    ) : ViewModel() {

    private val roles = MutableLiveData<Role>()
    private val dwellings = MutableLiveData<Dwelling>()

    fun onCreate() {
        viewModelScope.launch {
            val result1 = getRolesUseCase()
            if (result1.isNotEmpty()) {
                roles.postValue(result1[0])
            }
            val result2 = getDwellingsUseCase()
            if (result2.isNotEmpty()) {
                dwellings.postValue(result2[0])
            }
        }
    }

}