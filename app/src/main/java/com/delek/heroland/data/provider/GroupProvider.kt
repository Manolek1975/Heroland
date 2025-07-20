package com.delek.heroland.data.provider

import android.content.Context
import com.delek.heroland.R
import com.delek.heroland.data.database.entities.GroupEntity

class GroupProvider {

    companion object{
        fun loadGroups(context: Context): List<GroupEntity> {
            val natives: MutableList<GroupEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_group)
            for (i in name.indices) {
                val value = GroupEntity(i+1, name[i], 0)
                natives.add(value)
            }
            return natives
        }

    }
}