package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.champ.R
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.blue3
import com.example.champ.ui.theme.gray1
import com.example.champ.ui.theme.gray2
import com.example.champ.ui.theme.green1

@Composable
fun LoyaltyCard(rate: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(blue3)
            .padding(horizontal = 30.dp)
    ) {
        Row(modifier = Modifier.padding(top = 14.dp, bottom = 25.dp), verticalAlignment = Alignment.CenterVertically) {
            Text("Карта лояльности", style = MainTheme.typography.dmMedium, color = gray2)
            Spacer(Modifier.weight(1f))
            Text("$rate / 6", style = MainTheme.typography.dmMedium, color = gray2)
        }

        Row {

            Spacer(Modifier.width(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
                repeat(6) { i ->
                    MyIcon(
                        R.drawable.cup_reward, tintColor = if (i >= rate) {
                            gray1
                        } else {
                            LocalContentColor.current
                        }
                    )
                }
            }
            Spacer(Modifier.weight(1f))
            Text("16%", style = MainTheme.typography.welcomeDesc, color = green1)
        }
        Spacer(Modifier.height(49.dp))

    }
}