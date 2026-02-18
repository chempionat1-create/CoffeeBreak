package com.example.data.repository

import com.example.data.dto.UserModelDto
import com.example.data.source.InitSupabaseClient.client
import com.example.domain.model.UserModel
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.SessionRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest

// реализация методов интерфейса, связанного с аутентификацией (регистрация, авторищация)
class AuthRepositoryImpl(
    private val sessionRepository: SessionRepository
) : AuthRepository {
    override suspend fun signIn(
        email: String,
        password: String
    ): Result<Unit> {
        return try {
            val res = client.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }

            sessionRepository.loadSession(client.auth.currentUserOrNull()!!.id)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUp(
        email: String,
        password: String,
        user: UserModel
    ): Result<Unit> {
        return try {
            val res = client.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }?.let {
                val res2 = client.postgrest["users"].insert(
                    UserModelDto(
                        userId = it.id,
                        name = user.name, phone = user.phone, email = email

                    )
                )
                sessionRepository.loadSession(it.id)
            }

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}