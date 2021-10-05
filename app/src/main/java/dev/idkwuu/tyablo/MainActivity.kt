package dev.idkwuu.tyablo

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.idkwuu.tyablo.screen.onboarding.Onboarding
import dev.idkwuu.tyablo.state.GlobalData
import dev.idkwuu.tyablo.theming.ThemeViewModel
import dev.idkwuu.tyablo.theming.TyabloTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val themeViewModel: ThemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberNavController()
            TyabloTheme(themeViewModel) {
                Scaffold {
                    NavHost(
                        navController = navController,
                        startDestination = "onboarding",
                        modifier = Modifier.fillMaxSize()
                    ) {
                        composable("onboarding") { Onboarding() }
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        GlobalData.isAppActive.value = false
    }

    override fun onResume() {
        super.onResume()
        GlobalData.isAppActive.value = true
    }
}

