package com.example.allittakes.data.models.dtos

import com.example.allittakes.data.models.local.db.UserEntity
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("age")
    val age: Int,

    @SerializedName("avatar_url")
    val avatarUrl: String,

    @SerializedName("birth_date")
    val birthDate: String,

    @SerializedName("balance")
    val balance: Double,

    @SerializedName("currency")
    val currency: String,

    @SerializedName("bio")
    val bio: String,

    @SerializedName("premium")
    val premium: Boolean,

    @SerializedName("verified")
    val verified: Boolean,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: String?,

    @SerializedName("deleted_at")
    val deletedAt: String?,

    @SerializedName("address")
    val address: AddressDto,

    @SerializedName("metadata")
    val metadata: MetadataDto,

    @SerializedName("preferences")
    val preferences: PreferencesDto,

    @SerializedName("scores")
    val scores: ScoresDto,

    @SerializedName("tags")
    val tags: List<String>
)