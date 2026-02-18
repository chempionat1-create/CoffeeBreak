package com.example.champ.order

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.MyAsync
import com.example.champ.common.MyIcon
import com.example.champ.common.RowItem
import com.example.champ.common.Toggle
import com.example.champ.common.TopBar
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.blue3
import com.example.champ.ui.theme.gray2
import com.example.champ.ui.theme.green2

@Composable
fun OrderOptionsScreen(
    navController: NavController,
    viewModel: OrderOptionsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainTheme.colorScheme.bg)
            .padding(horizontal = 25.dp)
    ) {
        TopBar(navController = navController, text = "Заказ")
        Spacer(Modifier.height(24.dp))
        if (state.isLoading) {
            Text("Downloading")
        } else {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MainTheme.colorScheme.orderBox)
            ) {
                MyAsync(state.coffee!!.imageUrl, modifier = Modifier.align(Alignment.Center))
            }
            RowItem(state.coffee!!.title) {
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.2.dp, color = MainTheme.colorScheme.orderRoundedBox,
                            shape = RoundedCornerShape(50.dp)
                        )

                ) {
                    Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)) {
                        Text(
                            "-",
                            style = MainTheme.typography.welcomeDesc2.copy(fontSize = 12.sp),
                            color = MainTheme.colorScheme.icon,
                            modifier = Modifier.clickable{
                                viewModel.onEvent(OrderOptionsEvents.OnCountChange("-"))
                            }
                        )
                        Text(
                            "${state.count}", modifier = Modifier.padding(horizontal = 16.dp),
                            style = MainTheme.typography.welcomeDesc2.copy(fontSize = 12.sp),
                            color = MainTheme.colorScheme.icon,
                        )
                        Text(
                            "+",
                            style = MainTheme.typography.welcomeDesc2.copy(fontSize = 12.sp),
                            color = MainTheme.colorScheme.icon,
                            modifier = Modifier.clickable{
                                viewModel.onEvent(OrderOptionsEvents.OnCountChange("+"))
                            }
                        )
                    }
                }
            }
            RowItem("Ристретто") {
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.2.dp, color = if (state.ris == 1) {
                                MainTheme.colorScheme.orderRound
                            } else {
                                MainTheme.colorScheme.orderRoundedBox
                            },
                            shape = RoundedCornerShape(50.dp)
                        )
                        .clickable {
                            viewModel.onEvent(OrderOptionsEvents.OnRisChange(1))
                        }
                ) {
                    Text(
                        "Один",
                        style = MainTheme.typography.welcomeDesc2.copy(fontSize = 12.sp),
                        color = MainTheme.colorScheme.icon,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
                    )
                }
                Spacer(Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.2.dp, color = if (state.ris == 2) {
                                MainTheme.colorScheme.orderRound
                            } else {
                                MainTheme.colorScheme.orderRoundedBox
                            },
                            shape = RoundedCornerShape(50.dp)
                        )
                        .clickable {
                            viewModel.onEvent(OrderOptionsEvents.OnRisChange(2))
                        }
                ) {
                    Text(
                        "Два",
                        style = MainTheme.typography.welcomeDesc2.copy(fontSize = 12.sp),
                        color = MainTheme.colorScheme.icon,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)

                    )

                }
            }
            RowItem("На месте / навынос") {
                MyIcon(
                    R.drawable.place, tintColor = if (state.pickup == 1) {
                        MainTheme.colorScheme.iconBack
                    } else {
                        gray2
                    }
                ) {
                    viewModel.onEvent(OrderOptionsEvents.OnPickupChange(1))
                }
                Spacer(Modifier.width(31.dp))

                MyIcon(
                    R.drawable.takeaway, tintColor = if (state.pickup == 2) {
                        MainTheme.colorScheme.iconBack
                    } else {
                        gray2
                    }
                ) {
                    viewModel.onEvent(OrderOptionsEvents.OnPickupChange(2))
                }
            }
            RowItem("Объем, мл") {
                Row(verticalAlignment = Alignment.Bottom) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        MyIcon(
                            R.drawable.cup_large, tintColor = if (state.volume == 1) {
                                MainTheme.colorScheme.iconBack
                            } else {
                                gray2
                            }
                        ) {
                            viewModel.onEvent(OrderOptionsEvents.OnVolumeChange(1))
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "250", style = MainTheme.typography.dmMedium,
                            color = if (state.volume == 1) {
                                MainTheme.colorScheme.iconBack
                            } else {
                                gray2
                            }
                        )
                    }
                    Spacer(Modifier.width(21.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        MyIcon(
                            R.drawable.cup_medium, tintColor = if (state.volume == 2) {
                                MainTheme.colorScheme.iconBack
                            } else {
                                gray2
                            }
                        ) {
                            viewModel.onEvent(OrderOptionsEvents.OnVolumeChange(2))
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "350", color = if (state.volume == 2) {
                                MainTheme.colorScheme.iconBack
                            } else {
                                gray2
                            }, style = MainTheme.typography.dmMedium
                        )
                    }
                    Spacer(Modifier.width(21.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        MyIcon(
                            R.drawable.cup_small, tintColor = if (state.volume == 3) {
                                MainTheme.colorScheme.iconBack
                            } else {
                                gray2
                            }
                        ) {
                            viewModel.onEvent(OrderOptionsEvents.OnVolumeChange(3))
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "450", color = if (state.volume == 3) {
                                MainTheme.colorScheme.iconBack
                            } else {
                                gray2
                            }, style = MainTheme.typography.dmMedium
                        )
                    }
                }
            }
            RowItem("Приготовить к определенному времени сегодня?", false) {
                Column(horizontalAlignment = Alignment.End) {
                    Toggle(state.specTime) {
                        viewModel.onEvent(OrderOptionsEvents.OnSpecTimeChange)
                    }
                    if (state.specTime) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(MainTheme.colorScheme.timePicker)
                        ) {
                            Text(
                                state.time,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 15.dp)
                            )
                        }
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
                    .background(green2)
                    .clickable{
                        navController.navigate(Route.Designer)
                    }
            ) {
                MyIcon(
                    R.drawable.constructor,
                    modifier = Modifier.padding(vertical = 18.dp, horizontal = 15.dp)
                )
                Text("Конструктор кофемана")
                Spacer(Modifier.weight(1f))
                MyIcon(R.drawable.next2)
                Spacer(Modifier.width(14.dp))
            }
            Spacer(Modifier.height(28.dp))
            Row {
                Text("Итоговая сумма")
                Spacer(Modifier.weight(1f))
                Text("${state.coast}")
            }
            Spacer(Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(blue3),
                contentAlignment = Alignment.Center
            ) {
                Text("Далее", modifier = Modifier.padding(vertical = 11.dp))
            }
        }
    }
}