package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val MoneyverseDarkColorScheme = darkColorScheme(
    primary = ImperialGoldPrimary,
    onPrimary = Color(0xFF1E1500),
    primaryContainer = Color(0xFF3E2C00),
    onPrimaryContainer = ChampagneAccent,
    
    secondary = SapphireTech,
    onSecondary = Color(0xFF001E31),
    secondaryContainer = Color(0xFF00344F),
    onSecondaryContainer = Color(0xFFC7E7FF),
    
    tertiary = EmeraldWealth,
    onTertiary = Color(0xFF002114),
    tertiaryContainer = Color(0xFF003824),
    onTertiaryContainer = Color(0xFF6FF7B5),
    
    background = LuxuryBackground,
    onBackground = TextHighEmphasis,
    
    surface = LuxurySurface,
    onSurface = TextHighEmphasis,
    surfaceVariant = LuxurySurfaceVariant,
    onSurfaceVariant = TextMediumEmphasis,
    
    outline = LuxuryCardBorder,
    outlineVariant = LuxuryCardBorderSubtle,
    error = CrimsonRisk,
    onError = Color.White
)

@Composable
fun MoneyverseTheme(
    darkTheme: Boolean = true, // Elite luxury theme is dark by default
    content: @Composable () -> Unit
) {
    val colorScheme = MoneyverseDarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                window.statusBarColor = LuxuryBackground.toArgb()
                window.navigationBarColor = LuxuryBackground.toArgb()
                val insetsController = WindowCompat.getInsetsController(window, view)
                insetsController.isAppearanceLightStatusBars = false
                insetsController.isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
