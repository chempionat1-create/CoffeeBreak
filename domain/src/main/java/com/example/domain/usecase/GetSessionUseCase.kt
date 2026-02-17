package com.example.domain.usecase

import com.example.domain.repository.SessionRepository

class GetSessionUseCase(
    private val repo: SessionRepository
) {
    suspend fun execute() = repo.getSession()
}