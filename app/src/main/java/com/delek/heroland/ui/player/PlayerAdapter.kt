package com.delek.heroland.ui.player

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.Role

class PlayerAdapter(
    private var roleList: List<Role> = emptyList(),
    private val onItemSelected: (Role) -> Unit) :
    RecyclerView.Adapter<PlayerViewHolder>() {

        companion object {
            var rolePos = 0
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        )
    }

    override fun getItemCount() = roleList.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.render(roleList[position], onItemSelected)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Role>) {
        roleList = list
        notifyDataSetChanged()
    }

}