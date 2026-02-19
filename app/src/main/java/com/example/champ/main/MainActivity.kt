package com.example.champ.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.champ.Route
import com.example.champ.cafemap.CafeMapScreen
import com.example.champ.forgot.ForgotScreen
import com.example.champ.items.ItemsScreen
import com.example.champ.login.LoginScreen
import com.example.champ.menu.MenuScreen
import com.example.champ.my_order.MyOrderScreen
import com.example.champ.my_order_current.MyOrderCurrentScreen
import com.example.champ.my_order_history.MyOrderHistoryScreen
import com.example.champ.order.DesignerScreen
import com.example.champ.order.OrderOptionsScreen
import com.example.champ.placed.PlacedScreen
import com.example.champ.profile.ProfileScreen
import com.example.champ.qr.QRScreen
import com.example.champ.reset.ResetScreen
import com.example.champ.reward.RewardScreen
import com.example.champ.signup.SignUpScreen
import com.example.champ.startup.StartUpScreen
import com.example.champ.two_factor.TwoFactorScreen
import com.example.champ.ui.theme.CoffeeBreakTheme
import com.example.champ.ui.theme.MainTheme
import com.example.champ.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MainViewModel by viewModels()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isAuth = viewModel.isAuth.collectAsState().value
            val navController = rememberNavController()
            Surface(modifier = Modifier.fillMaxSize(), color = MainTheme.colorScheme.bg) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = Color.Companion.Transparent
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        CoffeeBreakTheme {
                            NavHost(
                                navController = navController,
                                startDestination =
                                    if (isAuth) {
                                        Route.Menu()
                                    } else {
                                        Route.Login
                                    }
                            ) {
                                composable<Route.Welcome> {
                                    WelcomeScreen(navController)
                                }
                                composable<Route.Login> {
                                    LoginScreen(navController)
                                }
                                composable<Route.SignUp> {
                                    SignUpScreen(navController)
                                }
                                composable<Route.StartUp> {
                                    StartUpScreen(navController)
                                }
                                composable<Route.CafeMap> {
                                    CafeMapScreen(navController)
                                }
                                composable<Route.Forgot> {
                                    ForgotScreen(navController)
                                }
                                composable<Route.TwoFactor> {
                                    TwoFactorScreen(navController)
                                }
                                composable<Route.Reset> {
                                    ResetScreen(navController)
                                }
                                composable<Route.Profile> {
                                    ProfileScreen(navController)
                                }
                                composable<Route.Menu> {
                                    MenuScreen(navController)
                                }
                                composable<Route.Reward> {
                                    RewardScreen(navController)
                                }
                                composable<Route.MyOrder> {
                                    MyOrderScreen(navController)
                                }
                                composable<Route.OrderOptions> {
                                    OrderOptionsScreen(navController)
                                }
                                composable<Route.QR> {
                                    QRScreen(navController)
                                }
                                composable<Route.Designer> {
                                    DesignerScreen(navController)
                                }
                                composable<Route.Constructor> {
                                    ItemsScreen(navController)
                                }
                                composable<Route.Placed> {
                                    PlacedScreen(navController)
                                }
                                composable<Route.MyOrderCurrent> {
                                    MyOrderCurrentScreen(navController)
                                }
                                composable<Route.MyOrderHistory> {
                                    MyOrderHistoryScreen(navController)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}