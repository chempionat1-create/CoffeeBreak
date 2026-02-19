package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.champ.R
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bgW

@Composable
fun FeedbackComponent(rate: Int, onDism: () -> Unit, onRateChange: (Int) -> Unit, onSetRate: (Int) -> Unit) {

    Row {
        Spacer(Modifier.width(38.dp))
        Dialog({ onDism() }) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(bgW),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(18.dp))
                Text(
                    stringResource(R.string.order_done),
                    style = MainTheme.typography.poppinsSB,
                    color = Color.Black
                )
                Text(
                    stringResource(R.string.feedback),
                    style = MainTheme.typography.welcomeDesc.copy(fontSize = 16.sp),
                    color = Color.Black
                )
                Spacer(Modifier.height(18.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFCFCFCF))
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(25.dp),
                    modifier = Modifier.padding(vertical = 24.dp)
                ) {
                    repeat(5) { i ->
                        MyIcon(
                            R.drawable.star, tintColor =
                                if (i >= rate) {
                                    Color(0xFFC7C7CC)
                                } else {
                                    Color(0xFFFF9500)
                                }
                        ) {
                            onRateChange(i + 1)
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFCFCFCF))
                )
                Text(
                    stringResource(R.string.rate),
                    modifier = Modifier
                        .padding(vertical = 18.dp)
                        .clickable {
                            onSetRate(rate)
                        },
                    style = MainTheme.typography.loginText,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFCFCFCF))
                )
                Text(
                    stringResource(R.string.no_thns),
                    modifier = Modifier
                        .padding(vertical = 18.dp)
                        .clickable {
                            onDism()
                        },
                    style = MainTheme.typography.loginText,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
        Spacer(Modifier.width(38.dp))
    }
}