package com.example.champ.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.ui.theme.MainTheme

@Composable
fun TopBar(isCart: Boolean = true, navController: NavController, text: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(top = 21.dp)
            .fillMaxWidth()
    ) {
        MyIcon(R.drawable.back, tintColor = MainTheme.colorScheme.iconBack) {
            navController.popBackStack()
        }
        Text(
            text,
            style = MainTheme.typography.authTextField.copy(
                fontSize = 18.sp,
                color = MainTheme.colorScheme.topBarText
            )
        )
        MyIcon(
            R.drawable.cart, tintColor = if (isCart) {
                MainTheme.colorScheme.iconBack
            } else {
                Color.Transparent
            }
        ) {
            navController.navigate(Route.MyOrder)
        }
    }
}