package dev.idkwuu.tyablo.theming

import androidx.compose.animation.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.idkwuu.tyablo.enums.Theme

private fun getTheme(darkTheme: Boolean, accentOverride: Color? = null): Colors {
    val error = Color(0xFFB00020)
    val accent = accentOverride ?: Color(0xFF23529f)
    return if (darkTheme) {
        darkColors(
            primary = accent,
            primaryVariant = accent,
            secondary = accent,
            background = Color(0xFF121212),
            surface = Color(0xFF212121),
            error = error,
        )
    } else {
        lightColors(
            primary = accent,
            primaryVariant = accent,
            secondary = accent,
            background = Color(0xFFF5F5F5),
            surface = Color.White,
            error = error
        )
    }
}

private val shapes = Shapes(
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp)
)

private val typo = Typography(
    h6 = Typography().h6.copy(fontWeight = FontWeight.SemiBold)
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TyabloTheme(
    viewModel: ThemeViewModel,
    content: @Composable () -> Unit
) {
    val theme by viewModel.themeMode.observeAsState()
    val isDarkMode = when (theme) {
        Theme.LIGHT -> false
        Theme.DARK -> true
        else -> isSystemInDarkTheme() // System default
    }
    val systemUiController = rememberSystemUiController()

    SideEffect {
        viewModel.setIsDarkModeActive(isDarkMode)

        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !isDarkMode,
            isNavigationBarContrastEnforced = false
        )
    }

    MaterialTheme(
        colors = getTheme(isDarkMode),
        typography = typo,
        shapes = shapes
    ) {
        ProvideWindowInsets {
            content()
        }
    }
}