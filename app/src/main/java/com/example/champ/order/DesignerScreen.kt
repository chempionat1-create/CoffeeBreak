package com.example.champ.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.MyIcon
import com.example.champ.common.RowItem
import com.example.champ.common.TopBar
import com.example.champ.ui.theme.MainTheme

@Composable
fun DesignerScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainTheme.colorScheme.bg)
            .padding(horizontal = 25.dp)
    ) {
        TopBar(navController = navController, text = stringResource(R.string.cons_maker))
        Spacer(Modifier.height(29.dp))
        RowItem(stringResource(R.string.choose_barista)) {
            MyIcon(R.drawable.next2) {
                navController.navigate(Route.Constructor(1))
            }
        }
        RowItem(stringResource(R.string.sort)) {
            MyIcon(R.drawable.next2) {
                navController.navigate(Route.Constructor(2))
            }
        }
        RowItem(stringResource(R.string.additives)) {
            MyIcon(R.drawable.next2) {
                navController.navigate(Route.Constructor(4))
            }
        }
    }

}