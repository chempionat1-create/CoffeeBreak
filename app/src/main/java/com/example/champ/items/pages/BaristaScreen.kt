package com.example.champ.items.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.common.BaristaItem
import com.example.champ.items.ItemsViewModel
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.darkBlue
import com.example.domain.model.BaristaModel

@Composable
fun BaristaScreen(navController: NavController, viewModel: ItemsViewModel) {
    val state = viewModel.state.value
    Text(
        stringResource(R.string.choose_barista),
        style = MainTheme.typography.loginText, color = darkBlue,
        modifier = Modifier.padding(top = 28.dp, bottom = 17.dp)
    )
    if (state.isLoading) {
        Text("Downloading", color = MainTheme.colorScheme.default)
    } else {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            val barista = state.baristas[0]
            items(3) { i ->
                BaristaItem(barista.imageUrl, barista.name, barista.desc, barista.status) {
                    navController.popBackStack()
                }
            }
        }
    }
}