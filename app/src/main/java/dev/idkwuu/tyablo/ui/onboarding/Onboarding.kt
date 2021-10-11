package dev.idkwuu.tyablo.ui.onboarding

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding
import dev.idkwuu.tyablo.OnboardingRoute
import dev.idkwuu.tyablo.ui.onboarding.steps.*
import dev.idkwuu.tyablo.ui.onboarding.steps.inputphone.InputPhone
import dev.idkwuu.tyablo.theming.ThemeViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Onboarding(
    onboardingViewModel: OnboardingViewModel = viewModel(),
    themeViewModel: ThemeViewModel
) {
    val loginNavController = rememberNavController()

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
}