package com.example.domain.usecase.utils

import com.example.domain.repository.SessionRepository

class GetSessionUseCase(
    private val repo: SessionRepository
) {
    suspend fun execute() = repo.getSession()
}