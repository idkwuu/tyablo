package dev.idkwuu.tyablo.screen.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.android.material.color.MaterialColors
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.enums.Theme
import dev.idkwuu.tyablo.screen.onboarding.steps.InputPhone
import dev.idkwuu.tyablo.screen.onboarding.steps.OnboardingStart
import dev.idkwuu.tyablo.screen.onboarding.steps.Verification
import dev.idkwuu.tyablo.theming.ThemeViewModel

@Composable
fun Onboarding(
    onboardingViewModel: OnboardingViewModel = viewModel()
) {
    val loginNavController = rememberNavController()

    Box(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxSize()
            .navigationBarsWithImePadding()
    ) {
        NavHost(navController = loginNavController, startDestination = "start") {
            composable("start") { OnboardingStart { loginNavController.navigate("inputPhone") }}
            composable("inputPhone") { InputPhone { loginNavController.navigate("verification") } }
            composable("verification") { Verification { loginNavController.navigate("verification") } }
        }
    }


}