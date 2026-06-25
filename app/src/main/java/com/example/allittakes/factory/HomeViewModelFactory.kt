package com.example.allittakes.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.allittakes.storage.ProfileStorage
import com.example.allittakes.viewmodels.HomeViewModel
import com.example.allittakes.viewmodels.UserViewModel

class HomeViewModelFactory(
    private val repo: UserRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return HomeViewModel(repo) as T
        }

        throw IllegalArgumentException()
    }
}