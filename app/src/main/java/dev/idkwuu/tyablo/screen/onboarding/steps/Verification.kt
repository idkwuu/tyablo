package dev.idkwuu.tyablo.screen.onboarding.steps

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.idkwuu.tyablo.R
import dev.idkwuu.tyablo.components.CustomTextInput
import dev.idkwuu.tyablo.components.WideButton

@Composable
fun Verification(goNext: () -> Unit) {
    var code by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                text = stringResource(R.string.onboarding_verification),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp),
                textAlign = TextAlign.Center
            )
            Text(
                stringResource(R.string.onboarding_verification_desc),
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
        }
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.TopCenter
        ) {
            CustomTextInput(
                text = code,
                onEdit = { if (it.length < 9) code = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                placeholder = { Text("12345678") },
                maxLines = 1
            )
        }
        WideButton(
            text = stringResource(R.string.next),
            onTap = { goNext() },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        WideButton(
            text = stringResource(R.string.go_back),
            onTap = {  },
            transparentBackground = true,
        )
    }
}