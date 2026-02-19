package com.example.champ.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.bg

@Composable
fun ItemCard(url: String, title: String, desc: String, onClick: () -> Unit) {
    Column(modifier = Modifier.clickable{
        onClick()
//        navController.navigate(Route.Constructor(3))
    }) {
        MyAsync(
            url,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.FillWidth
        )
        Text(
            title,
            modifier = Modifier.padding(vertical = 7.dp),
            style = MainTheme.typography.welcomeDesc2,
            color = Color.Black
        )
        Text(
            desc,
            style = MainTheme.typography.welcomeDesc2.copy(fontSize = 10.sp, color = bg)
        )

    }
}