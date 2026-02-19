package com.example.champ.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.champ.R

// Set of Material typography styles to start with
data class MyTypo(
    val welcome: TextStyle = TextStyle.Default,
    val authTextField: TextStyle = TextStyle.Default,
    val welcomeDesc: TextStyle = TextStyle.Default,
    val welcomeDesc2: TextStyle = TextStyle.Default,
    val loginText: TextStyle = TextStyle.Default,
    val robotoSB: TextStyle = TextStyle.Default,
    val dmMedium: TextStyle = TextStyle.Default,
    val poppinsSB: TextStyle = TextStyle.Default,
)

val fontR = FontFamily(Font(R.font.r_r, FontWeight.Normal))
val fontP = FontFamily(Font(R.font.poppins_m, FontWeight.Medium), Font(R.font.poppins_sb, FontWeight.SemiBold), )
val fontD = FontFamily(
    Font(R.font.dm_reg, FontWeight.Normal),
    Font(R.font.dm_medium, FontWeight.Medium),
)
val Typography = MyTypo(
    welcome = TextStyle(
        fontFamily = fontR,
        fontSize = 64.sp
    ),
    authTextField = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    welcomeDesc = TextStyle(
        fontFamily = fontP,
        fontWeight = FontWeight.Medium,
        fontSize = 25.sp
    ),
    welcomeDesc2 = TextStyle(
        fontFamily = fontD,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp
    ),

    loginText = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    robotoSB = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    dmMedium = TextStyle(
        fontFamily = fontD,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    poppinsSB = TextStyle(
        fontFamily = fontP,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
)