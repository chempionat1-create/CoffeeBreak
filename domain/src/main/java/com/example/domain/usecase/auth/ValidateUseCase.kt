package com.example.domain.usecase.auth

class ValidateUseCase(
    private val emailUseCase: EmailUseCase,
    private val passwordUseCase: PasswordUseCase
) {
    suspend fun execute(
        email: String,
        password: String
    ): Result<Unit> {
        val uc1 = emailUseCase.execute(email)
        if (uc1.isFailure) {
            return uc1
        }
        val uc2 = passwordUseCase.execute(password)
        if (uc2.isFailure) {
            return uc2
        }
        return Result.success(Unit)
    }
}