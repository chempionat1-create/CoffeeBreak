package com.example.champ.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.champ.R
import com.example.champ.ui.theme.MainTheme
import com.example.champ.ui.theme.b3
import com.example.champ.ui.theme.lineColor

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    icon: Int,
) {
    val isShow = remember { mutableStateOf(true) }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(30.dp)) {
        BasicTextField(
            value = value, onValueChange = onValueChange, visualTransformation = if (isShow.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            decorationBox = { itf ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    LeadingIcon(icon)
                    Spacer(Modifier.width(19.dp))
                    if (value.isBlank()) {
                        Text(placeholder, style = MainTheme.typography.authTextField.copy(color = b3))
                    } else {
                        itf.invoke()
                    }
                    Spacer(Modifier.weight(1f))
                    if (isPassword) {
                        MyIcon(R.drawable.show, tintColor = MainTheme.colorScheme.showIcon) {
                            isShow.value = !isShow.value
                        }
                    }
                }
//                itf()
            },
            textStyle = MainTheme.typography.authTextField.copy(color = b3),
            cursorBrush = SolidColor(Color.Transparent)

        )
        Box(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(lineColor)
                .align(Alignment.BottomCenter)
        )
    }
}