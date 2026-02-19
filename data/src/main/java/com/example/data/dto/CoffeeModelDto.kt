package com.example.data.dto

import com.example.domain.model.CoffeeModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
// класс для сериализации/десериализации данных с сервера
@Serializable
data class CoffeeModelDto(
    val id: String,
    val title: String,
    @SerialName("image_url") val imageUrl: String,
    val coast: Int
)
// функция маппирования из слоя data в слой domain

fun CoffeeModelDto.toDomain(): CoffeeModel = (
        CoffeeModel(
            id = id,
            title = title,
            imageUrl = imageUrl,
            coast = coast

        )
        )
