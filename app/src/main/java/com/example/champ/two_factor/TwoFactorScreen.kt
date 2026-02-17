package com.example.champ.two_factor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.MyIcon
import com.example.champ.ui.theme.MainTheme

@Composable
fun TwoFactorScreen(navController: NavController, viewModel: TwoFactorViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) {
            navController.navigate(Route.Reset)
        }
    }
    Column(modifier = Modifier.padding(top = 27.dp, start = 30.dp, end = 30.dp)) {
        MyIcon(R.drawable.back) {
            navController.popBackStack()
        }
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            Spacer(Modifier.height(46.dp))
            Text(
                "Проверка",
                style = MainTheme.typography.loginText.copy(
                    fontSize = 22.sp,
                    color = MainTheme.colorScheme.registerLoginText
                )
            )
            Spacer(Modifier.height(24.dp))
            Text(
                "Введите код который мы вам отправили",
                style = MainTheme.typography.loginText.copy(
                    color = MainTheme.colorScheme.loginWelcome
                )
            )
            Spacer(Modifier.height(57.dp))
            BasicTextField(
                value = state.otp,
                onValueChange = { i ->
                    if (i.length <= 4 && i.all { it.isDigit() }) {
                        viewModel.onEvent(TwoFactorEvents.OnDigitEntered(i))
                    }
                    if (i.length == 4) {
                        viewModel.onEvent(TwoFactorEvents.OnEnterEnded)
                    }
                },
                cursorBrush = SolidColor(Color.Transparent),
                textStyle = TextStyle(fontSize = 30.sp),
                decorationBox = { itf ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(22.dp),
                        modifier = Modifier.padding(horizontal = 15.dp)
                    ) {
                        repeat(4) { i ->
                            val chart = state.otp.getOrNull(i) ?: ""
                            val char = chart.toString()
                            Box(
                                modifier = Modifier
//                                    .weight(1f)
                                    .width(30.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .height(61.dp)
                                    .background(
                                        if (char == "") {
                                            MainTheme.colorScheme.otpEmpty
                                        } else {
                                            MainTheme.colorScheme.otp
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(char)
                            }
                            itf()
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

        }
    }
}