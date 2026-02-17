package com.example.di

import com.example.domain.usecase.auth.EmailUseCase
import com.example.domain.utils.EmailValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun provideEmailUseCase(repo: EmailValidator) = EmailUseCase(repo)
}