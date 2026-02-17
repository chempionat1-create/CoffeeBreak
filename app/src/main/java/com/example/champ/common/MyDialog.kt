package com.example.champ.common

import androidx.compose.foundation.clickable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyDialog(isShow: Boolean, text: String, onDism: () -> Unit) {
    if (isShow) {
        AlertDialog(
            { onDism() },
            confirmButton = {
                Text("OK", modifier = Modifier.clickable {
                    onDism()
                })
            },
            title = { Text("Ошибка") },
            text = { Text(text) }
        )
    }
}