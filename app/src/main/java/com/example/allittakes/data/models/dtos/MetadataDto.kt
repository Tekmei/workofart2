package com.example.allittakes.data.models.dtos

import com.google.gson.annotations.SerializedName

data class MetadataDto(
    @SerializedName("login_count")
    val loginCount: Int,

    @SerializedName("failed_attempts")
    val failedAttempts: Int,

    @SerializedName("last_login")
    val lastLogin: String,

    @SerializedName("subscription_tier")
    val subscriptionTier: String,

    @SerializedName("referral_code")
    val referralCode: String,

    @SerializedName("referred_by")
    val referredBy: String,

    @SerializedName("features_enabled")
    val featuresEnabled: List<String>
)