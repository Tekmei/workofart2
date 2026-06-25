package com.example.allittakes.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceManager  @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    suspend fun saveUserName(name: String) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.USER_NAME] = name
        }
    }

    suspend fun setLoggedIn(isLoggedIn: Boolean) {
        dataStore.edit { prefs ->
            prefs[PreferencesKeys.IS_LOGGED_IN] = isLoggedIn
        }
    }

    val userName: Flow<String> =
        dataStore.data.map { prefs ->
            prefs[PreferencesKeys.USER_NAME] ?: "Internal Mimi"
        }

    val isLoggedIn: Flow<Boolean> =
        dataStore.data.map { prefs ->
            prefs[PreferencesKeys.IS_LOGGED_IN] ?: false
        }
}