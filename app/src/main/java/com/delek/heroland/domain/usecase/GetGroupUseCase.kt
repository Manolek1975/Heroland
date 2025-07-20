package com.delek.heroland.domain.usecase

import android.content.Context
import com.delek.heroland.data.provider.GroupProvider
import com.delek.heroland.data.repository.GroupRepository
import com.delek.heroland.domain.model.Group
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetGroupUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: GroupRepository
) {

    suspend operator fun invoke():List<Group>{
        val group = repository.getGroup()
        return if(group.isEmpty()){
            repository.insertGroup(GroupProvider.loadGroups(context))
            group
        }else{
            repository.getGroup()
        }
    }
}