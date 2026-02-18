package com.example.domain.usecase.items

import com.example.domain.repository.ItemsRepository

class GetItemsUseCase(
    private val repo: ItemsRepository
) {
    suspend fun execute(category: String) = repo.getItems(category)
}