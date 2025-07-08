package com.delek.heroland.ui.tileMap

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
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

class DrawTileMap @Inject constructor(context: Context) : View(context) {
    val data = context.getSharedPreferences("data", Context.MODE_PRIVATE)!!
    //Build ROOM database out of Main thread
    private val db = Room.databaseBuilder(context, HerolandDatabase::class.java, "heroland_db")
        .allowMainThreadQueries().build()
    private val dao = db.getTileDao()
    private val repo = TileRepository(dao)
    private val tiles = repo.getTiles()
    //Init variables
    private val tileId = data.getInt("tileId", 0)
    val tile = tiles.find { it.id == tileId }
    private val p = Paint()
    private val dm: DisplayMetrics = resources.displayMetrics
    private var x = dm.widthPixels
    private var y = dm.heightPixels
    private var bar = getActionBarHeight()
    private var bg = scaleBitmap(tile)
    private val box = mutableListOf<Rect>()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val w = x / 5
        val h = y / w
        for (j in 0..h) {
            for (i in 0..4) {
                val rect = Rect()
                rect.left = 0 + w * i
                rect.top = 150 + j
                rect.right = rect.left + w
                rect.bottom = rect.top + w * j
                box.add(rect)
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {
            save()
            setPaint()
            canvas.drawBitmap(bg, 0f,  0f, null)
            for (b in box){
                canvas.drawRect(b, p)
            }
            p.style = Paint.Style.FILL
            canvas.drawText(tile!!.name, x/2f, 100f, p)
            restore()
        }
        invalidate()
    }

    private fun setPaint() {
        //val tf = Typeface.createFromAsset(context.assets, "font/macondo.ttf")

        p.textAlign = Paint.Align.CENTER
        p.setTypeface(Typeface.DEFAULT_BOLD)
        p.isAntiAlias = true
        p.textSize = 64f
        p.color = Color.WHITE
        p.style = Paint.Style.STROKE
        p.strokeWidth= 2f


    }

    private fun scaleBitmap(tile: Tile?): Bitmap {
        val id = getResId(tile?.image, R.drawable::class.java)
        val bitmap = BitmapFactory.decodeResource(resources, id)
        val scale = Bitmap.createScaledBitmap(bitmap, x, y + bar, false)
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

    private fun getActionBarHeight(): Int {
        val ta = context.theme.obtainStyledAttributes(intArrayOf(android.R.attr.actionBarSize))
        val actionBarHeight = ta.getDimension(0, 0f).toInt()
        return actionBarHeight
    }
}