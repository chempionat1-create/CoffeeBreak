package com.example.champ.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.BottomNav
import com.example.champ.common.MyAsync
import com.example.champ.common.MyDialog
import com.example.champ.common.MyIcon
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bgW

@Composable
fun MenuScreen(navController: NavController, viewModel: MenuViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Box() {
        Column(modifier = Modifier.background(MainTheme.colorScheme.bg)) {
            Spacer(Modifier.height(27.dp))
            Row(modifier = Modifier.padding(horizontal = 30.dp)) {
                Column {
                    Text("Добро пожаловать!")
                    if (!state.isLoading) {
                        Text(state.name)
                    }
                }
                Spacer(Modifier.weight(1f))

                MyIcon(R.drawable.cart) {
                    navController.navigate(Route.MyOrder)

                }
                Spacer(Modifier.width(20.dp))
                MyIcon(R.drawable.profile) {
                    navController.navigate(Route.Profile)
                }
            }
            Spacer(Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MainTheme.colorScheme.menuBg)
            ) {
                Column(modifier = Modifier.padding(horizontal = 25.dp)) {
                    Text(
                        "Выберите ваш кофе",
                        modifier = Modifier.padding(top = 16.dp, bottom = 29.dp)
                    )
                    if (state.isLoading) {
                        Text("Downloading", color = MainTheme.colorScheme.default)
                        Spacer(Modifier.weight(1f))

                    } else {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(17.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(state.coffees) { i ->

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(15.dp))
                                        .background(bgW)
                                        .padding(7.dp)
                                        .clickable {
                                            navController.navigate(Route.OrderOptions(i.id))
                                        },
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    MyAsync(
                                        i.imageUrl,
                                        modifier = Modifier.heightIn(max = 85.dp),
                                        contentScale = ContentScale.FillHeight
                                    )
                                    Spacer(Modifier.height(12.dp))
                                    Text(i.title)
                                    Text(
                                        "${i.coast}₽",
                                        modifier = Modifier.align(Alignment.End)
                                    )
                                }

                            }
                        }
                        Spacer(Modifier.weight(1f))
                    }
                }

            }
        }
        BottomNav(navController, Route.Menu, modifier = Modifier.align(Alignment.BottomCenter))
    }
    MyDialog(state.isError, state.error) {
        viewModel.onEvent(MenuEvents.OnCloseDialog)
    }
}