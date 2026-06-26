package com.example.allittakes.data.models.local.db

data class Metadata(

    val loginCount: Int? = null,

    val failedAttempts: Int? = null,

    val lastLogin: String? = null,

    val subscriptionTier: String? = null,

    val referralCode: String? = null,

    val referredBy: String? = null,

    val featuresEnabled: List<String>
)