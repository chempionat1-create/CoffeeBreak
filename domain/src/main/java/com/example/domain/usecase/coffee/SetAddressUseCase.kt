package com.example.domain.usecase.coffee

import com.example.domain.repository.CoffeeRepository

class SetAddressUseCase(
    private val repo: CoffeeRepository
) {
    suspend fun execute(address: String) = repo.setAddress(address)
}