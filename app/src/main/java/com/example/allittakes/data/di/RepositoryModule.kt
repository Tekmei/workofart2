package com.example.allittakes.data.di

import com.example.allittakes.data.repo.UserRepository
import com.example.allittakes.data.repo.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
        impl: UserRepositoryImpl
    ): UserRepository

}
