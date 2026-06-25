package com.example.allittakes.factory

import com.example.allittakes.storage.PreferenceManager
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val preferenceManager: PreferenceManager
) {

    suspend fun login(username: String) {
        preferenceManager.saveUserName(username)
        preferenceManager.setLoggedIn(true)
    }

    suspend fun logout() {
        preferenceManager.setLoggedIn(false)
    }

    val userName = preferenceManager.userName
    val isLoggedIn = preferenceManager.isLoggedIn
}