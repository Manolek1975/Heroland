package com.delek.heroland.ui.tileMap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Tile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TileMapViewModel @Inject constructor(
    private val repository: TileRepository
): ViewModel() {

    val tile = MutableLiveData<Tile>()

    fun getTileById(id: Int) {
        viewModelScope.launch {
            tile.value = repository.getTileById(id)
        }
    }


}