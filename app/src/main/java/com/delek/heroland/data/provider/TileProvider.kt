package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.TileEntity
import com.delek.heroland.domain.model.Tile

class TileProvider {

    companion object {
        fun loadTiles(context: Context): List<TileEntity> {
            val tiles: MutableList<TileEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.tile_names)
            val short = context.resources.getStringArray(R.array.tile_short)
            val image = context.resources.getStringArray(R.array.tile_images)
            val enchant = context.resources.getStringArray(R.array.tile_enchant)
            val type = context.resources.getStringArray(R.array.tile_types)
            for (i in name.indices) {
                tiles.add(TileEntity(0, name[i], short[i], image[i], enchant[i], type[i]))
            }
            return tiles
        }


    }
}