package com.example.allittakes.data.repo

import com.example.allittakes.data.models.local.db.UserEntity
import kotlinx.coroutines.flow.Flow


interface UserRepository {

    suspend fun initializeDatabase()

    fun searchUsers(query: String): Flow<List<UserEntity>>

}