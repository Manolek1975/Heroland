package com.delek.heroland.ui.map

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Tile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val repository: TileRepository
): ViewModel() {

    val tiles = MutableLiveData<List<Tile>>()

    fun getAllTiles() {
        viewModelScope.launch {
            tiles.value = repository.getAllTiles()
        }
    }

}