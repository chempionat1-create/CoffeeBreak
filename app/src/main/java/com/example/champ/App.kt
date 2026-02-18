package com.example.champ

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("08523f95-af7a-4a15-89a9-10da32ccbb54")
        MapKitFactory.initialize(this)
    }
}