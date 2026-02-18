package com.example.di

import android.content.Context
import com.example.data.repository.SessionRepositoryImpl
import com.example.data.utils.EmailValidatorImpl
import com.example.domain.repository.SessionRepository
import com.example.domain.usecase.utils.ExitSessionUseCase
import com.example.domain.usecase.utils.GetSessionUseCase
import com.example.domain.utils.EmailValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {
    @Provides
    @Singleton
    fun provideSessionRepository(
        @ApplicationContext context: Context
    ): SessionRepository = SessionRepositoryImpl(context)
    @Provides
    @Singleton
    fun provideEmailValidator(): EmailValidator = EmailValidatorImpl()
    @Provides
    @Singleton
    fun provideGetSession(repo: SessionRepository) = GetSessionUseCase(repo)
    @Provides
    @Singleton
    fun provideExitSessionUseCase(repo: SessionRepository) = ExitSessionUseCase(repo)
}