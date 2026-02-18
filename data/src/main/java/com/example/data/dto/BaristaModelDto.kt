package com.example.data.dto

import com.example.domain.model.BaristaModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaristaModelDto(

    val id: String,
    val name: String,
    val descrip: String,
    val statuc: Boolean,
    @SerialName("image_url") val imageUrl: String
)

fun BaristaModelDto.toDomain(): BaristaModel = (
        BaristaModel(
            id = id,
            imageUrl = imageUrl,
            name = name,
            desc = descrip,
            status = statuc
        )
        )
