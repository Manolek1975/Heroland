package com.delek.heroland.ui.player

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.databinding.ItemPlayerBinding
import com.delek.heroland.domain.model.Role
import com.delek.heroland.ui.player.PlayerAdapter.Companion.rolePos
import java.lang.reflect.Field

class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemPlayerBinding.bind(view)

    fun render (role: Role, onItemSelected: (Role) -> Unit){
        val id = getResId(role.icon, R.drawable::class.java)
        binding.ivIcon.setImageResource(id)
        binding.tvName.text = role.name

        binding.tvName.setOnLongClickListener {
            rolePos = adapterPosition
            getValues(
                goRole = { onItemSelected( role ) },
                goPos = { rolePos }
            )
            true
            //onItemSelected(role)
        }
    }

    private fun getValues(goRole: () -> Unit, goPos: () -> Int) {
        goRole()
        goPos()
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