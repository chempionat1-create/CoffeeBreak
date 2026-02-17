package com.example.champ.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MyDialog(onDism: () -> Unit) {
    AlertDialog({ onDism() }, confirmButton = { Text("OK") }, )
}