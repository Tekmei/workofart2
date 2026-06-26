package com.example.allittakes.composer.states

import com.example.allittakes.data.models.local.db.UserEntity

data class QueryUsersUiState(

    val query: String = "",

    val users: List<UserEntity> = emptyList(),

    val loading: Boolean = true

)