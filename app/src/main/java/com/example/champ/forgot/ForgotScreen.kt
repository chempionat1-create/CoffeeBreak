package com.example.champ.forgot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.AuthTextField
import com.example.champ.common.MyFAB
import com.example.champ.common.MyIcon
import com.example.champ.ui.theme.MainTheme

@Composable
fun ForgotScreen(navController: NavController, viewModel: ForgotViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Column(modifier = Modifier.padding(top = 27.dp, start = 30.dp)) {
        MyIcon(R.drawable.back) {
            navController.popBackStack()
        }
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            Spacer(Modifier.height(46.dp))
            Text(
                "Забыли пароль?",
                style = MainTheme.typography.loginText.copy(
                    fontSize = 22.sp,
                    color = MainTheme.colorScheme.registerLoginText
                )
            )
            Spacer(Modifier.height(24.dp))
            Text("Введите адрес электронной почты",
                style = MainTheme.typography.loginText.copy(
                    color = MainTheme.colorScheme.loginWelcome
                ))
            Spacer(Modifier.height(57.dp))
            AuthTextField(
                state.email,
                { viewModel.onEvent(ForgotEvents.OnEmailChange(it)) },
                placeholder = "Адрес электронной почты",
                icon = R.drawable.email_icon
            )
            Spacer(Modifier.weight(1f))
            Row {
                Spacer(Modifier.weight(1f))
                MyFAB {
                    navController.navigate(Route.TwoFactor)
                }
            }
            Spacer(Modifier.weight(2f))
        }
    }
}