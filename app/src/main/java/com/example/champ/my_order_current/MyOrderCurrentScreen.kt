package com.example.champ.my_order_current

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.champ.R
import com.example.champ.Route
import com.example.champ.common.BottomNav
import com.example.champ.common.MyAsync
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.blue3
import com.example.champ.ui.theme.lineColor

@Composable
fun MyOrderCurrentScreen(navController: NavController) {
    Box() {
        Column(
        ) {
            Spacer(Modifier.height(21.dp))
            Text(
                stringResource(R.string.current_order),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(lineColor)
            )
            Column(modifier = Modifier.padding(horizontal = 22.dp)) {
                Spacer(Modifier.height(20.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MyAsync(
                        "https://ytizrftfmlltuhekqnzg.supabase.co/storage/v1/object/public/coffees/latte.png",
                        modifier = Modifier
                            .heightIn(max = 44.dp),
                        contentScale = ContentScale.FillHeight
                    )
                    Spacer(Modifier.width(18.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Латте", style = MainTheme.typography.loginText, color = blue3)
                            Spacer(Modifier.width(4.dp))
                            Text(
                                "x1",
                                style = MainTheme.typography.welcomeDesc,
                                color = blue3.copy(alpha = 0.22f),
                                fontSize = 10.sp
                            )
                        }
                        Text(
                            "24 июня | 12:30 | к 18:10 ",
                            modifier = Modifier.padding(top = 10.dp),
                            style = MainTheme.typography.welcomeDesc,
                            color = blue3.copy(alpha = 0.22f),
                            fontSize = 10.sp
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Column(verticalArrangement = Arrangement.SpaceEvenly) {
                        Text(
                            "100 ₽",
                            style = MainTheme.typography.authTextField,
                            fontSize = 16.sp,
                            color = blue3
                        )
                        Text("")
                    }
                    Spacer(Modifier.width(5.dp))
                }
                Spacer(Modifier.height(35.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(lineColor)
                )
            }
            Spacer(Modifier.weight(1f))
        }
        BottomNav(navController, Route.Menu(), modifier = Modifier.align(Alignment.BottomCenter))
    }
}