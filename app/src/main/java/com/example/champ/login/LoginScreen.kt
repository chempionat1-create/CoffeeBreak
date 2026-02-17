package com.example.champ.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.AuthTextField
import com.example.champ.common.MyFAB
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.gray1
import com.example.data.source.InitSupabaseClient.client
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.compose.auth.composable.GoogleDialogType
import io.github.jan.supabase.compose.auth.composable.NativeSignInResult
import io.github.jan.supabase.compose.auth.composable.rememberSignInWithGoogle
import io.github.jan.supabase.compose.auth.composeAuth

val icons = listOf(
    R.drawable.yandex, R.drawable.google, R.drawable.vk

)

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess ) {
            navController.navigate(Route.StartUp)
        }
    }

    val res = client.composeAuth.rememberSignInWithGoogle(
        type = GoogleDialogType.BOTTOM_SHEET,
        onResult = { i ->
            when (i) {
                NativeSignInResult.ClosedByUser -> {
                    Log.e("Google auth", "LoginScreen: Closed by user")
                }

                is NativeSignInResult.Error -> {
                    Log.e("Google auth", "LoginScreen: Error")

                }

                is NativeSignInResult.NetworkError -> {
                    Log.e("Google auth", "LoginScreen: Net error")

                }

                NativeSignInResult.Success -> {
                    Log.e("Google auth", "LoginScreen: Success!!!")

                }
            }
        }
    ) { }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 41.dp)
    ) {
        Spacer(Modifier.height(91.dp))
        Text(
            "Войти",
            style = MainTheme.typography.loginText.copy(
                fontSize = 22.sp,
                color = MainTheme.colorScheme.registerLoginText
            )
        )
        Spacer(Modifier.height(24.dp))
        Text("Добро пожаловать",
            style = MainTheme.typography.loginText.copy(
                color = MainTheme.colorScheme.loginWelcome
            ))
        Spacer(Modifier.height(57.dp))
        AuthTextField(
            state.email,
            { viewModel.onEvent(LoginEvents.OnEmailChange(it)) },
            placeholder = "Адрес электронной почты",
            icon = R.drawable.email_icon
        )
        Spacer(Modifier.height(36.dp))
        AuthTextField(
            state.password,
            { viewModel.onEvent(LoginEvents.OnPasswordChange(it)) },
            placeholder = "Пароль",
            icon = R.drawable.password_screen,
            isPassword = true
        )
        Spacer(Modifier.height(27.dp))
        Text(
            "Забыли пароль?",
            modifier = Modifier.align(Alignment.CenterHorizontally).clickable{
                navController.navigate(Route.Forgot)
            },
            style = MainTheme.typography.loginText,
            color = MainTheme.colorScheme.forgotPasText
        )
        Spacer(Modifier.weight(1f))
        Row {
            Spacer(Modifier.weight(1f))
            MyFAB {
//                viewModel.onEvent(LoginEvents.OnNextClick)
                navController.navigate(Route.CafeMap)
            }
        }
        Text(
            "Войти с помощью",
            modifier = Modifier
                .padding(vertical = 20.dp)
                .align(Alignment.CenterHorizontally),
            style = MainTheme.typography.loginText,
            color = MainTheme.colorScheme.default
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            repeat(3) { i ->
                Image(
                    painter = painterResource(icons[i]),
                    null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(42.dp)
                        .clickable {
                            if (i == 1) {
                                res.startFlow()
                            }
                        }
                )
            }
        }
        Spacer(Modifier.height(36.dp))
        Row {
            Text("Впервые? ", style = MainTheme.typography.loginText, color = gray1)
            Text(
                "Зарегистрироваться",
                style = MainTheme.typography.loginText,
                color = MainTheme.colorScheme.registerLoginText,
                modifier = Modifier.clickable {
                    navController.navigate(Route.SignUp)
                })
        }
        Spacer(Modifier.weight(0.6f))
    }
}