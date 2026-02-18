package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.champ.R
import com.example.champ.ui.theme.bgW
import com.example.champ.ui.theme.blue3

@Composable
fun PointsCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(blue3)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 25.dp, horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Мои баллы:")
                Spacer(Modifier.height(6.dp))
                Text("240")
            }
            Spacer(Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0x19A2CDE9))
            ) {
                Text("Оплатить баллами", modifier = Modifier.padding(7.dp))
            }
        }
        MyIcon(
            R.drawable.beans, tintColor = bgW.copy(alpha = 0.26f), modifier = Modifier.align(
                Alignment.BottomEnd
            )
        )
    }
}