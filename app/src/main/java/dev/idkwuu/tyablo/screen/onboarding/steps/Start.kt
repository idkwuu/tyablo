package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R

@Composable
fun OnboardingStart(goNext: () -> Unit) {
    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
    ) {
        Column(
            Modifier.fillMaxHeight(0.9f),
            verticalArrangement = Arrangement.Bottom,
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
        }
        Card(
            backgroundColor = MaterialTheme.colors.onSurface,
            elevation = 0.dp,
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxWidth()
                .clickable {
                    goNext()
                },
            shape = MaterialTheme.shapes.large
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(24.dp)
            ) {
                Text("Get started", fontWeight = FontWeight.SemiBold)
            }
        }
    }
}