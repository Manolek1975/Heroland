package com.delek.heroland.ui.player

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.databinding.ItemPlayerBinding
import com.delek.heroland.domain.model.Role
import java.lang.reflect.Field

class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemPlayerBinding.bind(view)

    fun render (role: Role){
        val id = getResId(role.icon, R.drawable::class.java)
        binding.ivIcon.setImageResource(id)
        binding.tvName.text = role.name
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