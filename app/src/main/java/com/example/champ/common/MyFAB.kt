package com.example.champ.common

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.champ.R
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.green1

@Composable
fun MyFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick,
        shape = CircleShape,
        containerColor = green1,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp,
        )) {
        MyIcon(R.drawable.next, tintColor = MainTheme.colorScheme.bg)
    }
}