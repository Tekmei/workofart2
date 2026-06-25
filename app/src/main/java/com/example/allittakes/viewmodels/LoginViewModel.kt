package com.example.allittakes.viewmodels


import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    fun login(
        username: String,
        password: String
    ): Boolean {

        return username == "admin" &&
                password == "1234"
    }
}