package com.example.domain.repository

import com.example.domain.model.CafeModel
import com.example.domain.model.CoffeeModel

interface CoffeeRepository {
    suspend fun getCafes(): Result<List<CafeModel>>
    suspend fun getCoffees(): Result<List<CoffeeModel>>
    suspend fun setAddress(address: String): Result<Unit>
    suspend fun getCoffee(id: String): Result<CoffeeModel>
}