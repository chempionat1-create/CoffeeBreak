package com.example.data.repository

import android.content.Context
import androidx.core.content.edit
import com.example.domain.repository.SessionRepository

// реализация методов для работы с активной сессией
class SessionRepositoryImpl(
    context: Context
): SessionRepository {
    val prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    override suspend fun getSession(): String? {
        val id = prefs.getString("userId", null)
        return id
    }

    override suspend fun loadSession(id: String) {
        prefs.edit { putString("userId", id) }
    }

    override suspend fun clearSession() {
        prefs.edit { clear() }
    }
}