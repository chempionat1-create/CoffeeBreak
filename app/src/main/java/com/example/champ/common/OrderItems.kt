package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bgW
import com.example.champ.ui.theme.gray2
import com.example.champ.ui.theme.green1
import com.example.champ.ui.theme.lineColor

@Composable
fun RowItem(text: String, isLine: Boolean = true, content: @Composable () -> Unit) {
    Box() {

        Row(
            modifier = Modifier.padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text,
                style = MainTheme.typography.dmMedium,
                color = MainTheme.colorScheme.orderRowText,
                modifier = Modifier.widthIn(max = 210.dp)
            )
            Spacer(Modifier.weight(1f))
            content()
        }
        if (isLine) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(lineColor)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun Toggle(isChecked: Boolean, onClick: () -> Unit) {
    if (isChecked) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(22.dp))
                .size(height = 31.dp, width = 51.dp)
                .background(
                    green1
                )
                .clickable{
                    onClick()
                }
        ) {
            Box(modifier = Modifier
                .padding(end = 2.dp)
                .clip(CircleShape)
                .background(bgW)
                .align(Alignment.CenterEnd)
                .size(27.dp)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(22.dp))
                .size(height = 31.dp, width = 51.dp)
                .background(
                    gray2
                )
                .clickable{
                    onClick()
                }
        ) {
            Box(modifier = Modifier
                .padding(end = 2.dp)
                .clip(CircleShape)
                .background(bgW)
                .align(Alignment.CenterStart)
                .size(27.dp)

            )
        }
    }
}