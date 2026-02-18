package com.example.domain.usecase.coffee

import com.example.domain.repository.CoffeeRepository

class GetCoffeesUseCase(
    private val repo: CoffeeRepository
) {
    suspend fun execute() = repo.getCoffees()
}