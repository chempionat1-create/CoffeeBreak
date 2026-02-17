package com.example.domain.usecase.coffee

import com.example.domain.repository.CoffeeRepository

class GetCafesUseCase(
    private val repo: CoffeeRepository
) {
    suspend fun execute() = repo.getCafes()
}