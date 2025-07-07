package com.delek.heroland.ui.tileMap

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View
import javax.inject.Inject

class DrawTileMap @Inject constructor(context: Context) : View(context) {

    val data = context.getSharedPreferences("data", Context.MODE_PRIVATE)!!
    val tile = data.getString("tile", "")

    private val p = Paint()
    //private var bitmap = BitmapFactory.decodeResource(resources, R.color.white)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.apply {
            save()
            setPaint()
            canvas.drawText(tile.toString(), 300f, 100f, p)
            restore()
        }
        invalidate()


    }

    private fun setPaint() {
        //val tf = Typeface.createFromAsset(context.assets, "font/macondo.ttf")
        p.setTypeface(Typeface.DEFAULT_BOLD)
        p.isAntiAlias = true
        p.textSize = 64f
        p.textAlign = Paint.Align.CENTER
        p.color = Color.BLACK

    }
}