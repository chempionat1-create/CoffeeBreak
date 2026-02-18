package com.example.di

import com.example.data.repository.CoffeeRepositoryImpl
import com.example.domain.repository.CoffeeRepository
import com.example.domain.usecase.coffee.GetCafesUseCase
import com.example.domain.usecase.coffee.GetCoffeeByIdUseCase
import com.example.domain.usecase.coffee.GetCoffeesUseCase
import com.example.domain.usecase.coffee.SetAddressUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoffeeModule {
    @Provides
    @Singleton
    fun provideCoffeeRepository(): CoffeeRepository = CoffeeRepositoryImpl()

    @Provides
    @Singleton
    fun provideGetCafesUseCase(repo: CoffeeRepository) = GetCafesUseCase(repo)
    @Provides
    @Singleton
    fun provideSetAddressUseCase(repo: CoffeeRepository) = SetAddressUseCase(repo)
    @Provides
    @Singleton
    fun provideGetCoffeesUseCase(repo: CoffeeRepository) = GetCoffeesUseCase(repo)
    @Provides
    @Singleton
    fun provideGetCoffeeUseCase(repo: CoffeeRepository) = GetCoffeeByIdUseCase(repo)
}