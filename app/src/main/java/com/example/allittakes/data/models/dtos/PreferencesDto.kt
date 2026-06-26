package com.example.allittakes.data.models.dtos

import com.google.gson.annotations.SerializedName

data class PreferencesDto(
    @SerializedName("language")
    val language: String,

    @SerializedName("theme")
    val theme: String,

    @SerializedName("timezone")
    val timezone: String,

    @SerializedName("notifications")
    val notifications: NotificationsDto,

    @SerializedName("privacy")
    val privacy: PrivacyDto
)