package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.authLineColor

@Composable
fun LeadingIcon(icon: Int) {
    val iconHeight = remember { mutableStateOf(0.dp) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        MyIcon(
            icon,
            tintColor = MainTheme.colorScheme.leadingIcon,
            modifier = Modifier
                .onGloballyPositioned {
                    val height = it.size.height.dp
                    iconHeight.value = height
                }
                .padding(horizontal = 12.dp)
        )
        Box(
            modifier = Modifier
                .height(iconHeight.value)
                .width(1.dp)
                .padding(bottom = 3.5.dp)
                .background(authLineColor)
        )
    }
}