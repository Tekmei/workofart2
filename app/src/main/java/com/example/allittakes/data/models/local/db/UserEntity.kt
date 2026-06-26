package com.example.allittakes.data.models.local.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey
    val id: String,

    val firstName: String,

    val lastName: String,

    val username: String,

    val email: String,

    val phone: String,

    val gender: String,

    val age: Int,

    val avatarUrl: String,

    val birthDate: String,

    val balance: Double,

    val currency: String,

    val bio: String,

    val premium: Boolean,

    val verified: Boolean,

    val createdAt: String,

    val updatedAt: String?,

    val deletedAt: String?,

    @Embedded(prefix = "address_")
    val address: Address,

    @Embedded(prefix = "metadata_")
    val metadata: Metadata,

    @Embedded(prefix = "preferences_")
    val preferences: Preferences,

    @Embedded(prefix = "scores_")
    val scores: Scores,

    val tags: List<String>
)