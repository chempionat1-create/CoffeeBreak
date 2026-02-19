package com.example.champ.my_order_history

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.BottomNav
import com.example.champ.common.MyAsync
import com.example.champ.common.MyIcon
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bgW
import com.example.champ.ui.theme.blue3
import com.example.champ.ui.theme.lineColor

@Composable
fun MyOrderHistoryScreen(navController: NavController) {

    Box() {
        Column(
            modifier = Modifier.padding(horizontal = 15.dp)
        ) {
            Spacer(Modifier.height(21.dp))
            Text(
                "История заказов",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyAsync(
                    "https://ytizrftfmlltuhekqnzg.supabase.co/storage/v1/object/public/coffees/latte.png",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 18.dp)
                        .heightIn(max = 48.dp),
                    contentScale = ContentScale.FillHeight
                )
                Column {
                    Text("Латте", style = MainTheme.typography.loginText, color = blue3)
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        MyIcon(R.drawable.location, tintColor = blue3.copy(alpha = 0.8f), modifier = Modifier.height(13.dp))
                        Spacer(Modifier.width(6.dp))
                        Text(
                            "г. Оренбург, ул. Чкалова 32",
                            modifier = Modifier.padding(vertical = 7.dp),
                            style = MainTheme.typography.welcomeDesc,
                            color = blue3,
                            fontSize = 10.sp
                        )
                    }
                    Text(
                        "24 июня | 12:30 | к 18:10 ",
                        style = MainTheme.typography.welcomeDesc,
                        color = blue3.copy(alpha = 0.22f),
                        fontSize = 10.sp
                    )
                }
                Spacer(Modifier.weight(1f))
                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        " 100 ₽",
                        style = MainTheme.typography.authTextField,
                        fontSize = 16.sp,
                        color = blue3
                    )
                    Spacer(Modifier.height(12.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(blue3)
                    ) {
                        Text(
                            stringResource(R.string.order),
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 15.dp)
                                .align(Alignment.Center),
                            style = MainTheme.typography.welcomeDesc.copy(
                                fontSize = 10.sp,
                                color = bgW
                            )
                        )
                    }
                }
                Spacer(Modifier.width(7.dp))
            }
            Row(modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(lineColor)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyAsync(
                    "https://ytizrftfmlltuhekqnzg.supabase.co/storage/v1/object/public/coffees/latte.png",
                    modifier = Modifier
                        .padding(start = 10.dp, end = 18.dp)
                        .heightIn(max = 48.dp),
                    contentScale = ContentScale.FillHeight
                )
                Column {
                    Text("Латте", style = MainTheme.typography.loginText, color = blue3)
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        MyIcon(R.drawable.location, tintColor = blue3.copy(alpha = 0.8f), modifier = Modifier.height(13.dp))
                        Spacer(Modifier.width(6.dp))
                        Text(
                            "г. Оренбург, ул. Чкалова 32",
                            modifier = Modifier.padding(vertical = 7.dp),
                            style = MainTheme.typography.welcomeDesc,
                            color = blue3,
                            fontSize = 10.sp
                        )
                    }
                    Text(
                        "24 июня | 12:30 | к 18:10 ",
                        style = MainTheme.typography.welcomeDesc,
                        color = blue3.copy(alpha = 0.22f),
                        fontSize = 10.sp
                    )
                }
                Spacer(Modifier.weight(1f))
                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        " 100 ₽",
                        style = MainTheme.typography.authTextField,
                        fontSize = 16.sp,
                        color = blue3
                    )
                    Spacer(Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(blue3)
                    ) {
                        Text(
                            stringResource(R.string.order),
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 15.dp)
                                .align(Alignment.Center),
                            style = MainTheme.typography.welcomeDesc.copy(
                                fontSize = 10.sp,
                                color = bgW
                            )
                        )
                    }
                }
                Spacer(Modifier.width(7.dp))
            }
            Spacer(Modifier.weight(1f))
        }
        BottomNav(navController, Route.MyOrder, modifier = Modifier.align(Alignment.BottomCenter))

    }
}