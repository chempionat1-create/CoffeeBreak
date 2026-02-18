package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.gray2

data class CusIcon(
    val route: Route,
    val icon: Int
)

val icons = listOf(
    CusIcon(
        Route.Menu, R.drawable.address,
    ),
    CusIcon(
        Route.Reward, R.drawable.reward,
    ),
    CusIcon(
        Route.MyOrder, R.drawable.cart,
    )
)

@Composable
fun BottomNav(navController: NavController, currentRoute: Route, modifier: Modifier = Modifier) {
    Box(modifier = modifier.padding(start = 25.dp, end = 25.dp, bottom = 22.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .background(MainTheme.colorScheme.cafeBg)
                .padding(vertical = 21.dp)

        ) {
            repeat(icons.count()) {
                MyIcon(
                    icons[it].icon, tintColor = if (icons[it].route == currentRoute) {
                        MainTheme.colorScheme.navActiveIcon
                    } else {
                        gray2
                    }
                ) {
                    if (currentRoute != icons[it].route) {
                        navController.navigate(icons[it].route)
                    }
                }
            }
        }
    }
}
