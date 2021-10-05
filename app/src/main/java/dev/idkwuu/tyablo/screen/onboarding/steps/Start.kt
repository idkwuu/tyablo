package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.screen.onboarding.OnboardingButton

@Composable
fun OnboardingStart(goNext: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_map),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        FloatingActionButton(
            onClick = goNext,
            backgroundColor = MaterialTheme.colors.onSurface
        ) {
            Icon(
                painterResource(R.drawable.ic_arrow_right),
                contentDescription = "Next",
                tint = MaterialTheme.colors.surface
            )
        }
    }
}