package com.delek.heroland.ui.player

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.core.Game
import com.delek.heroland.databinding.ItemPlayerBinding
import com.delek.heroland.domain.model.Role
import com.delek.heroland.ui.player.PlayerAdapter.Companion.rolePos

class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemPlayerBinding.bind(view)

    fun render (role: Role, onItemSelected: (Role) -> Unit){
        val id = Game().getResId(role.icon, R.drawable::class.java)
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

}