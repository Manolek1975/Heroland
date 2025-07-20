package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.GroupDao
import com.delek.heroland.data.database.entities.GroupEntity
import com.delek.heroland.domain.model.Group
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class GroupRepository @Inject constructor(private val groupDao: GroupDao) {

    suspend fun insertGroup(natives: List<GroupEntity>) {
        groupDao.insertGroup(natives)
    }

    suspend fun getGroup(): List<Group> {
        val response: List<GroupEntity> = groupDao.getGroup()
        return response.map { it.toDomain() }
    }

    suspend fun getGroupById(id: Int): Group {
        val response: GroupEntity = groupDao.getGroupById(id)
        return response.toDomain()
    }

    suspend fun getGroupByStart(start: Int): Group {
        val response: GroupEntity = groupDao.getGroupByStart(start)
        return response.toDomain()
    }


}