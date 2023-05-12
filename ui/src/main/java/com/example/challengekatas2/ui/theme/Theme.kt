package com.example.challengekatas2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = ChallengeKatas2Blue,
    primaryVariant = ChallengeKatas2Blue,
    secondary = ChallengeKatas2Green
)

private val LightColorPalette = lightColors(
    primary = ChallengeKatas2Blue,
    primaryVariant = ChallengeKatas2Blue,
    secondary = ChallengeKatas2Green
)

@Composable
fun ChallengeKatas2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val type = if (darkTheme) {
        TypographyDark
    } else {
        Typography
    }
    MaterialTheme(
        colors = colors,
        typography = type,
        shapes = Shapes,
        content = content
    )
}