package com.example.domain.usecase.auth

import com.example.domain.utils.EmailValidator

class EmailUseCase(private val repo: EmailValidator) {
        suspend fun execute(email: String) = repo.validateEmail(email)
}