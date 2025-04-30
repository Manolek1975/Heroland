package com.delek.heroland.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.heroland.data.database.entities.ArmorEntity
import com.delek.heroland.data.database.entities.ChitEntity
import com.delek.heroland.data.database.entities.DwellingEntity
import com.delek.heroland.data.database.entities.NativesEntity
import com.delek.heroland.data.database.entities.RoleAdvantageEntity
import com.delek.heroland.data.database.entities.RoleEntity
import com.delek.heroland.data.database.entities.StartSpellEntity
import com.delek.heroland.data.database.entities.WeaponEntity

@Dao
interface RoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoles(roles: List<RoleEntity>)

    @Query("SELECT * FROM roles")
    suspend fun getAllRoles(): List<RoleEntity>

    @Query("DELETE FROM roles")
    suspend fun deleteAllRoles()

    @Query("SELECT * FROM roles WHERE id = :id")
    suspend fun getRoleById(id: Int): RoleEntity

    @Query("SELECT * FROM start_spells WHERE role_id = :roleId")
    suspend fun getStartSpellsByRole(roleId: Int): List<StartSpellEntity>

    @Query("SELECT spells FROM roles WHERE id = :id")
    suspend fun countStartSpells(id: Int): Int

    @Query("SELECT * FROM dwellings INNER JOIN role_dwellings " +
            "ON dwellings.id = role_dwellings.dwelling_id " +
            "WHERE role_dwellings.role_id = :id")
    suspend fun getDwellingsByRole(id: Int): List<DwellingEntity>

    @Query("SELECT * FROM advantages INNER JOIN role_advantages " +
            "ON advantages.id = role_advantages.advantage_id " +
            "WHERE role_advantages.role_id = :id")
    suspend fun getAdvantagesByRole(id: Int): List<RoleAdvantageEntity>

    @Query("SELECT * FROM chits INNER JOIN role_chits " +
            "ON chits.id = role_chits.chit_id " +
            "WHERE role_chits.role_id = :id")
    suspend fun getChitsByRole(id: Int): List<ChitEntity>

    @Query("SELECT * FROM weapons INNER JOIN role_weapons " +
            "ON weapons.id = role_weapons.weapon_id " +
            "WHERE role_weapons.role_id = :id")
    suspend fun getWeaponsByRole(id: Int): List<WeaponEntity>

    @Query("SELECT * FROM armor INNER JOIN role_armor " +
            "ON armor.id = role_armor.armor_id " +
            "WHERE role_armor.role_id = :id")
    suspend fun getArmorByRole(id: Int): List<ArmorEntity>

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = '1'")
    suspend fun getAllyNatives(id: Int): List<NativesEntity>

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = '2'")
    suspend fun getFriendlyNatives(id: Int): List<NativesEntity>

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = '4'")
    suspend fun getUnfriendlyNatives(id: Int): List<NativesEntity>

    @Query("SELECT * FROM natives INNER JOIN role_natives " +
            "ON natives.id = role_natives.native_id " +
            "WHERE role_natives.role_id = :id " +
            "AND role_natives.relation = '5'")
    suspend fun getEnemyNatives(id: Int): List<NativesEntity>


    @Query("SELECT * FROM roles INNER JOIN players " +
            "ON roles.id = players.role ")
    suspend fun getRolesByPlayer(): List<RoleEntity>

    @Query("SELECT * FROM roles LEFT JOIN players " +
            "ON roles.id = players.role " +
            "WHERE players.role IS NULL")
    suspend fun getRolesNotInPlayers(): List<RoleEntity>
}