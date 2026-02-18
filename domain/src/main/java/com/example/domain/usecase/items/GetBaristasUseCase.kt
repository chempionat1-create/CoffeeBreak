package com.example.domain.usecase.items

import com.example.domain.repository.ItemsRepository

class GetBaristasUseCase(
    private val repo: ItemsRepository
) {
    suspend fun execute() = repo.getBaristas()
}