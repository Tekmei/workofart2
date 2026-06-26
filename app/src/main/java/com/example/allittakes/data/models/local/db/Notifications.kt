package com.example.allittakes.data.models.local.db

data class Notifications(

    val email: Boolean,

    val sms: Boolean,

    val push: Boolean,

    val inApp: Boolean
)