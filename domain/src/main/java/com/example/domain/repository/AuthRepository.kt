package com.example.domain.repository

import com.example.domain.model.UserModel

interface AuthRepository {
    suspend fun signIn(email: String,
                       password: String): Result<Unit>
    suspend fun signUp(email: String,
                       password: String, user: UserModel): Result<Unit>
}