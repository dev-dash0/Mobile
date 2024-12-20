package com.elfeky.devdash.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = NavyBlue,
    secondary = Black,
    tertiary = Pink80,
    background = NavyBlue,
    onBackground = Color.White,
    onSurface = LightNavyBlue,
    onPrimary = Color.White,
    primaryContainer = NavyBlue
)

private val LightColorScheme = lightColorScheme(
    primary = NavyBlue,
    secondary = Color.White,
    tertiary = Pink80,
    background = NavyBlue,
    onBackground = Black,
    onSurface = LightNavyBlue,
    onPrimary = Color.White
)

@Composable
fun DevDashTheme(
    darkTheme: Boolean = true,//isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}