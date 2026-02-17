package com.example.domain.usecase.auth

import com.example.domain.repository.AuthRepository

class SignInUseCase(
    private val repo: AuthRepository
) {
    suspend fun execute(email: String,
                        password: String) = repo.signIn(email, password)
}