package dev.idkwuu.tyablo.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding
import com.google.android.material.color.MaterialColors
import dev.idkwuu.tyablo.OnboardingRoute
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.components.ThemeDialog
import dev.idkwuu.tyablo.enums.Theme
import dev.idkwuu.tyablo.screen.onboarding.steps.InputPhone
import dev.idkwuu.tyablo.screen.onboarding.steps.OnboardingStart
import dev.idkwuu.tyablo.screen.onboarding.steps.Verification
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

    Scaffold(
       topBar = {
           TopAppBar(
               backgroundColor = MaterialTheme.colors.background,
               contentColor = MaterialTheme.colors.onSurface,
               title = { },
               actions = {
                   IconButton(onClick = { isShowingThemeSelector = true }) {
                       Icon(
                           painterResource(if (isDarkModeActive == true) R.drawable.ic_moon else R.drawable.ic_sun),
                           contentDescription = ""
                       )
                   }
               },
               modifier = Modifier.statusBarsPadding(),
               elevation = 0.dp,
               navigationIcon = {
                   AnimatedVisibility(
                       visible = currentRoute != OnboardingRoute.Start.route,
                       enter = fadeIn(), exit = fadeOut()
                   ) {
                       IconButton(onClick = { loginNavController.navigateUp() }) {
                           Icon(
                               painterResource(R.drawable.ic_arrow_left),
                               contentDescription = ""
                           )
                       }
                   }
               }
           )
       }
    ) {
        NavHost(
            navController = loginNavController, 
            startDestination = OnboardingRoute.Start.route,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsWithImePadding()
        ) {
            composable(OnboardingRoute.Start.route) { OnboardingStart { loginNavController.navigate("inputPhone") }}
            composable(OnboardingRoute.InputPhone.route) { InputPhone { loginNavController.navigate("verification") } }
            composable(OnboardingRoute.Verification.route) { Verification { loginNavController.navigate("verification") } }
        }
    }

    if (isShowingThemeSelector) {
        ThemeDialog(
            onDismissRequest = { isShowingThemeSelector = false },
            setTheme = { themeViewModel.setThemeMode(it) },
            currentTheme = themeViewModel.themeMode.value ?: Theme.SYSTEM
        )
    }
}