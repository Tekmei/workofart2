package com.example.allittakes.data.models.local.db

import androidx.room.Embedded

data class Address(

    val street: String,

    val city: String,

    val state: String,

    val country: String,

    val postalCode: String,

    @Embedded(prefix = "coordinates_")
    val coordinates: Coordinates
)