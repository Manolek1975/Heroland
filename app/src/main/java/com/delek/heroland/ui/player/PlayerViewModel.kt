package com.delek.heroland.ui.player

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.PlayerRepository
import com.delek.heroland.data.repository.RoleRepository
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Player
import com.delek.heroland.domain.model.Role
import com.delek.heroland.domain.model.Tile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val roleRepository: RoleRepository,
    private val tileRepository: TileRepository,
    private val playerRepository: PlayerRepository
) : ViewModel() {

    val roles = MutableLiveData<List<Role>>()
    val tile = MutableLiveData<Tile>()
    val player = MutableLiveData<Player>()


    fun getRolesByPlayer() {
        viewModelScope.launch {
            roles.value = roleRepository.getRolesByPlayer()
        }
    }

    fun deletePlayer(id: Int) {
        viewModelScope.launch {
            roleRepository.deletePlayer(id)
        }
    }

    fun getTileByAdviceChit(id: Int){
        viewModelScope.launch {
            tile.value = tileRepository.getTileByAdviceId(id)
        }
    }

    fun getPlayerById(id: Int) {
        viewModelScope.launch {
            player.value = playerRepository.getPlayerById(id)
        }
    }

    fun updateLocation(loc: String, id: Int) {
        viewModelScope.launch {
            playerRepository.updateLocation(loc, id)
        }
    }

}