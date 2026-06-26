package com.example.allittakes.data.models.local.db

data class Metadata(

    val loginCount: Int,

    val failedAttempts: Int,

    val lastLogin: String,

    val subscriptionTier: String? = null,

    val referralCode: String? = null,

    val referredBy: String? = null,

    val featuresEnabled: List<String>
)