package com.example.domain.usecase.auth

class PasswordUseCase(
) {
    fun execute(password: String): Result<Unit> {
        if (password.length < 8) {
            return Result.failure(Exception("Пароль должен быть не менее 8 символов"))
        } else if (!password.any { it.isDigit() }) {
            return Result.failure(Exception("Пароль должен содержать цифры"))
        } else if (!password.any { it.isLetter() }) {
            return Result.failure(Exception("Пароль должен содержать буквы"))
        } else if (!password.any { it.isLowerCase() }) {
            return Result.failure(Exception("Пароль должен содержать маленькие буквы"))
        } else if (!password.any { it.isUpperCase() }) {
            return Result.failure(Exception("Пароль должен содержать большие буквы"))
        } else if (password.all { it.isLetterOrDigit() }) {
            return Result.failure(Exception("Пароль должен содержать специальные символы"))
        }
        return Result.success(Unit)
    }
}