package com.example.allittakes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.allittakes.models.UserProfile
import com.example.allittakes.storage.ProfileStorage

class UserViewModel(private val repo: ProfileStorage) : ViewModel() {


    private val _profile =
        MutableLiveData(repo.getProfile())

    val profile: LiveData<UserProfile> = _profile

    fun updateProfile(
        name: String,
        email: String
    ) {

        repo.saveProfile(
            UserProfile(
                name,
                email
            )
        )

        _profile.value =
            UserProfile(name, email)
    }
}
