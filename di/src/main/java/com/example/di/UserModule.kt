package com.example.di

import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.user.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {
    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository = UserRepositoryImpl()

    @Provides
    @Singleton
    fun provideGetUserUseCase(repo: UserRepository) = GetUserUseCase(repo)
}