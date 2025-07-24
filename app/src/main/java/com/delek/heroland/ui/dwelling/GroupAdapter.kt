package com.delek.heroland.ui.dwelling

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.Group
import javax.inject.Inject

class GroupAdapter @Inject constructor(
    private var groupList: List<Group> = emptyList(),
    private val onItemSelected: (Group) -> Unit
) : RecyclerView.Adapter<GroupViewHolder>() {

    companion object { var selected = 0 }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(group: List<Group>){
        groupList = group
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_group, parent, false)
        return GroupViewHolder(view)
    }

    override fun getItemCount() = groupList.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.render(groupList[position], onItemSelected)
    }


}