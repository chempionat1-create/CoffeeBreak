package com.example.domain.repository

interface SessionRepository {
    suspend fun getSession(): String?
    suspend fun loadSession(id: String)
    suspend fun clearSession()
}