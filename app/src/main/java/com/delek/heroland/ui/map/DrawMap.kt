package com.delek.heroland.ui.map

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.DisplayMetrics
import android.view.View
import androidx.room.Room
import com.delek.heroland.data.database.HerolandDatabase
import com.delek.heroland.data.repository.TileRepository
import javax.inject.Inject


class DrawMap @Inject constructor(context: Context) : View(context) {

    private val db =  Room.databaseBuilder(context, HerolandDatabase::class.java, "heroland_db").allowMainThreadQueries().build()
    private val dao = db.getTileDao()
    private val repo = TileRepository(dao)
    private val tile = repo.getTiles()

    private val p = Paint()
    private val dm: DisplayMetrics = resources.displayMetrics
    private var x = (dm.widthPixels / 2f)
    private var y = (dm.heightPixels / 2f)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //canvas.translate(cx, cy)
        //println("DRAW: $tile")
        canvas.apply {
            save()
            setPaint()
            canvas.drawText(tile[0].name, x, y, p)
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
}



