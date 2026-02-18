package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.champ.ui.theme.MainTheme

@Composable
fun ProfileItem(
    icon: Int, title: String,
    text: String, endIcon: Int, onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.clickable {
            onClick()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(42.dp)
                .background(MainTheme.colorScheme.profileBox),
            contentAlignment = Alignment.Center
        ) {
            MyIcon(icon, modifier = Modifier.padding(13.dp), tintColor = MainTheme.colorScheme.navActiveIcon)
        }
        Spacer(Modifier.width(16.dp))
        Column {
            Text(title)
            Text(text)
        }
        Spacer(Modifier.weight(1f))
        MyIcon(endIcon)
    }
}