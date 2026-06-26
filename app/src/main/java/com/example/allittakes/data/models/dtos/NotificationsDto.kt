package com.example.allittakes.data.models.dtos

import com.google.gson.annotations.SerializedName

data class NotificationsDto(
    @SerializedName("email")
    val email: Boolean,

    @SerializedName("sms")
    val sms: Boolean,

    @SerializedName("push")
    val push: Boolean,

    @SerializedName("in_app")
    val inApp: Boolean
)