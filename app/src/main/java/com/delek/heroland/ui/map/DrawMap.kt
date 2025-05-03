package com.delek.heroland.ui.map

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.DisplayMetrics
import android.view.View
import androidx.room.Room
import com.delek.heroland.R
import com.delek.heroland.data.database.HerolandDatabase
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Tile
import java.lang.reflect.Field
import javax.inject.Inject


class DrawMap @Inject constructor(context: Context) : View(context) {
    //Build ROOM database out of Main thread
    private val db =  Room.databaseBuilder(context, HerolandDatabase::class.java, "heroland_db").allowMainThreadQueries().build()
    private val dao = db.getTileDao()
    private val repo = TileRepository(dao)
    private val tile = repo.getTiles()
    //Init variables
    private val p = Paint()
    private val dm: DisplayMetrics = resources.displayMetrics
    private var x = (dm.widthPixels / 2f)
    private var y = (dm.heightPixels / 2f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //canvas.translate(cx, cy)
        canvas.apply {
            save()
            setPaint()
            drawBitmap(getBitmap(tile[15]), x, y, p)
            restore()
        }
        invalidate()
    }

    private fun setPaint(){
        p.isAntiAlias = true
        p.textSize = 64f
        p.textAlign = Paint.Align.CENTER
        p.setTypeface(Typeface.DEFAULT_BOLD)
        p.color = Color.YELLOW
    }

    private fun getBitmap(tile: Tile): Bitmap{
        val id = getResId(tile.image, R.drawable::class.java)
        val bitmap = BitmapFactory.decodeResource(resources, id)
        val scale = Bitmap.createScaledBitmap(bitmap, 120, 120, false)
        return scale
    }

    private fun getResId(resName: String?, c: Class<*>): Int {
        try {
            val idField: Field = c.getDeclaredField(resName!!)
            return idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            return -1
        }
    }
}



