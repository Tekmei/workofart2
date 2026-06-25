package com.example.allittakes.storage

import android.content.Context
import com.example.allittakes.models.UserProfile
import androidx.core.content.edit

class ProfileStorage(context: Context) {

    private val prefs =
        context.getSharedPreferences(
            "profile",
            Context.MODE_PRIVATE
        )

    fun saveProfile(profile: UserProfile) {

        prefs.edit {
            putString("name", profile.name)
                .putString("email", profile.email)
        }
    }

    fun getProfile(): UserProfile {

        return UserProfile(
            prefs.getString("name", "John Doe") ?: "",
            prefs.getString("email", "john@example.com") ?: ""
        )
    }
}