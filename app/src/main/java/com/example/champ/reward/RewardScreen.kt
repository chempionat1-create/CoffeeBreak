package com.example.champ.reward

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.champ.Route
import com.example.champ.common.BottomNav
import com.example.champ.common.LoyaltyCard
import com.example.champ.common.PointsCard
import com.example.champ.ui.theme.MainTheme

@Composable
fun RewardScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MainTheme.colorScheme.bg)
                .padding(horizontal = 25.dp)
        ) {
            Spacer(Modifier.height(21.dp))
            Text("Вознаграждение", modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(Modifier.height(31.dp))
            LoyaltyCard(4)
            Spacer(Modifier.height(24.dp))
            PointsCard()
        }
        BottomNav(navController, Route.Reward, modifier = Modifier.align(Alignment.BottomCenter))

    }

}