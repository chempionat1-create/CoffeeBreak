package com.example.di

import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.SessionRepository
import com.example.domain.usecase.auth.EmailUseCase
import com.example.domain.usecase.auth.PasswordUseCase
import com.example.domain.usecase.auth.SignInUseCase
import com.example.domain.usecase.auth.SignUpUseCase
import com.example.domain.usecase.auth.ValidateUseCase
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
    fun provideAuthRepository(sessionRepository: SessionRepository): AuthRepository = AuthRepositoryImpl(sessionRepository)
    @Provides
    @Singleton
    fun provideEmailUseCase(repo: EmailValidator) = EmailUseCase(repo)
    @Provides
    @Singleton
    fun providePasswordUseCase() = PasswordUseCase()

    @Provides
    @Singleton
    fun provideValidateUseCase(emailUseCase: EmailUseCase, passwordUseCase: PasswordUseCase) = ValidateUseCase(emailUseCase, passwordUseCase)
    @Provides
    @Singleton
    fun provideSignUpUseCase(repo: AuthRepository) = SignUpUseCase(repo)
    @Provides
    @Singleton
    fun provideSignInUseCase(repo: AuthRepository) = SignInUseCase(repo)
}