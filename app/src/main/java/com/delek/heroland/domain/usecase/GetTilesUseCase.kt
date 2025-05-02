package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.TileProvider
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Tile
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetTilesUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: TileRepository
) {

    suspend operator fun invoke(): List<Tile> {
        val tiles = repository.getAllTiles()
        return if (tiles.isEmpty()) {
            repository.insertTiles(TileProvider.loadTiles(context))
            tiles
        } else {
            repository.getAllTiles()
        }
    }
}