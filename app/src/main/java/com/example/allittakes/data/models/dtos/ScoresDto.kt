package com.example.allittakes.data.models.dtos

import com.google.gson.annotations.SerializedName

data class ScoresDto(
    @SerializedName("activity")
    val activity: Double,

    @SerializedName("engagement")
    val engagement: Double,

    @SerializedName("reliability")
    val reliability: Double,

    @SerializedName("trust")
    val trust: Double
)