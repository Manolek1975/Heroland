package com.delek.heroland.ui.roleselect

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.Role

class RoleSelectAdapter(private var roleList: List<Role> = emptyList(),
                        private val onItemSelected: (Role) -> Unit) :
    RecyclerView.Adapter<RoleSelectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoleSelectViewHolder {
        return RoleSelectViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_role, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RoleSelectViewHolder, position: Int) {
        holder.render(roleList[position], onItemSelected)
    }

    override fun getItemCount() = roleList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Role>){
        roleList = list
        notifyDataSetChanged()
    }
}