package com.delek.heroland.ui.tileMap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.Tile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TileMapViewModel @Inject constructor(
    private val roleRepository: RoleRepository,
    private val tileRepository: TileRepository

): ViewModel() {

    val role = MutableLiveData<Role>()
    val tile = MutableLiveData<Tile>()

    fun getRoleById(id: Int) {
        viewModelScope.launch {
            role.value = roleRepository.getRoleById(id)
        }
    }

    fun getTileById(id: Int) {
        viewModelScope.launch {
            tile.value = tileRepository.getTileById(id)
        }
    }




}