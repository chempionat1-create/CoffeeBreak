package com.example.champ.common

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Composable
fun MyIcon(icon: Int, tintColor: Color? = null, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Icon(
        imageVector = ImageVector.vectorResource(icon),
        null,
        tint = tintColor ?: LocalContentColor.current,
        modifier = modifier.clickable { onClick() })
}