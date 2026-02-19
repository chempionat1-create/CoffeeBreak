package com.example.data.repository

import com.example.data.dto.BaristaModelDto
import com.example.data.dto.ItemModelDto
import com.example.data.dto.toDomain
import com.example.data.source.InitSupabaseClient.client
import com.example.domain.repository.ItemsRepository
import com.example.domain.model.BaristaModel
import com.example.domain.model.ItemModel
import io.github.jan.supabase.postgrest.postgrest
// реализация методов интерфейса, связанного с элементами и характеристиками заказов: бариста, страны, сорта, добавки
class ItemsRepositoryImpl() : ItemsRepository {
    override suspend fun getBaristas(): Result<List<BaristaModel>> {
        return try {
            val res = client.postgrest["baristas"].select().decodeList<BaristaModelDto>()
                .map { it.toDomain() }
            Result.success(res)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getItems(category: String): Result<List<ItemModel>> {

        return try {
            val res = client.postgrest["items"].select {
                filter {
                    eq("category", category)

                }
            }.decodeList<ItemModelDto>().map { it.toDomain() }
            Result.success(res)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}