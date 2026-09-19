package com.netforge.app.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Insert
    suspend fun insert(profile: ProfileEntity): Long

    @Update
    suspend fun update(profile: ProfileEntity)

    @Delete
    suspend fun delete(profile: ProfileEntity)

    @Query("SELECT * FROM profiles WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): ProfileEntity?

    @Query("SELECT * FROM profiles ORDER BY updatedAt DESC")
    fun getAllFlow(): Flow<List<ProfileEntity>>

    @Query("SELECT * FROM profiles ORDER BY updatedAt DESC")
    suspend fun getAll(): List<ProfileEntity>

    @Query("DELETE FROM profiles")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM profiles")
    suspend fun count(): Int
}
