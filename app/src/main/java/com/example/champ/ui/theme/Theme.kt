package com.example.champ.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColorScheme(
    val bg: Color = Color.Unspecified,
    val welcomeDesc: Color = Color.Unspecified,
    val leadingIcon: Color = Color.Unspecified,
    val showIcon: Color = Color.Unspecified,
    val forgotPasText: Color = Color.Unspecified,
    val default: Color = Color.Unspecified,
    val registerLoginText: Color = Color.Unspecified,
    val loginWelcome: Color = Color.Unspecified,
    val cafeBg: Color = Color.Unspecified,
    val otpEmpty: Color = Color.Unspecified,
    val otp: Color = Color.Unspecified,
    val navActiveIcon: Color = Color.Unspecified,
    val menuBg: Color = Color.Unspecified,
    val icon: Color = Color.Unspecified,
    val profileBox: Color = Color.Unspecified,
    val iconBack: Color = Color.Unspecified,
    val topBarText: Color = Color.Unspecified,
    val orderBox: Color = Color.Unspecified,
    val orderRowText: Color = Color.Unspecified,
    val orderRoundedBox: Color = Color.Unspecified,
    val orderRound: Color = Color.Unspecified,
    val timePicker: Color = Color.Unspecified,
    val statusTrue: Color = Color.Unspecified,
)

private val darkColorScheme = CustomColorScheme(
    bg = bgB,
    welcomeDesc = bgW,
    leadingIcon = b1,
    showIcon = eyeColor,
    forgotPasText = blue3,
    default = bgW,
    registerLoginText = b1,
    loginWelcome = b3,
    cafeBg = navMenu,
    otpEmpty = otpEmpty2,
    otp = Color(0xFF426A83),
    navActiveIcon = b1,
    menuBg = bg,
    icon = b1,
    profileBox = dark2,
    iconBack = b1,
    topBarText = b2,
    orderBox = bgW,
    orderRowText = b1,
    orderRoundedBox = gray2,
    orderRound = bg,
    timePicker = Color.Transparent,
    statusTrue = Color(0xFF33E545),

)
private val lightColorScheme = CustomColorScheme(
    bg = bgW,
    welcomeDesc = dark,
    leadingIcon = green2,
    showIcon = Color.Black,
    forgotPasText = green2,
    default = Color.Black,
    registerLoginText = green1,
    loginWelcome = blue3,
    cafeBg = bgW,
    otpEmpty = otpEmpty,
    otp = otpEmpty2,
    navActiveIcon = blue3,
    menuBg = navMenu,
    icon = darkBlue,
    profileBox = gray3,
    iconBack = Color.Black,
    topBarText = darkBlue,
    orderBox = gray4,
    orderRowText = dark3,
    orderRoundedBox = gray2.copy(alpha = 0.4f),
    orderRound = bgB,
    timePicker = Color(0xFF767680),
    statusTrue = green1,



)
val LocalColorProvider = staticCompositionLocalOf { CustomColorScheme() }

@Composable
fun CoffeeBreakTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val scheme = if (isDark) {
        darkColorScheme
    } else {
        lightColorScheme
    }
    CompositionLocalProvider(
        LocalColorProvider provides scheme,
        content = content

    )

}

object MainTheme {
    val colorScheme: CustomColorScheme
        @Composable
        get() = LocalColorProvider.current
    val typography: MyTypo
        @Composable @ReadOnlyComposable
        get() = Typography
}