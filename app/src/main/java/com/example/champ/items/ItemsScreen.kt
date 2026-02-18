package com.example.champ.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.BottomNav
import com.example.champ.common.TopBar
import com.example.champ.items.pages.AdditivesScreen
import com.example.champ.items.pages.BaristaScreen
import com.example.champ.items.pages.CountryScreen
import com.example.champ.items.pages.SortScreen

@Composable
fun ItemsScreen(navController: NavController, viewModel: ItemsViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Box() {

        Column(modifier = Modifier.padding(horizontal = 25.dp)) {

            TopBar(isCart = true, navController, stringResource(R.string.constructor))
            when (state.page) {
                1 -> {
                    BaristaScreen(navController, viewModel)
                }

                2 -> {
                    CountryScreen(navController, viewModel)

                }

                3 -> {
                    SortScreen(navController, viewModel)
                }

                else -> {
                    AdditivesScreen(navController, viewModel)

                }
            }
        }
        BottomNav(navController, Route.Menu, modifier = Modifier.align(Alignment.BottomCenter))
    }
}