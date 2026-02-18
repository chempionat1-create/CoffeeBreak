package com.example.champ.items

import com.example.domain.model.BaristaModel
import com.example.domain.model.ItemModel

data class ItemsState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val page: Int = 1,
    val baristas: List<BaristaModel> = emptyList(),
    val countries: List<ItemModel> = emptyList(),
    val sorts: List<ItemModel> = emptyList(),
    val additives: List<ItemModel> = emptyList(),
)