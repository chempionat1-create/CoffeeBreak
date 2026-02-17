package com.example.domain.usecase.auth

import com.example.domain.model.UserModel
import com.example.domain.repository.AuthRepository

class SignUpUseCase(
    private val repo: AuthRepository
) {
    suspend fun execute(email: String, password: String, user: UserModel) = repo.signUp(email, password, user)
}