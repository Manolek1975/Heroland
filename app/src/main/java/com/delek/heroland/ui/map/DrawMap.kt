package com.delek.heroland.ui.map

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.DisplayMetrics
import android.view.View

class DrawMap(context: Context) : View(context) {

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
            canvas.drawText("Linden Woods", x, y, p)
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