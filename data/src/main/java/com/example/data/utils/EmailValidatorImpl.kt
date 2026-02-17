package com.example.data.utils

import android.util.Patterns
import com.example.domain.utils.EmailValidator
import org.intellij.lang.annotations.Pattern

class EmailValidatorImpl(): EmailValidator {
    override fun validateEmail(email: String): Result<Unit> {
        val res = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        return if (res) {
            Result.success(Unit)
        } else {
            Result.failure(Exception("Введите корректный email"))
        }
    }
}