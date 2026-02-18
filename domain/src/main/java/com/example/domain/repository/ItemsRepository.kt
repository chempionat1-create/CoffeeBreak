package com.example.domain.repository

import com.example.domain.model.BaristaModel
import com.example.domain.model.ItemModel

interface ItemsRepository {
    suspend fun getBaristas(): Result<List<BaristaModel>>
    suspend fun getItems(category: String): Result<List<ItemModel>>
}