package com.example.champ.items.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.ItemCard
import com.example.champ.common.MyAsync
import com.example.champ.items.ItemsViewModel
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bg
import com.example.champ.ui.theme.darkBlue

@Composable
fun CountryScreen(navController: NavController, viewModel: ItemsViewModel) {
    val state = viewModel.state.value
    Text(
        stringResource(R.string.choose_country),
        style = MainTheme.typography.loginText, color = darkBlue,
        modifier = Modifier.padding(top = 28.dp, bottom = 17.dp)
    )

    if (state.isLoading) {
        Text("Downloading", color = MainTheme.colorScheme.default)
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(27.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            val i = state.countries[0]
            items(10) {
                ItemCard(i.imageUrl, i.title, i.desc) {
                    navController.navigate(Route.Constructor(3))
                }
            }
        }
        Spacer(Modifier.height(80.dp))
    }
}