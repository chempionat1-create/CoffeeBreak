package com.example.domain.usecase.user

import com.example.domain.repository.UserRepository

class GetUserUseCase(
    private val repo: UserRepository
) {
    suspend fun execute() = repo.getUser()
}