package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.TileEntity

class TileProvider {

    companion object {
        fun loadTiles(context: Context): List<TileEntity> {
            val tiles: MutableList<TileEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.tile_names)
            val short = context.resources.getStringArray(R.array.tile_short)
            val image = context.resources.getStringArray(R.array.tile_images)
            val type = context.resources.getStringArray(R.array.tile_types)
            val x = context.resources.getStringArray(R.array.tile_x)
            val y = context.resources.getStringArray(R.array.tile_y)
            for (i in name.indices) {
                tiles.add(
                    TileEntity(
                        0,
                        name[i],
                        short[i],
                        image[i],
                        type[i],
                        "",
                        "",
                        false,
                        x[i].toInt(),
                        y[i].toInt()
                    )
                )
            }
            return tiles
        }
    }
}