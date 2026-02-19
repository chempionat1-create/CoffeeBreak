package com.example.data.source

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.compose.auth.ComposeAuth
import io.github.jan.supabase.compose.auth.googleNativeLogin
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.storage.Storage
// инициализация supabase client, подключение плагинов
object InitSupabaseClient {
    val client = createSupabaseClient("https://ytizrftfmlltuhekqnzg.supabase.co", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inl0aXpyZnRmbWxsdHVoZWtxbnpnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzEzMDcxMDgsImV4cCI6MjA4Njg4MzEwOH0.U6lt5yFozsOLEDz67LtHcONgKznR8-YS1OqOa-p873s"){
        install(Auth)
        install(Postgrest)
        install(Realtime)
        install(Storage)
        install(ComposeAuth) {
            googleNativeLogin("640921715885-mnv37l5be5b8n7643p0r1ulhj2tpk9jo.apps.googleusercontent.com")
        }
    }
} //Champ3OKEI123
