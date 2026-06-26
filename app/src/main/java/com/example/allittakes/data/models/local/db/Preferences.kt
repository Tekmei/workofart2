package com.example.allittakes.data.models.local.db

import androidx.room.Embedded

data class Preferences(

    val language: String,

    val theme: String,

    val timezone: String,

    @Embedded(prefix = "notification_")
    val notifications: Notifications,

    @Embedded(prefix = "privacy_")
    val privacy: Privacy
)