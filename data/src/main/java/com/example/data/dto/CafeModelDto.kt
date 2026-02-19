package com.example.data.dto

import com.example.domain.model.CafeModel
import kotlinx.serialization.Serializable
// класс для сериализации/десериализации данных с сервера
@Serializable
data class CafeModelDto(
    val id: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
)
// функция маппирования из слоя data в слой domain


fun CafeModelDto.toDomain(): CafeModel = (
        CafeModel(
            id = id, address = address, latitude = latitude,
            longitude = longitude
        )
        )
