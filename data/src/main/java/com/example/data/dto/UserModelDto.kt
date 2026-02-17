package com.example.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.Serial
// класс для сериализации/десериализации данных с сервера
@Serializable
data class UserModelDto(

    val id: String? = null,
    @SerialName("user_id") val userId: String? = null,
    val name: String = "",
    val phone: String = "",
    val address: String? = null,
)