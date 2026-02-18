package com.example.data.dto

import com.example.domain.model.CoffeeModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoffeeModelDto(
    val id: String,
    val title: String,
    @SerialName("image_url") val imageUrl: String,
    val coast: Int
)

fun CoffeeModelDto.toDomain(): CoffeeModel = (
        CoffeeModel(
            id = id,
            title = title,
            imageUrl = imageUrl,
            coast = coast

        )
        )
