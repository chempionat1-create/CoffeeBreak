package com.example.champ.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.champ.Route
import com.example.champ.login.LoginScreen
import com.example.champ.ui.theme.ChampTheme
import com.example.champ.ui.theme.CoffeeBreakTheme
import com.example.champ.ui.theme.MainTheme
import com.example.champ.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MainTheme.colorScheme.bg)
            ) { innerPadding ->
                Surface(modifier = Modifier.padding(innerPadding)) {
                    CoffeeBreakTheme {
                        NavHost(navController = navController, startDestination = Route.Welcome) {
                            composable<Route.Welcome> {
                                WelcomeScreen(navController)
                            }
                            composable<Route.Login> {
                                LoginScreen(navController)
                            }
                        }
                    }
                }
            }
        }
    }
}