package com.netforge.app.ui.theme

import androidx.compose.foundation.isSystemInDarkMode
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF7C5CFF),
    secondary = Color(0xFFFF6B4A),
    background = Color(0xFF16161D),
    surface = Color(0xFF1E1E28),
    error = Color(0xFFF87171)
)

@Composable
fun Theme(
    darkTheme: Boolean = isSystemInDarkMode(),
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = NetForgeTypography,
        content = content
    )
}
