package dev.idkwuu.tyablo.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding
import dev.idkwuu.tyablo.OnboardingRoute
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.components.ThemeDialog
import dev.idkwuu.tyablo.enums.Theme
import dev.idkwuu.tyablo.screen.onboarding.steps.*
import dev.idkwuu.tyablo.screen.onboarding.steps.inputphone.InputPhone
import dev.idkwuu.tyablo.theming.ThemeViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Onboarding(
    onboardingViewModel: OnboardingViewModel = viewModel(),
    themeViewModel: ThemeViewModel
) {
    val loginNavController = rememberNavController()
    val navBackStackEntry by loginNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: OnboardingRoute.Start.route
    val isDarkModeActive by themeViewModel.isDarkModeActive.observeAsState()
    var isShowingThemeSelector by remember { mutableStateOf(false) }

    NavHost(
        navController = loginNavController,
        startDestination = OnboardingRoute.Start.route,
        modifier = Modifier
            .padding(top = 36.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsWithImePadding()
    ) {
        composable(OnboardingRoute.Start.route) { OnboardingStart { loginNavController.navigate(OnboardingRoute.InputPhone.route) }}
        composable(OnboardingRoute.InputPhone.route) { InputPhone { loginNavController.navigate(OnboardingRoute.Verification.route) } }
        composable(OnboardingRoute.Verification.route) { Verification { loginNavController.navigate(OnboardingRoute.NewUser.route) } }
        composable(OnboardingRoute.NewUser.route) { NewUser { loginNavController.navigate(OnboardingRoute.LocationPermission.route) } }
        composable(OnboardingRoute.LocationPermission.route) { LocationPermission { loginNavController.navigate(OnboardingRoute.Discovery.route) }}
        composable(OnboardingRoute.Discovery.route) { Discovery {  } }
    }

    if (isShowingThemeSelector) {
        ThemeDialog(
            onDismissRequest = { isShowingThemeSelector = false },
            setTheme = { themeViewModel.setThemeMode(it) },
            currentTheme = themeViewModel.themeMode.value ?: Theme.SYSTEM
        )
    }
}