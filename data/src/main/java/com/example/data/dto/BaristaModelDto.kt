package com.example.data.dto

import com.example.domain.model.BaristaModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// класс для сериализации/десериализации данных с сервера
@Serializable
data class BaristaModelDto(

    val id: String,
    val name: String,
    val descrip: String,
    val statuc: Boolean,
    @SerialName("image_url") val imageUrl: String
)
// функция маппирования из слоя data в слой domain

fun BaristaModelDto.toDomain(): BaristaModel = (
        BaristaModel(
            id = id,
            imageUrl = imageUrl,
            name = name,
            desc = descrip,
            status = statuc
        )
        )
