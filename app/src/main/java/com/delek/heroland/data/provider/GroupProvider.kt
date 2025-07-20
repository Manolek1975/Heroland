package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.GroupEntity

class GroupProvider {

    companion object{
        fun loadGroups(context: Context): List<GroupEntity> {
            val natives: MutableList<GroupEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_group)
            val start = context.resources.getStringArray(R.array.start_group)
            for (i in name.indices) {
                val value = GroupEntity(i+1, name[i], start[i].toInt())
                natives.add(value)
            }
            return natives
        }

    }
}