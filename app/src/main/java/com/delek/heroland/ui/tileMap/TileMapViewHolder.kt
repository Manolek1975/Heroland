package com.delek.heroland.ui.tileMap

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemBoxBinding
import java.lang.reflect.Field

class TileMapViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemBoxBinding.bind(view)

    fun render(view: View, onItemSelected: (View) -> Unit) {
        //binding.tvName.text = role.name
        //val id = getResId(role.image, R.drawable::class.java)
        //binding.ivRole.setImageResource(id)

        binding.box.setOnClickListener {
            //flipRole(binding.ivRole, goRole = {onItemSelected(role)})
        }
    }

/*    private fun flipRole(view: View, goRole:()->Unit ) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationYBy(360f)
            withEndAction { goRole() }
            start()
        }
    }*/

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