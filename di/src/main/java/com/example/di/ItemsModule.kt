package com.example.di

import com.example.data.repository.ItemsRepositoryImpl
import com.example.domain.repository.ItemsRepository
import com.example.domain.usecase.items.GetBaristasUseCase
import com.example.domain.usecase.items.GetItemsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ItemsModule {
    @Provides
    @Singleton
    fun provideItemsRepository(): ItemsRepository = ItemsRepositoryImpl()

    @Provides
    @Singleton
    fun provideGetBaristasUseCase(repo: ItemsRepository) = GetBaristasUseCase(repo)
    @Provides
    @Singleton
    fun provideGetItemsUseCase(repo: ItemsRepository) = GetItemsUseCase(repo)
}