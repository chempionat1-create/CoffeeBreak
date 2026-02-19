package com.example.champ.placed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.MyIcon
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.dark
import com.example.champ.ui.theme.darkBlue
import com.example.champ.ui.theme.gray1

@Composable
fun PlacedScreen(navController: NavController, viewModel: PlacedViewModel = hiltViewModel()) {
    val time = viewModel.time.collectAsState().value
    LaunchedEffect(time) {
        if (time) navController.navigate(Route.Menu(true))
    }
    Box(
        modifier = Modifier
            .padding(horizontal = 25.dp, vertical = 21.dp)
            .fillMaxSize()
    ) {
        MyIcon(
            R.drawable.back,
            tintColor = Color.Black,
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            navController.navigate(Route.Menu(true))
        }
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyIcon(R.drawable.placed, tintColor = darkBlue)
            Spacer(Modifier.height(32.dp))
            Column(verticalArrangement = Arrangement.spacedBy(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    stringResource(R.string.placed),
                    style = MainTheme.typography.loginText,
                    fontSize = 22.sp,
                    color = dark
                )
                Text(
                    "Алексей, Ваш заказ N 002 успешно размещен.",
                    textAlign = TextAlign.Center,
                    style = MainTheme.typography.loginText,
                    color = gray1
                )
                Text(
                    "Заказ будет готов сегодня\n" +
                            "к 18:10 по адресу \n" +
                            "г. Оренбург, ул. Чкалова 32",
                    textAlign = TextAlign.Center,
                    style = MainTheme.typography.loginText,
                    color = Color.Black
                )
                Text(
                    stringResource(R.string.take_qr),
                    textAlign = TextAlign.Center,
                    style = MainTheme.typography.loginText,
                    color = gray1
                )
            }
        }
    }
}