package com.example.domain.repository

import com.example.domain.model.CafeModel

interface CoffeeRepository {
    suspend fun getCafes(): Result<List<CafeModel>>
    suspend fun setAddress(address: String): Result<Unit>
}