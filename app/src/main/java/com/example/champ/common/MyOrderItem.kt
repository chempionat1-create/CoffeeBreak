package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.darkBlue
import com.example.champ.ui.theme.gray4

@Composable
fun MyOrderItem(url: String, text: String, desc: String, count: Int, coast: Int) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(gray4),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MyAsync(
            url,
            modifier = Modifier
                .padding(15.dp)
                .heightIn(max = 48.dp),
            contentScale = ContentScale.FillHeight
        )
        Column {
            Text(text, style = MainTheme.typography.authTextField, color = darkBlue)
            Text(
                desc,
                modifier = Modifier.padding(vertical = 7.dp),
                style = MainTheme.typography.loginText,
                color = Color(0xFF757575),
                fontSize = 10.sp
            )
            Text("x $count", style = MainTheme.typography.authTextField, color = Color.Black)
        }
        Spacer(Modifier.weight(1f))
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Text(
                "$coast ₽",
                style = MainTheme.typography.robotoSB,
                fontSize = 16.sp,
                color = darkBlue
            )
            Text("")
        }
        Spacer(Modifier.width(7.dp))
    }
}