package com.example.champ.reset

data class ResetState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val password: String = "",
)