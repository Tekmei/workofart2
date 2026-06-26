package com.example.allittakes.composer.states

sealed interface LoadUsersUiState {

    object Loading : LoadUsersUiState

    object Success : LoadUsersUiState

    data class Error(
        val message: String
    ) : LoadUsersUiState

}