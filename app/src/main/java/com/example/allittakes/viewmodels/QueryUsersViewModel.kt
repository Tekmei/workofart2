package com.example.allittakes.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allittakes.data.models.local.db.UserEntity
import com.example.allittakes.data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QueryUsersViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var query by mutableStateOf("")
        private set

    val users = MutableStateFlow<List<UserEntity>>(emptyList())

    init {
        search("")
    }

    fun onQueryChanged(value: String) {
        query = value
        search(value)
    }

    private fun search(value: String) {
        viewModelScope.launch {
            repository.searchUsers(value)
                .collect {
                    users.value = it
                }
        }
    }
}