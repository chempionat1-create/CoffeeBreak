package com.example.data.repository

import com.example.data.dto.CafeModelDto
import com.example.data.dto.toDomain
import com.example.data.source.InitSupabaseClient.client
import com.example.domain.model.CafeModel
import com.example.domain.repository.CoffeeRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.serialization.json.buildJsonObject
import org.slf4j.MDC.put

class CoffeeRepositoryImpl(): CoffeeRepository {
    override suspend fun getCafes(): Result<List<CafeModel>> {
        return try {
            val res = client.postgrest["cafes"].select().decodeList<CafeModelDto>().map { it.toDomain() }
            Result.success(res)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun setAddress(address: String): Result<Unit> {
        val userId = client.auth.currentUserOrNull()?.id?: return Result.failure(Exception("No such user found"))
        return try {
            val res = client.postgrest["users"].update(
                {
                    buildJsonObject {
                        put("address", address)
                    }
                }
            )
            {
                filter {
                    eq("user_id", userId)
                }
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}