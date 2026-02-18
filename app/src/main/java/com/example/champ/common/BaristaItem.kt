package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.red

@Composable
fun BaristaItem(url: String, name: String, desc: String, status: Boolean, onClick: () -> Unit) {
    Row(modifier = Modifier.clickable{
        onClick()
    }.shadow(4.dp, ambientColor = Color.Black), verticalAlignment = Alignment.CenterVertically) {
        MyAsync(
            url, modifier = Modifier
                .size(62.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(16.dp)), contentScale = ContentScale.FillHeight
        )
        Spacer(Modifier.width(7.dp))
        Column {
            Text(name, style = MainTheme.typography.loginText, color = Color(0xFF09051C))
            Spacer(Modifier.height(12.dp))
            Text(desc, style = MainTheme.typography.welcomeDesc.copy(fontSize = 12.sp), color = Color(0xFF3B3B3B))
        }
        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(15.dp)
                .background(
                    if (status) {
                        MainTheme.colorScheme.statusTrue
                    } else {
                        red
                    }
                )
        )
        Spacer(Modifier.width(24.dp))
    }
}