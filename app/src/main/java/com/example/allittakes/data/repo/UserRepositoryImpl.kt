package com.example.allittakes.data.repo

import androidx.room.withTransaction
import com.example.allittakes.data.api.UserApiService
import com.example.allittakes.data.models.local.AppDatabase
import com.example.allittakes.data.models.local.dao.UserDao
import com.example.allittakes.data.models.local.db.UserEntity
import com.example.allittakes.data.models.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val api: UserApiService,
    private val dao: UserDao,
    private val database: AppDatabase
) : UserRepository {

    override suspend fun initializeDatabase() {

        if (dao.getUserCount() > 0) {
            return
        }

        val users = api.getUsers()


        database.withTransaction {

            dao.insertAll(
                users.map { it.toEntity() }
            )

        }
    }

    override fun searchUsers(
        query: String
    ): Flow<List<UserEntity>> {

        return if (query.isBlank()) {

            dao.getUsers()

        } else {

            dao.searchUsers(query)

        }

    }
}