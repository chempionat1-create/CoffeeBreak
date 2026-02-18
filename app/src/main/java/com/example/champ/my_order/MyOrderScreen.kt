package com.example.champ.my_order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.champ.Route
import com.example.champ.common.BottomNav
import com.example.champ.ui.theme.MainTheme

@Composable
fun MyOrderScreen(navController: NavController) {
    Box() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(MainTheme.colorScheme.bg)) { }
        BottomNav(navController, Route.MyOrder, modifier = Modifier.align(Alignment.BottomCenter))

    }
}