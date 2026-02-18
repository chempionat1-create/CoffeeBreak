package com.example.champ.qr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.champ.common.TopBar
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.blue3
import io.github.alexzhirkevich.qrose.options.QrBrush
import io.github.alexzhirkevich.qrose.options.QrColors
import io.github.alexzhirkevich.qrose.options.solid
import io.github.alexzhirkevich.qrose.rememberQrCodePainter

@Composable
fun QRScreen(navController: NavController) {
    val bgC = MainTheme.colorScheme.bg
    val qrC = MainTheme.colorScheme.default
    val data = remember {
        "coffee://host/1234"
    }
    val colors = remember {
        QrColors(
            dark = QrBrush.solid(qrC),
            light = QrBrush.solid(bgC)
        )
    }
    val painter = rememberQrCodePainter(data = data, colors = colors)
    Column(modifier = Modifier.fillMaxSize().background(MainTheme.colorScheme.bg).padding(horizontal = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        TopBar(isCart = false, navController, "Профиль")
        Text(
            "Ваш персональный QR-код",
            modifier = Modifier.padding(vertical = 30.dp),
            style = MainTheme.typography.welcomeDesc2.copy(
                fontSize = 20.sp,
                color = MainTheme.colorScheme.iconBack
            )
        )
        Image(
            painter = painter,
            null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(Modifier.height(20.dp))
        Text(
            "Покажите ваш QR-code для получения заказа",
            color = blue3,
            style = MainTheme.typography.authTextField.copy(fontSize = 18.sp)
        )
    }
}