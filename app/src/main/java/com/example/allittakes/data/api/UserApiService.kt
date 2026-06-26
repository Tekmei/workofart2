package com.example.allittakes.data.api

import com.example.allittakes.data.models.dtos.ApiResponse
import com.example.allittakes.data.models.dtos.UserDto
import retrofit2.http.GET


interface UserApiService {

    @GET("media/antonmedv/json-examples/refs/heads/master/data_10mb.json")
    suspend fun getResponse(): ApiResponse

    suspend fun getUsers(): List<UserDto> =
        getResponse().users
}