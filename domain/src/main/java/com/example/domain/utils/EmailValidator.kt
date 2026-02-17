package com.example.domain.utils

interface EmailValidator {
    fun validateEmail(email: String): Result<Unit>
}