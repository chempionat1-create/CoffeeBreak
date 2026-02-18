package com.example.champ.profile

data class ProfileState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val items: List<Item> = emptyList()
)

data class Item(
    val icon: Int,
    val title: String,
    val text: String,
    val endIcon: Int,
)