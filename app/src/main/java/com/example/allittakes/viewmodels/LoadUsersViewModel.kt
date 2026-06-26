package com.example.allittakes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allittakes.composer.states.LoadUsersUiState
import com.example.allittakes.data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoadUsersViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<LoadUsersUiState>(
            LoadUsersUiState.Loading
        )

    val uiState = _uiState.asStateFlow()

    init {
        initialize()
    }

    private fun initialize() {

        viewModelScope.launch {

            try {

                repository.initializeDatabase()

                _uiState.value =
                    LoadUsersUiState.Success

            } catch (e: Exception) {

                _uiState.value =
                    LoadUsersUiState.Error(
                        e.message ?: "Unknown error"
                    )

            }

        }

    }

    fun retry() {
        _uiState.value = LoadUsersUiState.Loading
        initialize()
    }

}