package com.example.domain.model

data class UserModel(
    val id: String? = null,
    val userId: String? = null,
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val address: String? = null,
)
