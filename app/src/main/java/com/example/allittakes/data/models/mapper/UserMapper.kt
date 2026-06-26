package com.example.allittakes.data.models.mapper

import com.example.allittakes.data.models.dtos.AddressDto
import com.example.allittakes.data.models.dtos.CoordinatesDto
import com.example.allittakes.data.models.dtos.MetadataDto
import com.example.allittakes.data.models.dtos.*
import com.example.allittakes.data.models.local.db.Address
import com.example.allittakes.data.models.local.db.*
import com.example.allittakes.data.models.local.db.UserEntity

fun CoordinatesDto.toEntity() = Coordinates(
    latitude = latitude,
    longitude = longitude
)
fun AddressDto.toEntity() = Address(
    street = street,
    city = city,
    state = state,
    country = country,
    postalCode = postalCode,
    coordinates = coordinates.toEntity()
)
fun MetadataDto.toEntity() = Metadata(
    loginCount = loginCount,
    failedAttempts = failedAttempts,
    lastLogin = lastLogin,
    subscriptionTier = subscriptionTier,
    referralCode = referralCode,
    referredBy = referredBy,
    featuresEnabled = featuresEnabled
)

fun NotificationsDto.toEntity() = Notifications(
    email = email,
    sms = sms,
    push = push,
    inApp = inApp
)

fun PrivacyDto.toEntity() = Privacy(
    allowIndexing = allowIndexing,
    profileVisible = profileVisible,
    showEmail = showEmail,
    showPhone = showPhone
)

fun ScoresDto.toEntity() = Scores(
    activity = activity,
    engagement = engagement,
    reliability = reliability,
    trust = trust
)

fun PreferencesDto.toEntity() = Preferences(
    language = language,
    theme = theme,
    timezone = timezone,
    notifications = notifications.toEntity(),
    privacy = privacy.toEntity()
)
fun UserDto.toEntity(): UserEntity {

    return UserEntity(
        id = id,
        firstName = firstName,
        lastName = lastName,
        username = username,
        email = email,
        phone = phone,
        gender = gender,
        age = age,
        avatarUrl = avatarUrl,
        birthDate = birthDate,
        balance = balance,
        currency = currency,
        bio = bio,
        premium = premium,
        verified = verified,
        createdAt = createdAt,
        updatedAt = updatedAt,
        deletedAt = deletedAt,

        address = address.toEntity(),
        metadata = metadata.toEntity(),
        preferences = preferences.toEntity(),
        scores = scores.toEntity(),

        tags = tags
    )
}