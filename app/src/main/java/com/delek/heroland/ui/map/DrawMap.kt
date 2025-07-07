package com.delek.heroland.ui.map

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import androidx.navigation.findNavController
import androidx.room.Room
import com.delek.heroland.R
import com.delek.heroland.data.database.HerolandDatabase
import com.delek.heroland.data.repository.TileRepository
import com.delek.heroland.domain.model.Tile
import java.lang.reflect.Field
import javax.inject.Inject


class DrawMap @Inject constructor(context: Context) : View(context) {
    //Build ROOM database out of Main thread
    private val db = Room.databaseBuilder(context, HerolandDatabase::class.java, "heroland_db")
        .allowMainThreadQueries().build()
    private val dao = db.getTileDao()
    private val repo = TileRepository(dao)
    private val tiles = repo.getTiles()

    //Init variables
    private val p = Paint()
    private val dm: DisplayMetrics = resources.displayMetrics
    private var x = (dm.widthPixels / 2f)
    private var y = (dm.heightPixels / 2f)
    private var bitmap = BitmapFactory.decodeResource(resources, R.drawable.bg_map)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //canvas.translate(cx, cy)
        canvas.apply {
            save()
            setPaint()
            canvas.drawBitmap(bitmap, 0f, 0f, null)
            for (cord in tiles) {
                val x1 = cord.x.toFloat()
                val y1 = cord.y.toFloat()
                canvas.drawText(cord.name, x1, y1 - 20, p)
                canvas.drawCircle(x1, y1, 15F, p)
                //p.color = ResourcesCompat.getColor(resources, R.color.white, null)
            }
            //drawBitmap(getBitmap(tile[15]), x, y, p)
            restore()
        }
        invalidate()
    }

    private fun setPaint() {
        //val tf = Typeface.createFromAsset(context.assets, "font/macondo.ttf")
        p.setTypeface(Typeface.DEFAULT_BOLD)
        p.isAntiAlias = true
        p.textSize = 32f
        p.textAlign = Paint.Align.CENTER
        p.color = Color.YELLOW

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val data = context.getSharedPreferences("data", Context.MODE_PRIVATE)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val touchedTile = findTile(event.x, event.y)

                touchedTile?.let {
                    data.edit().putString("tile", touchedTile.name).apply()
                    findNavController().navigate(
                        MapFragmentDirections.actionNavMapToTileMapFragment(touchedTile.id)
                    )
                }
                return true
            }
            else -> return super.onTouchEvent(event)
        }
    }

    private fun findTile(x: Float, y: Float): Tile? {
        // Logic to find the star that was touched based on coordinates
        for (cord in tiles) {
            // Check if (x, y) is within the bounds of the star's circle
            if (cord.x - 40 <= x && x <= cord.x + 40 &&
                cord.y - 40 <= y && y <= cord.y + 40) {
                return cord
            }
        }
        return null
    }

    private fun getBitmap(tile: Tile): Bitmap {
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



