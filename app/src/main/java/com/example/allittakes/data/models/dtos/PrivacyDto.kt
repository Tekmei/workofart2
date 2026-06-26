package com.example.allittakes.data.models.dtos

import com.google.gson.annotations.SerializedName

data class PrivacyDto(
    @SerializedName("allow_indexing")
    val allowIndexing: Boolean,

    @SerializedName("profile_visible")
    val profileVisible: Boolean,

    @SerializedName("show_email")
    val showEmail: Boolean,

    @SerializedName("show_phone")
    val showPhone: Boolean
)