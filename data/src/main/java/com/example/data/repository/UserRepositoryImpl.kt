package com.example.data.repository

import com.example.data.dto.UserModelDto
import com.example.data.dto.toDomain
import com.example.data.source.InitSupabaseClient.client
import com.example.domain.model.UserModel
import com.example.domain.repository.UserRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest

// реализация методов интерфейса для работы с информацией о пользователях
class UserRepositoryImpl(): UserRepository {
    override suspend fun getUser(): Result<UserModel> {
        val userId = client.auth.currentUserOrNull()?.id?: return Result.failure(Exception("No user"))
        return try {
            val res = client.postgrest["users"].select {
                filter {
                    eq("user_id", userId)
                }
            }.decodeSingle<UserModelDto>().toDomain()
            Result.success(res)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}