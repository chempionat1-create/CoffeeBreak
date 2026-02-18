package com.example.data.dto

import com.example.domain.model.ItemModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemModelDto(

    val id: String,
    @SerialName("image_url") val imageUrl: String,
    val title: String,
    val descrip: String
)
fun ItemModelDto.toDomain(): ItemModel = (
        ItemModel(
            id = id,
            title = title,
            desc =  descrip,
            imageUrl = imageUrl
        )
        )