package com.example.domain.usecase.utils

import com.example.domain.repository.SessionRepository

class ExitSessionUseCase(
    private val repo: SessionRepository
) {
    suspend fun execute() = repo.clearSession()
}