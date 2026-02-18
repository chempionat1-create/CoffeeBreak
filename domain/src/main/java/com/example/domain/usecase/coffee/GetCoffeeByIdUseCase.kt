package com.example.domain.usecase.coffee

import com.example.domain.repository.CoffeeRepository

class GetCoffeeByIdUseCase(
    private val repo: CoffeeRepository
) {
    suspend fun execute(id: String) = repo.getCoffee(id)
}