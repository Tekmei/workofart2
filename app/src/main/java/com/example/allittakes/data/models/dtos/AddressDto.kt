package com.example.allittakes.data.models.dtos

import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("street")
    val street: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("state")
    val state: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("postal_code")
    val postalCode: String,

    @SerializedName("coordinates")
    val coordinates: CoordinatesDto
)