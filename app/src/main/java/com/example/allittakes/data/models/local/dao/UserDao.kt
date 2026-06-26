package com.example.allittakes.data.models.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.allittakes.data.models.local.db.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)

    @Query("DELETE FROM users")
    suspend fun clear()

    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUserCount(): Int

    @Query("""
        SELECT *
        FROM users
        WHERE firstName LIKE '%' || :query || '%'
        OR lastName LIKE '%' || :query || '%'
        OR username LIKE '%' || :query || '%'
        OR email LIKE '%' || :query || '%'
        ORDER BY firstName
    """)
    fun searchUsers(query: String): Flow<List<UserEntity>>

    @Query("""
        SELECT *
        FROM users
        ORDER BY firstName
    """)
    fun getUsers(): Flow<List<UserEntity>>

}