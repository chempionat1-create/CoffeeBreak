package com.example.champ.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bgW
import com.example.champ.ui.theme.gray1
import com.example.champ.ui.theme.green1

@Composable
fun WelcomeScreen(navController: NavController, viewModel: WelcomeViewModel = hiltViewModel()) {
    val isTimeOut = viewModel.isTimeOut.collectAsState().value
    LaunchedEffect(isTimeOut) {
        if (isTimeOut) {
            navController.navigate(Route.Login)
        }
    }
    Column {
        Spacer(Modifier.weight(1f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(green1),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(63.dp))
            Image(
                painter = painterResource(R.drawable.cup_welcome),
                null,
                modifier = Modifier.height(98.dp),
                contentScale = ContentScale.FillHeight
            )
            Spacer(Modifier.height(54.dp))
            Text(
                stringResource(R.string.welcome),
                style = MainTheme.typography.welcome,
                color = bgW
            )
            Spacer(Modifier.height(46.dp))
        }
        Spacer(Modifier.height(25.dp))
        Row {
            Spacer(Modifier.weight(1f))
            Column(
                modifier = Modifier.weight(3.5f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Почувствуй себя бариста!",
                    color = MainTheme.colorScheme.welcomeDesc,
                    style = MainTheme.typography.welcomeDesc,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    "Любой кофе под ваш заказ",
                    color = gray1,
                    style = MainTheme.typography.welcomeDesc2,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(Modifier.weight(1f))
        }
        Spacer(Modifier.weight(4f))
    }
}