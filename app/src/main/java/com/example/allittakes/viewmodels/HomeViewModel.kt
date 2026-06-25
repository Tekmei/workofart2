package com.example.allittakes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allittakes.factory.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: UserRepository) : ViewModel(){
    val userName = repository.userName
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            "Mimi"
        )

    fun login(name: String) {
        viewModelScope.launch {
            repository.login(name)
        }
    }

}