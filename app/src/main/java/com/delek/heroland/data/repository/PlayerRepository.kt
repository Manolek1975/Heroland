package com.delek.heroland.data.repository

import com.delek.heroland.data.database.dao.PlayerDao
import com.delek.heroland.data.database.entities.PlayerEntity
import com.delek.heroland.domain.model.Player
import com.delek.heroland.domain.model.toDomain
import javax.inject.Inject

class PlayerRepository@Inject constructor(private val playerDao: PlayerDao) {

    suspend fun insertPlayer(player: PlayerEntity) {
        playerDao.insertPlayer(player)
    }

    suspend fun getAllPlayers(): List<Player> {
        val response: List<PlayerEntity> = playerDao.getAllPlayers()
        return response.map { it.toDomain() }
    }

    suspend fun getPlayerById(id: Int): Player {
        val response: PlayerEntity = playerDao.getPlayerById(id)
        return response.toDomain()
    }

}

